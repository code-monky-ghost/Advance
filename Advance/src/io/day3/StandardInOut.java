package io.day3;

/*Ű���� �Է� ==> �ֿܼ� ���
 * BufferedReader/BufferedWriter
 *  - 2byte���
 *  - ���ͽ�Ʈ��
 *  - ���ۿ� ��Ƽ� �а�/����
 *  - int read()
 *  - String readLine()
 *  -----------------------------------------------------------
 *  ������ �� �� : Ű���� ==> ��彺Ʈ��(System.in)
 *  ������ ������ : �ܼ� ==> ��彺Ʈ��(System.out)
 *  
 *  */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StandardInOut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader�� �����ڿ� Reader�迭�� ��ü�� �޾Ƶ��δ�.
		// ���� 1����Ʈ��� ��Ʈ���� �����ؾ� �� ���� �긴�� ��Ʈ���� �ʿ��ϴ�.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = "";
		//readLine()�� ���๮��(\n)�� ������ �������� ���ڿ��� ��ȯ�Ѵ�.
		bw.write("�Է��ϼ���=>");
		bw.flush();
		while((line =br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
		
		
	}//main

}//class
