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
		TestObjectStreamStudent student1 = new TestObjectStreamStudent("alex", "male", 19);
		TestObjectStreamStudent[] array = new TestObjectStreamStudent[10];
		array[0] = student;
		array[1] = student1;
		File file = new File("/Users/moushuai/desktop/student.txt");
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream ois = new ObjectOutputStream(os);
			ois.writeObject(array);
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
			TestObjectStreamStudent[] arry = (TestObjectStreamStudent[]) ois.readObject();
			System.out.println(arry[0].getAge());
			System.out.println(arry[1]);
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
		//objectOutStream();
		objectInStream();
	}
}
