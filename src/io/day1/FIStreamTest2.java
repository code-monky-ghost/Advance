package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

/*[실습]파일을 읽어서 도스 콘솔에 출력해보자.
 * ------------------------------------------
 * 데이터 소스 : 파일 =====> 노드스트림 (FileInputStream)
 * 						  int read()
 * 						  int read(byte[] d)
 * 데이터 목적지 : 콘솔 ===> 노드스트림 (System.out)
 * 
 * */
public class FIStreamTest2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// String
		// fileName="C:/MyJava/Workspace/Advance/src/io/day1/InputStreamTest.java";
		// //데이터 소스
		String fileName = JOptionPane.showInputDialog("파일명을 입력하세요");
		// 파일과 노드 연결
		FileInputStream fis = new FileInputStream(fileName);
		PrintStream ps = System.out;
		byte[] data = new byte[1024];

		int input = 0, count = 0, total = 0;
		// 파일 데이터를 달걀판(배열)에 담아서 읽고 쓰세요
		while ((input = fis.read(data)) != -1) {

			ps.write(data, 0, input);
			count++;
			total += input;
		}
		
		System.out.println("***********************");
		System.out.println(total+"byte 읽음");
		System.out.println(count+"번 반복됨");
		
		System.out.println("***********************");
		
		
		fis.close();
		ps.close();

	}

}
