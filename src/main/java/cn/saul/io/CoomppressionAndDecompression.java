package cn.saul.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CoomppressionAndDecompression {
	/**
	 * 压缩
	 */
	public static void compression(String zipFileName, File targetFile) {
		System.out.println("is compressing....");
		try {
			ZipOutputStream zOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(zOutputStream);
			zip(zOutputStream, targetFile, targetFile.getName(),bos);
			bos.close();
			zOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("compression is finished");
	}
	
	private static void zip(ZipOutputStream zout, File targetFile, String name, BufferedOutputStream bos) throws IOException {
		if (targetFile.isDirectory()) {
			File[] files = targetFile.listFiles();
			if (files.length == 0) {
				zout.putNextEntry(new ZipEntry(name + "/"));
			}else {
				for(File f : files) {
					zip(zout, f, name + "/" + f.getName(), bos);
				}
			}
		}else {
			zout.putNextEntry(new ZipEntry(name));
			InputStream in  = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
				bos.flush();
			}
			bis.close();
		}
	}
	
	/**
	 * 解压
	 */
	public static void decompression(String targetFileName, String parent) {
		try {
			ZipInputStream zInputStream = new ZipInputStream(new FileInputStream(targetFileName));
			BufferedInputStream bis = new BufferedInputStream(zInputStream);
			ZipEntry entry = null;
			File file = null;
			while((entry = zInputStream.getNextEntry()) != null && !entry.isDirectory()) {
				file = new File(parent, entry.getName());
				if (!file.exists()) {
					new File(file.getParent()).mkdirs();//创建此文件的上级目录
					System.out.println("mkdirs:" + file.getCanonicalFile());
				}
			
				OutputStream outputStream = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(outputStream);
				byte[] bytes = new byte[1024];
				int len = -1;
				while((len = bis.read(bytes)) != -1) {
					bos.write(bytes,0,len);
				}
				bos.close();
				System.out.println(file.getAbsolutePath() + "decompression success!");
			}
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//compression("/Users/moushuai/desktop/test.zip", new File("/Users/moushuai/desktop/testio"));
		decompression("/Users/moushuai/desktop/test.zip", "/Users/moushuai/desktop/testio/decompress");
	}

}
