package io.day2;

import java.io.*;

/*BufferedInputStream/BufferedOutputStream
 * - 1byte 기반 스트림
 * - 필터스트림
 * - 기능 : 데이터들을 버퍼에 차곡 차곡 모아두었다가
 *         버퍼가 가득 차면 한꺼번에 읽어들임
 * [실습] 키보드로 입력받아 콘솔에 출력하자
 * 노드스트림: System.in/System.out
 * 필터스트리: BufferedInputStream/BufferedOutputStream
 * */
public class BIStream {

	public static void main(String[] args) throws IOException {

		BufferedInputStream bis = new BufferedInputStream(System.in);

		BufferedOutputStream bos = new BufferedOutputStream(System.out);

		// 데이터는 메모리 버퍼에 누적되고 버퍼가 가득차면 한꺼번에 읽어들이거나
		// 출력한다.

		int n = 0, count = 0;
		bos.write("입력하세요=>".getBytes());//
		bos.flush();
		while ((n = bis.read()) != -1) {
			bos.write(n);
			bos.flush();
			count++;

		}
		bos.write((count + "bytes 읽고 씀").getBytes());
		
		bos.close();
		bis.close();

	}

}
