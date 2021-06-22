package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/*[실습]파일을 읽어서 도스 콘솔에 출력해보자.
 * ------------------------------------------
 * 데이터 소스 : 파일 =====> 노드스트림 (FileInputStream)
 * 						  int read()
 * 						  int read(byte[] d)
 * 데이터 목적지 : 콘솔 ===> 노드스트림 (System.out)
 * 
 * */
public class FIStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java"; //데이터 소스
		
		//파일과 노드 연결
		FileInputStream fis = new FileInputStream(fileName);
		PrintStream ps = System.out;
		
		int input= 0, count=0;
		while((input=fis.read())!=-1) {
			//파일의 끝네 도달하면 -1을 반환한다.
			ps.write(input);
			count++;
		}
		
		ps.println(count+"byte 읽고 씀");
		
		fis.close();
		ps.close();
		
		
	}

}
