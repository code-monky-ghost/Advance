package io.day3;

/*FileReader
 * - 2byte��� ��Ʈ��
 * - ��彺Ʈ��(���ϰ� ��� ����)
 * [�ǽ�] ������ �о �ֿܼ� ����ϱ�---------------------------------------------
 * - 2byte ��Ʈ�� ������ ��µ� 2����Ʈ ��� ��Ʈ���� ����ϴ� ���� ����.
 * ������ �ҽ� : ����	===> ��彺Ʈ��(FileReader)
 * ������ ������ : �ܼ� ===> ��彺Ʈ��(system.out) == �긴����Ʈ��(OutputStreamWriter)
 * */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		
		//src/io/day3/DirList.java
		String file = JOptionPane.showInputDialog("���� ���ϸ��� �Է��ϼ���");
		if (file == null)
			return;
		File f = new File(file);
		System.out.println("���� ���� ũ��" + f.length() + "bytes");

		FileReader fr = new FileReader(f);
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		int n = 0;
		//2byte�϶��� chartype �迭���
		char[] data = new char[1000];
		while ((n = fr.read(data)) != -1) {
			ow.write(data,0,n);
			ow.flush();
		}
		fr.close();
		ow.close();

	}

}
