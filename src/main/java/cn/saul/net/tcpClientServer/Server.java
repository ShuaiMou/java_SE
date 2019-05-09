package cn.saul.net.tcpClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务器端
 * 
 * @author Saul
 * 2019-05-09
 *
 */
public class Server {
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintStream pStream = null;
		try {
			//创建一个服务器端的Socket（port: 1024 - 65535）
			serverSocket = new ServerSocket(8888);
			System.out.println("服务器已启动，正在等待客户端的连接...");
			//等待客户端的连接，造成阻塞，如果有客户端连接成功，立即返回一个Socket对象。
			Socket socket = serverSocket.accept();
			System.out.println("客户端连接成功: " + socket.getInetAddress().getHostName() );
		
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pStream = new PrintStream(socket.getOutputStream());
			//通过缓冲字符输入流读取网络数据，如果没有数据，会阻塞。
			String message = reader.readLine();
			System.out.println(message);
			//通过字节打印流，向客户端返回消息。
			pStream.println("echo: "+ message);
			pStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (reader != null) {
					reader.close();
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
