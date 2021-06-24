package io.day3;

import java.io.FileWriter;
/*키보드 입력받아서 파일에 출력하자.
 * 데이터소스: 키보드 (System.in)==>InputStreamReader    
 * 데이터목적지: 파일 (FileWriter)						 
 * 
 * */
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		System.out.println("입력하세요. 입력한 내용은 result.txt에 저장됩니다.");
		String file = "C:\\Myjava\\Workspace\\Advance\\result.txt";

		// 키보드와 연결 스트림 생성
		InputStreamReader ir = new InputStreamReader(System.in);
		// file과 연결 스트림 생성
		FileWriter fw = new FileWriter(file,true);// 파일에 입력값이 누적되게 true를 줘서 반환

		// 반복문 돌면서 키보드 입력받고 파일에 출력하기
		System.out.println("입력하세요 =>");
		int n = 0;
		//2바이트 이므로 char타입의 배열로 쓴다.
		char [] data= new char[300];
		//배열에 담아서 읽고 쓰는 코드로 바꿔서보기
		
		while ((n=ir.read(data))!=-1) {
			fw.write(data,0,n);
			fw.flush();
		}
		// close
		ir.close();
		fw.close();
		System.in.close();
		System.out.close();
		
	}

}
