/**�迭�� �����͸� �������� Stream*/
package io.day1;

import java.io.IOException;

public class InputStreamTest3 {

	public static void main(String[] args) throws IOException {
		// �ް��� �����
		byte[] data = new byte[6];
		int input = 0, count = 0, total = 0;
		System.out.println("�Է�=>");
		while ((input = System.in.read(data)) != -1) {
			// �Է¹��� �����ʹ� data�迭�� ����.
//			System.out.write(input);[x] =>> data�� ���� �迭�� ����Ǿ�����.
			System.out.write(data, 0, input);// �迭�� ������ �����ؾ��Ѵ�. ==> ��� ���� �����ϱ� ���ؼ� �迭�� ���� ����
			// �ް��� ��� �ް����� write�ؾ���
			// ���⼭ input�������� �ް��ǿ� ��� �ް��� ������ ���� ����.
			count++;// �ݺ��� Ƚ�� 
//			System.out.println("input =" + input);
			total += input;
		}
		System.out.println("*******************************");
		System.out.println(total + "byte ����");
		System.out.println("*******************************");

		System.in.close();// ��忬���ߴ� ���� �ݾ���� �Ѵ�.
		System.out.close();
	}

}
