package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/*[�ǽ�]������ �о ���� �ֿܼ� ����غ���.
 * ------------------------------------------
 * ������ �ҽ� : ���� =====> ��彺Ʈ�� (FileInputStream)
 * 						  int read()
 * 						  int read(byte[] d)
 * ������ ������ : �ܼ� ===> ��彺Ʈ�� (System.out)
 * 
 * */
public class FIStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java"; //������ �ҽ�
		
		//���ϰ� ��� ����
		FileInputStream fis = new FileInputStream(fileName);
		PrintStream ps = System.out;
		
		int input= 0, count=0;
		while((input=fis.read())!=-1) {
			//������ ���� �����ϸ� -1�� ��ȯ�Ѵ�.
			ps.write(input);
			count++;
		}
		
		ps.println(count+"byte �а� ��");
		
		fis.close();
		ps.close();
		
		
	}

}
