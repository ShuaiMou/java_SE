package cn.saul.net.tcpClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * 
 * @author Saul
 * 2019-05-09
 *
 */
public class Client {
	private static Socket socket;

	public static void main(String[] args) {
		PrintStream pStream = null;
		BufferedReader bReader = null;
		Scanner input = null;
		try {
			//创建一个Socket对象，指定要连接的服务器
			socket = new Socket("localhost",8888);
			//获取Socket的输出输入流
			pStream = new PrintStream(socket.getOutputStream());
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			input = new Scanner(System.in);
			String message = input.nextLine();
			pStream.println(message);
			pStream.flush();
			//读取服务器返回的数据
			String info = bReader.readLine();
			System.out.println(info);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pStream != null) {
					pStream.close();
				}
				if(bReader != null){
					bReader.close();
				}
			} catch (Exception e2) {
			}
		}
	}
}
