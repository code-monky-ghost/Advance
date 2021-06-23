/**배열로 데이터를 내보내는 Stream*/
package io.day1;

import java.io.IOException;

public class InputStreamTest3 {

	public static void main(String[] args) throws IOException {
		// 달걀판 만들기
		byte[] data = new byte[6];
		int input = 0, count = 0, total = 0;
		System.out.println("입력=>");
		while ((input = System.in.read(data)) != -1) {
			// 입력받은 데이터는 data배열에 담긴다.
//			System.out.write(input);[x] =>> data에 값이 배열로 저장되어있음.
			System.out.write(data, 0, input);// 배열의 범위를 지정해야한다. ==> 찌꺼기 값을 제거하기 위해서 배열의 범위 지정
			// 달걀이 담긴 달걀판을 write해야함
			// 여기서 input변수에는 달걀판에 담긴 달걀의 갯수를 갖고 있음.
			count++;// 반복문 횟수 
//			System.out.println("input =" + input);
			total += input;
		}
		System.out.println("*******************************");
		System.out.println(total + "byte 읽음");
		System.out.println("*******************************");

		System.in.close();// 노드연결했던 것을 닫아줘야 한다.
		System.out.close();
	}

}
