/**�׸������� �׸����Ϸ� �����ϴ� Stream*/
package io.day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*[�ǽ�] C:\Myjava\Workspace\Advance\src\Images\CAR.png ������ �о copy.png���Ͽ�
 * ����������.
 * - ������ �ҽ� : CAR.png(����) ==> FileInputStream
 * - �����͸����� : copy.png(����)==> FileOutputStream
 * 
 * */
public class ImageCopy {

	public static void main(String[] args) throws IOException {
//		String fileName = JOptionPane.showInputDialog("���ϸ��� �Է��ϼ���");

		FileInputStream fis = new FileInputStream("C:/Myjava/Workspace/Advance/src/Images/in.png");

		FileOutputStream fos = new FileOutputStream("C:/MyJava/Workspace/Advance/copy2.png");

		int n = 0, count = 0;

		byte[] image = new byte[1024];

		while ((n = fis.read(image)) != -1) {
			fos.write(image, 0, n);
			fos.flush();
			count += n;

		}
		System.out.println(count + "byte���� �Ϸ�!");
		fos.close();
		fis.close();

	}

}
