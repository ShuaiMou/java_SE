package cn.saul.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class BufferedStream {
	private static void byteIn(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] cs = new byte[1024];
			int len = -1;
			StringBuilder sbBuilder = new StringBuilder();
			while((len = bis.read(cs)) != -1){
				sbBuilder.append(new String(cs,0,len));
			}
			System.out.println(sbBuilder);
			System.out.println(sbBuilder.indexOf("so"));
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void charIn(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			Reader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			char[] chars = new char[10];
			int len = -1;
			StringBuilder stringBuilder = new StringBuilder();
			while((len = br.read(chars)) != -1){
				stringBuilder.append(new String(chars,0,len));
			}
			System.out.println(stringBuilder);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void byteOut(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			OutputStream os = new FileOutputStream(file,true);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			String str = "test byteOut";
			bos.write(str.getBytes());
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void charOut(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			Writer writer = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("  test charOut");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		byteIn();
		charOut();
		charIn();
		byteOut();
	}
}
