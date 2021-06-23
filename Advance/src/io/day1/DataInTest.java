/**byte ���� ==> data�� ���� Stream*/
package io.day1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInTest {

	public static void main(String[] args) throws IOException {

		String readFile = "data.txt";
		// DataInputStream��ü �����ϼ���

		DataInputStream dis = new DataInputStream(new FileInputStream(readFile));

		// ����Ʈ�� ���ص� �����͸� �ڹ� �ڷ����� �°� ������Ų��.
		// ���� : DataOutputStream ���� �� ������ ���缭 �о�� �Ѵ�.
		System.out.println(dis.available() + "����Ʈ �б� ������");
		byte a = dis.readByte();
		System.out.println(a);
		byte[] buf = new byte[3];
		int n = dis.read(buf);

		for (byte b : buf) {

			System.out.println(b);
		}
		boolean b2= dis.readBoolean();
		System.out.println(b2);
		
		char c = dis.readChar();
		System.out.println(c);
		
		short s = dis.readShort();
		System.out.println(s);
		
		int i = dis.readInt();
		System.out.println(i);
		
		float f = dis.readFloat();
		System.out.println(f);
		
//		String str = dis.readLine(); �Ⱦ��� �޼ҵ�
		String str = dis.readUTF();
		System.out.println(str);
		
		
		dis.close();
	}// main

}// class
