/**그림파일을 그림파일로 저장하는 Stream*/
package io.day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*[실습] C:\Myjava\Workspace\Advance\src\Images\CAR.png 파일을 읽어서 copy.png파일에
 * 내보내보자.
 * - 데이터 소스 : CAR.png(파일) ==> FileInputStream
 * - 데이터목적지 : copy.png(파일)==> FileOutputStream
 * 
 * */
public class ImageCopy {

	public static void main(String[] args) throws IOException {
//		String fileName = JOptionPane.showInputDialog("파일명을 입력하세요");

		FileInputStream fis = new FileInputStream("C:/Myjava/Workspace/Advance/src/Images/in.png");

		FileOutputStream fos = new FileOutputStream("C:/MyJava/Workspace/Advance/copy2.png");

		int n = 0, count = 0;

		byte[] image = new byte[1024];

		while ((n = fis.read(image)) != -1) {
			fos.write(image, 0, n);
			fos.flush();
			count += n;

		}
		System.out.println(count + "byte복사 완료!");
		fos.close();
		fis.close();

	}

}
