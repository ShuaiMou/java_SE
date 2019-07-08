package cn.saul.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class FIleDivisionMerge {
	/**
	 * 文件的分割
	 */
	public static void division(File srcFile, int cutSize) {
		if (srcFile == null) return;
		//计算分割的总文件数
		int num = (srcFile.length()%cutSize) == 0 ? 
				(int)(srcFile.length()/cutSize) : (int)(srcFile.length()/cutSize +1);
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));
			BufferedOutputStream out = null;
			byte[] bytes = null; //每次要读取的字节数
			int len = -1;
			int count = 0; // 每个文件要读取的次数
			for (int i = 0; i < num; i++) {
				out = new BufferedOutputStream(new FileOutputStream(
						new File("/Users/moushuai/desktop/testio/" + (i + 1) + "-temp-" + srcFile.getName())));
				if (cutSize < 1024) {
					bytes = new byte[cutSize];
					count = 1;
				}else {
					bytes = new byte[1024];
					count = cutSize%1024  == 0 ? cutSize/1024 : (cutSize/1024 + 1);
				}
				
				while(count > 0 && (len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
					out.flush();
					count --;
				}
				out.close();	
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * 文件的合并
	 * 
	 * SequenceInputStream 表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从第一个输入流开始读取，
		直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。
	 */
	public static void merge(Enumeration<InputStream> streams) {
		SequenceInputStream sis = new SequenceInputStream(streams);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
					new File("/Users/moushuai/desktop/testio/merge-test.avi")));
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = sis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
				bos.flush();
			}
			bos.close();
			sis.close();
			System.out.println("合并成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		File file = new File("/Users/moushuai/desktop/testio/test.avi");
//		division(file, 1024*1024*10);
		try {
			InputStream in1 = new FileInputStream(new File("/Users/moushuai/desktop/testio/1-temp-test.avi"));
			InputStream in2 = new FileInputStream(new File("/Users/moushuai/desktop/testio/2-temp-test.avi"));
			InputStream in3 = new FileInputStream(new File("/Users/moushuai/desktop/testio/3-temp-test.avi"));
			InputStream in4 = new FileInputStream(new File("/Users/moushuai/desktop/testio/4-temp-test.avi"));
			Vector<InputStream> vector = new Vector<InputStream>();
			vector.add(in1);
			vector.add(in2);
			vector.add(in3);
			vector.add(in4);
			Enumeration< InputStream> enumeration = vector.elements();
			merge(enumeration);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
