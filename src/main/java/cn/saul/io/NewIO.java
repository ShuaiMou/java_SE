package cn.saul.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewIO {
	public static void main(String[] args) throws IOException {
		//File file = new File("/Users/moushuai/desktop/testio/test.avi");
		/*
		//path
		Path p1 = Paths.get("/Users/moushuai/desktop/testio", "test.avi");
		System.out.println("p1:" + p1);
		
		Path p2 = file.toPath();
		System.out.println("p2:" + p2);
		
		Path p3 = FileSystems.getDefault().getPath("/Users/moushuai/desktop/testio", "test.avi");
		System.out.println("p3:" + p3);
		
		//Files工具类
		//写文件
		Path p4 = Paths.get("/Users/moushuai/desktop/testio", "saul.txt");
		String info = "how are you!";
		Files.write(p4, info.getBytes("GB2312"), StandardOpenOption.APPEND);
		
		//读取文件
		byte[] bytes = Files.readAllBytes(p4);
		String string = new String(bytes);
		System.out.println(string);
		
		//复制文件
		Files.copy(p4, Paths.get("/Users/moushuai/desktop/saul.txt"),StandardCopyOption.REPLACE_EXISTING);
		
		//移动文件
		Files.move(p4, Paths.get("/Users/moushuai/desktop/saul.txt"), StandardCopyOption.REPLACE_EXISTING);
		
		//删除文件
		Files.delete(p1);
		*/
		//创建文件和目录
		/*
		Files.createDirectory(Paths.get("/Users/moushuai/desktop/testio/test"));
		Files.createDirectories(Paths.get("/Users/moushuai/desktop/testio/test1/test2"));
		*/
		
		Files.createFile(Paths.get("/Users/moushuai/desktop/testio/test", "BB.txt"));
	}
}
