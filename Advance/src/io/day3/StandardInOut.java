package io.day3;

/*키보드 입력 ==> 콘솔에 출력
 * BufferedReader/BufferedWriter
 *  - 2byte기반
 *  - 필터스트림
 *  - 버퍼에 모아서 읽고/쓴다
 *  - int read()
 *  - String readLine()
 *  -----------------------------------------------------------
 *  데이터 소 스 : 키보드 ==> 노드스트림(System.in)
 *  데이터 목적지 : 콘솔 ==> 노드스트림(System.out)
 *  
 *  */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StandardInOut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader는 생성자에 Reader계열의 객체를 받아들인다.
		// 따라서 1바이트기반 스트림과 연결해야 할 때는 브릿지 스트림이 필요하다.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = "";
		//readLine()은 개행문자(\n)를 만나기 전까지는 문자열을 반환한다.
		bw.write("입력하세요=>");
		bw.flush();
		while((line =br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
		
		
	}//main

}//class
