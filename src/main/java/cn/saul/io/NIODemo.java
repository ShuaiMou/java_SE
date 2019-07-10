package cn.saul.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 比较IO操作的性能比较：
 * 	1.内存映射最快
 *  2.NIO读写文件
 *  3.使用了缓存的IO流
 *  4.无缓存的IO流
 * @author moushuai
 *
 */

public class NIODemo {
	/**
	 * 通过文件的映射去实现拷贝
	 * @param srcFilePath
	 * @param destFilePath
	 * @throws IOException
	 */
	public static void randomAccessFile(String srcFilePath, String destFilePath) throws IOException {
		RandomAccessFile in = new RandomAccessFile(srcFilePath, "r");
		RandomAccessFile out = new RandomAccessFile(destFilePath, "rw");
		
		FileChannel fcin = in.getChannel();
		FileChannel fcout = out.getChannel();
		
		long size = fcin.size(); //输入流的字节大小
		//输入流缓冲区
		MappedByteBuffer inBuffer = fcin.map(MapMode.READ_ONLY, 0, size);
		//输出流缓冲区
		MappedByteBuffer outBuffer = fcout.map(MapMode.READ_WRITE, 0, size);
		
		for(int i = 0; i<size; i++) {
			outBuffer.put(inBuffer.get(i));
		}
		//关闭（关闭通道时会写入数据块）
		fcin.close();
		fcout.close();
		in.close();
		out.close();
		System.out.println("copy success!");
	}
	/**
	 * 通过文件通道实现文件复制
	 * @param srcFilePath
	 * @param destFilePath
	 * @throws IOException
	 */
	public static void copyFile(String srcFilePath, String destFilePath) throws IOException {
		@SuppressWarnings("resource")
		FileChannel fcin = new FileInputStream(srcFilePath).getChannel();
		@SuppressWarnings("resource")
		FileChannel fcout = new FileOutputStream(destFilePath).getChannel();
		
		ByteBuffer inBuffer = ByteBuffer.allocate(1024);
		
		while(fcin.read(inBuffer) != -1) {
			inBuffer.flip();
			fcout.write(inBuffer);
			inBuffer.clear();
		}
		fcin.close();
		fcout.close();
		System.out.println("copy success!");
	}
	
	public static void main(String[] args) {
		String srcFilePath = "/Users/moushuai/desktop/test.zip";
		String destFilePath = "/Users/moushuai/desktop/testio/test2.zip";
		try {
			//copyFile(srcFilePath, destFilePath);
			randomAccessFile(srcFilePath, destFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
