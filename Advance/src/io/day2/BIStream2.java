package io.day2;

import java.io.*;

/*BIStream.java 파일을 읽어서 콘솔에도 파일(copy.txt) 출력하는 프로그램을 작성하세요.
 * 단 BufferedInputStream과 BufferedOutputStream을 사용하세요.
 * - 데이터소스:   파일    =>노드스트림(FileInputStream) => 필터스트림(BufferedInputStream)
 * - 데이터목적지: 콘솔     =>노드스트림(System.out) => 필터스트림(BufferedOutputStream)
 *				   파일    => 노드스트림(FileOutputStream) => 필터스트림(BufferedOutputStream)
 * */
public class BIStream2 {

	public static void main(String[] args) throws IOException {

		String fileName = "C:\\MyJAVA\\Advance\\src\\io\\day2\\BIStream.java";
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream("copy.txt"));
		int n = 0, count = 0;

		while ((n = bis.read()) != -1) {
			bos.write(n);
			bos.flush();
			count++;

		}
		bos.write((count + "bytes 읽고 씀").getBytes());
		bos2.write(n);
		
		bis.close();
		bos.close();
		bos2.close();
		fis.close();

	}//// main

}// class
