/**byte 분해 ==> data로 복원 Stream*/
package io.day1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInTest {

	public static void main(String[] args) throws IOException {

		String readFile = "data.txt";
		// DataInputStream객체 생성하세요

		DataInputStream dis = new DataInputStream(new FileInputStream(readFile));

		// 바이트로 분해된 데이터를 자바 자료형에 맞게 복원시킨다.
		// 주의 : DataOutputStream 으로 쓴 순서에 맞춰서 읽어야 한다.
		System.out.println(dis.available() + "바이트 읽기 가능함");
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
		
//		String str = dis.readLine(); 안쓰는 메소드
		String str = dis.readUTF();
		System.out.println(str);
		
		
		dis.close();
	}// main

}// class
