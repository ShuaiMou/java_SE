package cn.saul.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流：
 * 字符输出流： Writer，对文件的操作使用 FileWriter
 * 字符输入流： Reader, 对文件的操作使用子类 FileReader
 * 每次操作的单位是一个字符
 * 文件字符操作流会自带缓存，默认大小1024字节，在缓存满后或手动刷新缓存或者关闭流时，
 * 会把数据写入文件。
 * 
 * 如何选择字节流还是字符流：
 * 一般操作非文本文件时，使用字节流，比如图片，视频。操作文本文件时，建议使用字符流。
 * @author moushuai
 *
 */
public class CharStreamDemo {
	private static void out(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			Writer writer = new FileWriter(file,true);
			writer.write(",so good");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void in(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			Reader reader = new FileReader(file);
			char[] c = new char[4];
			int len = -1;
			StringBuilder sBuilder = new StringBuilder();
			while((len = reader.read(c)) != -1){
				sBuilder.append(new String(c,0,len)); 
			}
			System.out.println(sBuilder);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		in();
		out();
	}
}
