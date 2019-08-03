package cn.saul.net.udpClientServer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	public static void main(String[] args) {
		DatagramSocket aSocket  = null;
		try {
			aSocket = new DatagramSocket(7777);
			byte[] buffer = new byte[1024];
			while(true) {
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				System.out.println("received request:" + request.getAddress() + " -> " + new String(request.getData()));
				DatagramPacket repley = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
				aSocket.send(repley);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (aSocket != null) {
				aSocket.close();
			}
		}
	}
}
