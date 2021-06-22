package net.day1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest2 {

	public static void main(String[] agrs) throws MalformedURLException, IOException {
		String urlStr = "https://imgnews.pstatic.net/image/001/2021/06/17/AKR20210617127400017_01_i_P4_20210617153017434.jpg?type=w647";
		String urlStr2 = "https://news.v.daum.net/v/20210618073016741";
		URL url = new URL(urlStr);

		// URLConnection 객체로 해당 리소스 파일의 크기, 컨텐트 타입 등의 정보를 알아낼 수 있음.
		URLConnection urlCon = url.openConnection();
		String type = urlCon.getContentType();
		System.out.println("파일의 컨텐트 타입: " + type);
		System.out.println("파일의 크기: " + urlCon.getContentLengthLong());
//		InputStream is2 = urlCon.getInputStream();
		
		InputStream is = url.openStream();

		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] data = new byte[4000];

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("url2.jpg"));

		int n = 0;
		while ((n = bis.read(data)) != -1) {
			bos.write(data, 0, n);
			bos.flush();
		}

		System.out.println("카피완료!");
		bis.close();
		bos.close();

	}
}
