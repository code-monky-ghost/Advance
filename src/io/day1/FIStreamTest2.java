package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

/*[�ǽ�]������ �о ���� �ֿܼ� ����غ���.
 * ------------------------------------------
 * ������ �ҽ� : ���� =====> ��彺Ʈ�� (FileInputStream)
 * 						  int read()
 * 						  int read(byte[] d)
 * ������ ������ : �ܼ� ===> ��彺Ʈ�� (System.out)
 * 
 * */
public class FIStreamTest2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// String
		// fileName="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java";
		// //������ �ҽ�
		String fileName = JOptionPane.showInputDialog("���ϸ��� �Է��ϼ���");
		// ���ϰ� ��� ����
		FileInputStream fis = new FileInputStream(fileName);
		PrintStream ps = System.out;
		byte[] data = new byte[1024];

		int input = 0, count = 0, total = 0;
		// ���� �����͸� �ް���(�迭)�� ��Ƽ� �а� ������
		while ((input = fis.read(data)) != -1) {

			ps.write(data, 0, input);
			count++;
			total += input;
		}
		
		System.out.println("***********************");
		System.out.println(total+"byte ����");
		System.out.println(count+"�� �ݺ���");
		
		System.out.println("***********************");
		
		
		fis.close();
		ps.close();

	}

}
