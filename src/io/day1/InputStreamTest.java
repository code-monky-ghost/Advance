package io.day1;
import java.io.IOException;
/*[�ǽ�] Ű����� �Է¹��� ������ ���� �ֿܼ� ����غ���
 * -----------------------------------------------
 * ������ �ҽ� : Ű����   ===================> ��� ��Ʈ��(System.in)
 * ������ ������ : ���� �ܼ� =================> ��� ��Ʈ��(System.out)
 * 
 * [1] System.in
 * - InputStream
 * - 1byte��� ��Ʈ��
 * - Ű����� ��� ����
 *  
 * [2] System.out
 * - PrintStrea
 * - 1byte��� ��Ʈ��
 * - �ְܼ� ��� ����
 * 
 * */

public class InputStreamTest {

	public static void main(String[] args) throws IOException  {
		System.out.println("�Է��ϼ��� =>");		
		int input=0;
		int count=0;
		
		while(true) {
			input=System.in.read();//Ű���� �Է��� �޴´�.
			//����ڰ� �Է��� ���� ���������� ��ȯ�Ѵ�.
			count++;
			if(input=='x'||input=='x')break;
			System.out.println("input="+input);// 13�� 10�� ���� \n, \r 
		}
		System.out.println("***********************");
		System.out.println(count+" byte����");
		System.out.println("***********************");
		
		
		
		
		
	}
	
}
