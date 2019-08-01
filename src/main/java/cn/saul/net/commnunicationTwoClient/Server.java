package cn.saul.net.commnunicationTwoClient;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		//store clients' thread
		Hashtable<String, UserThread> threads = new Hashtable<String, UserThread>(6);
		ExecutorService executors = Executors.newFixedThreadPool(6);
		try {
			//create server socket
			serverSocket = new ServerSocket(8888);
			System.out.println("the server has been started, waiting for connection...");
			while(true) {
				Socket socket = serverSocket.accept();
				UserThread userThread = new UserThread(socket,threads);
				executors.execute(userThread);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


class UserThread implements Runnable{
	//clients' username(unique)
	private @Getter String threadName; 
	private Hashtable<String, UserThread> threads;
	private Socket socket;
	private @Getter PrintStream sender;
	private  Scanner receiver;
	private @Setter boolean flag;
	
	UserThread(Socket socket, Hashtable<String, UserThread> threads) {
		super();
		this.socket = socket;
		this.threads = threads;
		flag = true;
	}


	@Override
	public void run() {
		System.out.println("client " + socket.getInetAddress().getHostAddress() + " has connected");
		try {
			sender = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
			receiver = new Scanner(socket.getInputStream());
			
			while(flag) {
				//receive a json string 
				String messageString = receiver.nextLine();
				//convert json string to associate object
				Gson gson = new Gson();
				Message message = gson.fromJson(messageString, Message.class);
				switch (message.getType()) {
				case MessageType.TYPE_LOGIN:
					this.threadName = message.getFrom();
					threads.put(this.threadName, this);
					message.setInfo("dear "+ message.getFrom()+": welcome to login online communication");
					String jsonMessage = gson.toJson(message);
					sender.println(jsonMessage);
					sender.flush();
					break;
					
				case MessageType.TYPE_MESSAGE:
					UserThread to = threads.get(message.getTo());
					to.getSender().println(messageString);
					to.getSender().flush();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sender.close();
			receiver.close();
		}
		
	}
	
}