package cn.saul.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * properties可以用来做配置文件
 * java web javaee开发中通常会用到
 * @author moushuai
 *
 */
public class PropertiesDemo {
	public static String userName;
	public static String password;
	public static int age;
	
	static {
		//readConfig();
	}
	
	public static void readConfig() {
		Properties properties = new Properties();
		try {
			//读取包里对配置文件，通过当前线程对类加载器对象，来加载指定包下对文件。
			//InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			InputStream in = new FileInputStream("config.properties");
			properties.load(in);
			userName = properties.getProperty("username");
			password = properties.getProperty("password");
			age = Integer.parseInt(properties.getProperty("age"));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 对properties配置文件对写入
	 * @param userName
	 * @param password
	 * @param age
	 */
	public static void writeConfig( String userName, String password, String age ) {
		Properties properties = new Properties();
		properties.put("username", userName);
		properties.put("password", password);
		properties.put("age", age);
		try {
			OutputStream out = new FileOutputStream("config.properties");
			properties.store(out, "update config");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		writeConfig("joey","123456","9");
		readConfig();
		System.out.println(PropertiesDemo.userName);
		System.out.println(PropertiesDemo.password);
		System.out.println(PropertiesDemo.age);
		
	}
}
