/**data ==> byte 분해 Stream*/
package io.day1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* DataOutpuStream/DataInputStream
 * - 1byte기반 스트림
 * - 필터 스트림(데이터 소스나 데이터목적지에 직접 노드 연결 못함.)
 * - 기능 : 자바의 다양한 자료형(data type)들을 byte단위로 분해해서 쓰고,
 * 		  분해된 바이트를 다시 자바 자료형으로 복원시키는 기능을 수행함.
 * [실습] 자바의 자료형들의 값을 파일(Advance/data.txt)에 쓰고
 *       이것을 다시 읽어 콘솔에 출력해보자. 
 * */
public class DataOutTest {

	public static void main(String[] args) throws IOException {

		String file = "data.txt";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

		// 자바의 다양한 자료형의 데이터를 data.txt파일에 써보자.
		byte a = 48;
		byte arr[] = { 65, 66, 67 };
		boolean bool = true;
		char ch = '가';
		short sh = 5000;
		int n = 88;
		float ft = .456f;
		String str = "홍길동";

		dos.write(a);//1
		dos.write(arr, 0, arr.length);//4
		dos.writeBoolean(bool);//5
		dos.writeChar(ch);//7
		dos.writeShort(sh);//9
		dos.writeInt(n);//13
		dos.writeFloat(ft);//17
//		dos.writeChars(str);//23 읽을수 없는 데이터가 되버림
		dos.writeUTF(str);//
		/*writeUTF() : 유니코드의 utf-8 형식으로 문자열을 출력하는 메소드
	       *             utf형식은 각 문자의 표현을 위해 1바이트 사용하는지,
	       *             2바이트 사용하는지 또는 3바이트 사용하는지 알아내어
	       *          아스키 문자는 1바이트로, 그리스어,히브리어, 아랍어 등은 2바이트로
	       *          그 외 문자는 3바이트로 표현된다.
	       * */
		System.out.println(dos.size()+"byte를 data.txt에 씀");
		dos.flush();
		dos.close();
		
		
		
	}

}
