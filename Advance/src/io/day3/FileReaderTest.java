package io.day3;

/*FileReader
 * - 2byte기반 스트림
 * - 노드스트림(파일과 노드 연결)
 * [실습] 파일을 읽어서 콘솔에 출력하기---------------------------------------------
 * - 2byte 스트림 읽으면 출력도 2바이트 기반 스트림을 사용하는 것이 좋다.
 * 데이터 소스 : 파일	===> 노드스트림(FileReader)
 * 데이터 목적지 : 콘솔 ===> 노드스트림(system.out) == 브릿지스트림(OutputStreamWriter)
 * */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		
		//src/io/day3/DirList.java
		String file = JOptionPane.showInputDialog("읽을 파일명을 입력하세요");
		if (file == null)
			return;
		File f = new File(file);
		System.out.println("읽을 파일 크기" + f.length() + "bytes");

		FileReader fr = new FileReader(f);
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		int n = 0;
		//2byte일때는 chartype 배열사용
		char[] data = new char[1000];
		while ((n = fr.read(data)) != -1) {
			ow.write(data,0,n);
			ow.flush();
		}
		fr.close();
		ow.close();

	}

}
