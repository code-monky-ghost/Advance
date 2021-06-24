package io.day2;

import java.io.*;

/*BIStream.java ������ �о �ֿܼ��� ����(copy.txt) ����ϴ� ���α׷��� �ۼ��ϼ���.
 * �� BufferedInputStream�� BufferedOutputStream�� ����ϼ���.
 * - �����ͼҽ�:   ����    =>��彺Ʈ��(FileInputStream) => ���ͽ�Ʈ��(BufferedInputStream)
 * - �����͸�����: �ܼ�     =>��彺Ʈ��(System.out) => ���ͽ�Ʈ��(BufferedOutputStream)
 *				   ����    => ��彺Ʈ��(FileOutputStream) => ���ͽ�Ʈ��(BufferedOutputStream)
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
		bos.write((count + "bytes �а� ��").getBytes());
		bos2.write(n);
		
		bis.close();
		bos.close();
		bos2.close();
		fis.close();

	}//// main

}// class
