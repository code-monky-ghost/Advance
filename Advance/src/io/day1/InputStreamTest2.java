/**1����Ʈ ������ �Է¹޴� Stream*/
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

public class InputStreamTest2 {

	public static void main(String[] args) throws IOException  {
		System.out.println("�Է��ϼ��� =>");		
		int input=0;
		int count=0;
		
		while((input=System.in.read())!=-1) {//Ctrl + C ���������� �ݺ��Ѵ�.
			//Ctrl+C(�������� ���) or Ctrl+D(������)�� ������ -1�� ��ȯ�Ѵ�.
//			System.out.print((char)input);
			System.out.write(input);
			count++;
		}
		
		System.out.println("***********************");
		System.out.println(count+" byte����");
		System.out.println("***********************");
		
		
		
	}
	
}
