package cn.saul.net.commnunicationTwoClient;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		PrintStream sender = null;
		Scanner receiver = null;
		Scanner inputMessage = new Scanner(System.in);
		Gson gson = new Gson();
		boolean flag = true;
		ExecutorService executors = Executors.newSingleThreadExecutor();
		try {
			socket = new Socket("localhost", 8888);
			System.out.println("connect server successfully!");
			sender = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
			receiver = new Scanner(socket.getInputStream());
			
			//login 
			System.out.println("please input your name:");
			String name = inputMessage.nextLine();
			Message message = new Message();
			message.setFrom(name);
			message.setType(MessageType.TYPE_LOGIN);
			sender.println(gson.toJson(message));
			sender.flush();
			Message fromJson = gson.fromJson(receiver.nextLine(), Message.class);
			System.out.println(fromJson.getInfo());
			
			//receive message from another client
			executors.execute(new ReceiveInfo(receiver));
			
			//send message to another client in main thread
			while(flag) {
				message = new Message();
				message.setFrom(name);
				message.setType(MessageType.TYPE_MESSAGE);
				System.out.println("to: ");
				String toName = inputMessage.nextLine();
				message.setTo(toName);
				System.out.println("infomation you need to send:");
				String info = inputMessage.nextLine();
				message.setInfo(info);
				sender.println(gson.toJson(message));
				sender.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sender.close();
			receiver.close();
			inputMessage.close();
		}
		
	}
}

class ReceiveInfo implements Runnable{
	private @Getter Scanner receiver;
	private @Setter boolean flag;
	
	public ReceiveInfo(Scanner receiver) {
		super();
		this.receiver = receiver;
		flag = true;
	}
	
	@Override
	public void run() {
		Gson gson = new Gson();
		while(flag) {
			String receiveString = receiver.nextLine();
			Message message = gson.fromJson(receiveString, Message.class);
			System.out.println("[" +message.getFrom() + " said to you:]" + message.getInfo());
		}
	}
	
}