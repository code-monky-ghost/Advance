/**키보드로 입력받은 내용을 파일에 저장하는 Stream*/
package io.day1;

import java.io.FileOutputStream;
import java.io.IOException;

/*[실습] 키보드로 입력받은 내용을 파일*(C:MyJava/Workspace/Advance/result/txt)에 저장하는 기능
 * ---------------------------------------------
 * 데이터 소스 : 키보드 =====>> 노드스트림(System.in)
 * 데이터목적지 : 파일 ======>> 노드스트림(FileOutputStream)
 * */
public class FOStreamTest {

	public static void main(String[] args) throws IOException {

		String file = "C:/MyJava/Advance/result.txt";
		FileOutputStream fos = new FileOutputStream(file,true);//true값을 주면 append기능을 갖는다. 기존 파일 내용에 새로운 내용을 덧붙이기 함.
		

		System.out.println("파일에 저장할 내용을 입력하세요=>");
		int n = 0, cnt = 0;
		//배열에 담아서 읽고 파일에 써보자
				
		byte[] data = new byte[1024];
		
		while((n=System.in.read(data))!=-1) {
			fos.write(data,0,n);
			fos.flush();//스트림에 남아있는 데이터가 있으면 밀어내기 해줌
			cnt+=n;
			
			
		}//while
		System.out.println(cnt+"byte씀");
		//노드 연결하면 반드시 close해줘야 한다.
		fos.close();
		System.in.close();
		
	}//main

}//class
