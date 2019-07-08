package cn.saul.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * 字节数组流：
 * 基于内存操作，内部维护着一个字节数组，我们可以利用流的读取机制来处理字符串
 * 无需关闭
 * 
 * @author Saul
 * 2019-05-11
 *
 */

public class ByteArrayStream {
	private static void byteArray(){
		String str = "123667jidis><//ndfskf434";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int curr = -1;
		while((curr = bais.read()) != -1){
			if((curr > 'a' && curr < 'z') || (curr > 'A' && curr < 'Z')){
				baos.write(curr);
			}
		}
		//无需关闭流，字节数组流是基于内存的操作流
		System.out.println(baos.toString());
	}
	
	public static void main(String[] args) {
		byteArray();
	}
}
