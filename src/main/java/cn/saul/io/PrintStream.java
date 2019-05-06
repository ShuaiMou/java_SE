package cn.saul.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class PrintStream {
	private static void bytePrint(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			OutputStream os = new FileOutputStream(file,true);
			PrintWriter bWriter = new PrintWriter(os);
			bWriter.println("\ntest bytePrint");
			bWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void charPrint(){
		File file = new File("/Users/moushuai/desktop/testio.txt");
		try {
			Writer writer = new FileWriter(file,true);
			PrintWriter pWriter = new PrintWriter(writer);
			pWriter.println("\ntest charPrint!!");
			pWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//bytePrint();
		charPrint();
	}
}
