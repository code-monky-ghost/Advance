package io.day3;

/*Ű���� �Է� ==> �ֿܼ� ���
 * BufferedReader/PrintWriter
 *  - 2byte���
 *  - ���ͽ�Ʈ��
 *  - ���ۿ� ��Ƽ� �д´�
 *  - int read()
 *  - String readLine()
 *  -----------------------------------------------------------
 *  ������ �� �� : Ű���� ==> ��彺Ʈ��(System.in)
 *  ������ ������ : �ܼ� ==> ��彺Ʈ��(System.out)
 *  
 *  */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StandardInOut2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader�� �����ڿ� Reader�迭�� ��ü�� �޾Ƶ��δ�.
		// ���� 1����Ʈ��� ��Ʈ���� �����ؾ� �� ���� �긴�� ��Ʈ���� �ʿ��ϴ�.
		
		PrintWriter pw = new PrintWriter(System.out,true);
		//true���� �ָ� auto flush�� ������.
		//��, �ٹٲ� ���� (\n)�� ������ �� �ڵ����� flush�Ѵ�.
		
		System.out.print("�Է��ϼ���~");
		String line="";
		while ((line=br.readLine())!=null) {
//			pw.write(line);
//			pw.flush();
			pw.println(line);// => �ڵ����� flush�ǰ� new line�ȴ�.
		}
		br.close();
		pw.close();
		
		
		
	}//main

}//class
