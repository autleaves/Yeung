package mil.yaye.yours.engine.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public class HttpChannel {
	
	private URL url;
	
	public HttpChannel(String url) throws MalformedURLException{
		this.url = new URL(url);
	}
	
	public String sendPostRequest(String content){
		String value = null;
		try {
			HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
			connect.setReadTimeout(60000);
			connect.setDoOutput(true);
			connect.setRequestMethod("POST");
			
			OutputStream out = connect.getOutputStream();
			out.write(content.getBytes());
			out.flush();
			out.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
	            buffer.append(line);
	        }
			value = buffer.toString();
			value = URLDecoder.decode(value,"某一编码机制");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public void sendPostRequest(){
		String new_html_file_name = null;
		try {
			HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
			connect.setReadTimeout(60000);
			connect.setDoOutput(true);
			connect.setRequestMethod("GET");
			
			InputStream reader = connect.getInputStream();
			FileOutputStream writer = new FileOutputStream(new File("xxx"));
			byte[] temp = new byte[1024];
			while((reader.read(temp, 0, 1024) != -1)){
				writer.write(temp);
			}
//			value = URLDecoder.decode(value,"某一编码机制");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
