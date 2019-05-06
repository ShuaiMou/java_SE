package cn.saul.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestObjectStream {
	private static void objectOutStream(){
		TestObjectStreamStudent student = new TestObjectStreamStudent("saul", "male", 18);
		File file = new File("/Users/moushuai/desktop/student.txt");
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream ois = new ObjectOutputStream(os);
			ois.writeObject(student);
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void objectInStream(){
		File file = new File("/Users/moushuai/desktop/student.txt");
		try {
			InputStream os = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(os);
			System.out.println(ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		objectOutStream();
		objectInStream();
	}
}
