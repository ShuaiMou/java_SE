package cn.saul.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FileDemo {
	/**
	 * 测试文件路径的创建和文件的查找
	 * 
	 * @throws IOException
	 */
	public static void createFile() throws IOException{
		File file1 = new File("/Users/moushuai/desktop/"+"file.java");
		if (!file1.exists()) {
			file1.createNewFile();
			System.out.println("create success!");
		}
		File[] files = new File("/Users/moushuai/desktop").listFiles();
		for(File file : files){
			System.out.println(file.getName());
		}
		System.out.println("-----------------------");
		String[] filesName = new File("/Users/moushuai/desktop").list();
		for (String string : filesName) {
			System.out.println(string);
		}
		System.out.println("-----------------------");
		/*File[] files2 = new File("/Users/moushuai/desktop").listFiles
				(pathname -> pathname.getName().endsWith(".png"));
		*/
		File[] files2 = new File("/Users/moushuai/desktop").listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".png");
			}
		});
		for (File file : files2) {
			System.out.println(file.getName());
		}
		
		File file2 = new File("/users/moushuai/desktop/files2");
		if (!file2.exists()) {
			file2.mkdir();
			System.out.println("create dir success!");
		}
	}
	
	/**
	 * 查找文件目录下所有文件后缀名为suffix的文件
	 * 
	 * @param file 文件目录
	 * @param suffix 文件名后缀
	 */
	public static void FindfFile(File file, String suffix){
		if (!file.exists()) {
			return;
		}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				//递归查找
				FindfFile(file2, suffix);
			}
		}else {
			String name = file.getName().toLowerCase();
			if (name.endsWith(suffix)) {
				System.out.println(file.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) throws IOException {
		File file = new File("/users/moushuai/desktop");
		FindfFile(file, ".png");
	}
}
