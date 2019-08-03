package cn.saul.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class url {
	public static void main(String[] args) {
		String urlString = "https://www.baidu.com";
		try {
			URL url = new URL(urlString);
			HttpsURLConnection openConnection = (HttpsURLConnection) url.openConnection();
			BufferedInputStream in = new BufferedInputStream(openConnection.getInputStream());
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/moushuai/Desktop/testio/url.html"));
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = in.read(bytes)) != -1){
				out.write(bytes, 0, len);
				out.flush();
			}
			in.close();
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
