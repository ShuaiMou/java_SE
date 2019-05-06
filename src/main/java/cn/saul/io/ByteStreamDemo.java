package cn.saul.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节输出输入流
 * 输出流： 超类 OutputStream, 对文件的输出流使用子类FileOutputStream
 * 输入流:  超类 InputStream， 对文件的输入流使用子类FileInputStream
 * 
 * 字节操作流，默认每次执行写入操作会直接把数据写入文件
 * @author moushuai
 *
 */
public class ByteStreamDemo {
	
	private static void out(){
		//0.确定目标文件
		File file = new File("/Users/moushuai/desktop/testio.txt");
		//1.构建一个文件输出流对象
		try {
			OutputStream out = new FileOutputStream(file,true);//append 为true表示追加内容
			//2.输出的内容
			String message = "good morning, xiaoLin\r\n"; //\r\n表示换行
			String line = System.getProperty("line.separator");//获取换行符
			message = message + line;
			//3.把内容写入到文件
			out.write(message.getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void in(){
		//0.确定目标文件
		File file = new File("/Users/moushuai/desktop/testio.txt");
		//1.构建一个文件输入流对象
		try {
			InputStream in = new FileInputStream(file);
			byte[] bytes = new byte[7];
			StringBuilder builder = new StringBuilder();
			int len = -1;  //每次读取的字节长度
			//把数据读入到数组中，并返回读取的字节数，当不等于-1时，表示读取到数据，等于-1
			//表示文件已经读完
			while((len = in.read(bytes)) != -1){
				//根据读取到的字节数组，再转换为字符串内容,添加到 StringBuilder中
				builder.append(new String(bytes,0,len));
			}
			in.close();
			System.out.println(builder);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件的复制： 一边读，一边写
	 * 从一个输入流中读取数据，然后同时通过输出流写入目标位置
	 * @param src
	 * @param des
	 */
	private static void copy(String src, String des){
		File srcFile = new File(src);
		File desFile = new File(des);
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(desFile);
			int len = -1;
			byte[] bytes = new byte[1024];
			while((len = in.read(bytes)) != -1){
				out.write(bytes, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		out();
		in();
		copy("/Users/moushuai/Desktop/testio.txt", "/Users/moushuai/Desktop/unimelb/testio.txt");
	}
}
