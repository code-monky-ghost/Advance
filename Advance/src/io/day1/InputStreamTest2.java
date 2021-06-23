/**1바이트 단위로 입력받는 Stream*/
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

public class InputStreamTest2 {

	public static void main(String[] args) throws IOException  {
		System.out.println("입력하세요 =>");		
		int input=0;
		int count=0;
		
		while((input=System.in.read())!=-1) {//Ctrl + C 누를때까지 반복한다.
			//Ctrl+C(윈도우즈 경우) or Ctrl+D(리눅스)를 누르면 -1을 반환한다.
//			System.out.print((char)input);
			System.out.write(input);
			count++;
		}
		
		System.out.println("***********************");
		System.out.println(count+" byte읽음");
		System.out.println("***********************");
		
		
		
	}
	
}
