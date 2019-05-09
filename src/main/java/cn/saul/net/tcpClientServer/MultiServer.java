package cn.saul.net.tcpClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 处理多个客户端和服务器连接
 * 
 * @author Saul
 * 2019-05-09
 *
 */
public class MultiServer {
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("服务器已启动，正在等待连接...");
			while(true){
				Socket socket = serverSocket.accept();
				executorService.execute(new UserThread(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	
}
/**
 * 用来处理客户端请求端线程
 * 
 * @author Saul
 * 2019-05-10
 *
 */
class UserThread implements Runnable{
	private Socket socket;
	public UserThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		BufferedReader bReader = null;
		PrintStream pStream = null;
		try {
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pStream = new PrintStream(socket.getOutputStream());
			String message = bReader.readLine();
			System.out.println(message);
			pStream.println("echo: " + message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bReader != null){
					bReader.close();
				}
				if (pStream != null) {
					pStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
