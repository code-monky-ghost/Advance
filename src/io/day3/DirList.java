/**디렉토리에 있는 파일&디렉토리, 크기, 생성날짜 등을 보여주는 클래스*/
package io.day3;

import java.io.File;
//숫자포멧 날짜 포멧
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DirList {

	public static void main(String[] args) {
		String dirName = JOptionPane.showInputDialog("디렉토리명을 입력하세요");
		if (dirName == null)
			return;

		File dir = new File(dirName);
		// boolean isDirectory() : 디렉토리명 true를 반환
		// boolean isFile() : 파일이면 true반환
		System.out.println(dir.isDirectory());

//		String[] list()  =>

//		[1]해당 디렉토리에 있는 파일이나 디렉토리 이름을 가져와 출력하기. //단점 : 파일이름은 잘 나오나 파일정보(크기)는 나오지 않음.
		String[] fList = dir.list();
		if (fList != null) {
			for (String fname : fList) {
				System.out.println(fname);
			}

		}
//		File[] listFiles() =>  
		
//		[2] 해당 디렉토리의 파일/dir의 이름과 파일크기, File/Dir로 출력하기, 마지막 수정한 날짜 정보출력하기.

		File[] fList2 = dir.listFiles();
		if (fList2 != null) {
			String fsize = "";
			String time = "";
			Date d = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 날짜 폼을 바꿔준다 import java.text필요
			// 자바 : yy:년도 MM: 월 dd:일 hh:시 mm:분 ss:초
			// 오라클 : mm: 월 mi:분
			System.out.println("-----------------------------------------------------");
			System.out.println("마지막수정일\tFILE/DIR\t파일명\t파일크기");
			System.out.println("-----------------------------------------------------");
			for (File f : fList2) {
				String fname = f.getName();
				String str = (f.isFile()) ? "FILE" : "DIR"; // 삼항연산자로 할당
				if (!f.isDirectory()) {
					// 파일일 경우
					fsize = f.length() + "bytes";
					long time_long = f.lastModified(); // 날짜유형 바꾸자
					d = new Date(time_long); // long타임 => 날짜형태
					time = sdf.format(d);
				} else {
					// 디렉토리일 경우
					fsize ="";
					time = "\t";
				}
				System.out.println(time + "\t" + str + "\t" + fname + "\t" + fsize);
			} // for--

		} // main

	}
}
