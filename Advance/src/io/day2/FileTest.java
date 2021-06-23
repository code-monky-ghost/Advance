package io.day2;
import java.io.*;
/* File클래스의 주요 메소드 살펴보기
 * 
 * 
 * 
 * */
public class FileTest {

	public static void main(String[] args) throws IOException{

		String fileName="src/io/day2/ReadEmployee.java";
		
		File file = new File(fileName);
		
		long fsize=file.length();//파일크기 
		
		System.out.println("파일크기 :" +fsize);
		System.out.println("파일명 :"+file.getName());
		System.out.println("상대경로 :"+file.getPath());
		System.out.println("절대경로 :"+file.getAbsolutePath());
		
		File file2 = new File("sample"); //(부모디렉토리 , 파일명)
		System.out.println("파일/DIR 의 존재 여부 :" + file2.exists());

		//파일이 존재하지 않아 만들어 보자.
		if(!file2.exists()) {
			boolean b=file2.mkdir();//디렉토리 생성
			//디렉토리가 생성되면  true를 반환함.
			System.out.println("b="+b);
						
		}
		//하위 디렉토리생성시 mkdirs
		File file3 = new File("example","day01");
		if(!file3.exists()) {
			file3.mkdirs();
			
			
			
		}
		
		//sample디렉토리명을 mydata라는 이름으로 변경하기
		//boolean renameto(file newF)
		
		file2.renameTo(new File("mydata"));
		
		//boolean delete() : 파일 또는 dir삭제
		
		
		boolean b2=file3.delete();//하위디렉토리 삭제 (day01)
		System.out.println("삭제 여부:"+b2);
		//삭제처리는 해당 디렉토리 내에 파일이나 서브 디렉토리가 없을때 가능
	}

}
