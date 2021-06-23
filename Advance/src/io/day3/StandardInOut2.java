package io.day3;

/*키보드 입력 ==> 콘솔에 출력
 * BufferedReader/PrintWriter
 *  - 2byte기반
 *  - 필터스트림
 *  - 버퍼에 모아서 읽는다
 *  - int read()
 *  - String readLine()
 *  -----------------------------------------------------------
 *  데이터 소 스 : 키보드 ==> 노드스트림(System.in)
 *  데이터 목적지 : 콘솔 ==> 노드스트림(System.out)
 *  
 *  */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StandardInOut2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader는 생성자에 Reader계열의 객체를 받아들인다.
		// 따라서 1바이트기반 스트림과 연결해야 할 때는 브릿지 스트림이 필요하다.
		
		PrintWriter pw = new PrintWriter(System.out,true);
		//true값을 주면 auto flush를 지원함.
		//단, 줄바꿈 문자 (\n)를 만날을 때 자동으로 flush한다.
		
		System.out.print("입력하세용~");
		String line="";
		while ((line=br.readLine())!=null) {
//			pw.write(line);
//			pw.flush();
			pw.println(line);// => 자동으로 flush되고 new line된다.
		}
		br.close();
		pw.close();
		
		
		
	}//main

}//class
