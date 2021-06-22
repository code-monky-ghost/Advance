package io.day1;
import java.io.IOException;
/*[실습] 키보드로 입력받은 내용을 도스 콘솔에 출력해보자
 * -----------------------------------------------
 * 데이터 소스 : 키보드   ===================> 노드 스트림(System.in)
 * 데이터 목적지 : 도스 콘솔 =================> 노드 스트림(System.out)
 * 
 * [1] System.in
 * - InputStream
 * - 1byte기반 스트림
 * - 키보드와 노드 연결
 *  
 * [2] System.out
 * - PrintStrea
 * - 1byte기반 스트림
 * - 콘솔과 노드 연결
 * 
 * */

public class InputStreamTest {

	public static void main(String[] args) throws IOException  {
		System.out.println("입력하세요 =>");		
		int input=0;
		int count=0;
		
		while(true) {
			input=System.in.read();//키보드 입력을 받는다.
			//사용자가 입력한 값을 정수형으로 반환한다.
			count++;
			if(input=='x'||input=='x')break;
			System.out.println("input="+input);// 13과 10은 각각 \n, \r 
		}
		System.out.println("***********************");
		System.out.println(count+" byte읽음");
		System.out.println("***********************");
		
		
		
		
		
	}
	
}
