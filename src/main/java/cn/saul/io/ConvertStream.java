package cn.saul.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
/**
 * 转换流：
 * OutputStreamWriter: 可以将输出的字符流转换为字节流的输出形式
 * InputStreamReader: 将输入的字节流转换为字符流输入形式.
 * 
 * @author Saul
 * 2019-05-02
 *
 */

public class ConvertStream {
	/**
	 * 如果传入的是字节流，但是读取的是文本文档
	 * 可以将字节流转换为字符流
	 * @param in
	 */
	private static void read(InputStream in){
		//可以在new的时候可以指定字符编码。
		//如：new InputStreamReader(in,Charset.forName("UTF-8"));
		Reader reader = new InputStreamReader(in);
		char[] cs = new char[1024];
		int len = -1;
		try {
			while((len = reader.read(cs)) != -1){
				System.out.println(new String(cs,0,len));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void write(OutputStream out){
		Writer writer = new OutputStreamWriter(out);
		try {
			writer.write("hellow!!!");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("/Users/moushuai/desktop/testio.txt");
			OutputStream out = new FileOutputStream("/Users/moushuai/desktop/testio.txt",true);
 			write(out);
			read(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
