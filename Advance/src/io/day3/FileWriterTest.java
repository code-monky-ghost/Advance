package io.day3;

import java.io.FileWriter;
/*Ű���� �Է¹޾Ƽ� ���Ͽ� �������.
 * �����ͼҽ�: Ű���� (System.in)==>InputStreamReader    
 * �����͸�����: ���� (FileWriter)						 
 * 
 * */
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		System.out.println("�Է��ϼ���. �Է��� ������ result.txt�� ����˴ϴ�.");
		String file = "C:\\Myjava\\Workspace\\Advance\\result.txt";

		// Ű����� ���� ��Ʈ�� ����
		InputStreamReader ir = new InputStreamReader(System.in);
		// file�� ���� ��Ʈ�� ����
		FileWriter fw = new FileWriter(file,true);// ���Ͽ� �Է°��� �����ǰ� true�� �༭ ��ȯ

		// �ݺ��� ���鼭 Ű���� �Է¹ް� ���Ͽ� ����ϱ�
		System.out.println("�Է��ϼ��� =>");
		int n = 0;
		//2����Ʈ �̹Ƿ� charŸ���� �迭�� ����.
		char [] data= new char[300];
		//�迭�� ��Ƽ� �а� ���� �ڵ�� �ٲ㼭����
		
		while ((n=ir.read(data))!=-1) {
			fw.write(data,0,n);
			fw.flush();
		}
		// close
		ir.close();
		fw.close();
		System.in.close();
		System.out.close();
		
	}

}
