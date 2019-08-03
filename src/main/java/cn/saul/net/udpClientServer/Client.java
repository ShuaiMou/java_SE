package cn.saul.net.udpClientServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		DatagramSocket dSocket = null;
		Scanner input = new Scanner(System.in);
		System.out.println("please input the message, hostname, server port in sequence(separated by comas):");
		String[] parameters = input.nextLine().split(",");
	
		try {
			dSocket = new DatagramSocket();
			byte[] message = parameters[0].getBytes();
			InetAddress aHost = InetAddress.getByName(parameters[1]);
			int serverPort = Integer.parseInt(parameters[2]);
			
			DatagramPacket request = new DatagramPacket(message, message.length, aHost, serverPort);
			dSocket.send(request);
			
			byte[] buffer = new byte[1024];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			dSocket.receive(reply);
			System.out.println("reply: " + new String(reply.getData()));
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (dSocket != null) {
				dSocket.close();
			}
			input.close();
		}
		
	}
}
