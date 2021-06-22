/**���丮�� �ִ� ����&���丮, ũ��, ������¥ ���� �����ִ� Ŭ����*/
package io.day3;

import java.io.File;
//�������� ��¥ ����
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DirList {

	public static void main(String[] args) {
		String dirName = JOptionPane.showInputDialog("���丮���� �Է��ϼ���");
		if (dirName == null)
			return;

		File dir = new File(dirName);
		// boolean isDirectory() : ���丮�� true�� ��ȯ
		// boolean isFile() : �����̸� true��ȯ
		System.out.println(dir.isDirectory());

//		String[] list()  =>

//		[1]�ش� ���丮�� �ִ� �����̳� ���丮 �̸��� ������ ����ϱ�. //���� : �����̸��� �� ������ ��������(ũ��)�� ������ ����.
		String[] fList = dir.list();
		if (fList != null) {
			for (String fname : fList) {
				System.out.println(fname);
			}

		}
//		File[] listFiles() =>  
		
//		[2] �ش� ���丮�� ����/dir�� �̸��� ����ũ��, File/Dir�� ����ϱ�, ������ ������ ��¥ ��������ϱ�.

		File[] fList2 = dir.listFiles();
		if (fList2 != null) {
			String fsize = "";
			String time = "";
			Date d = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// ��¥ ���� �ٲ��ش� import java.text�ʿ�
			// �ڹ� : yy:�⵵ MM: �� dd:�� hh:�� mm:�� ss:��
			// ����Ŭ : mm: �� mi:��
			System.out.println("-----------------------------------------------------");
			System.out.println("������������\tFILE/DIR\t���ϸ�\t����ũ��");
			System.out.println("-----------------------------------------------------");
			for (File f : fList2) {
				String fname = f.getName();
				String str = (f.isFile()) ? "FILE" : "DIR"; // ���׿����ڷ� �Ҵ�
				if (!f.isDirectory()) {
					// ������ ���
					fsize = f.length() + "bytes";
					long time_long = f.lastModified(); // ��¥���� �ٲ���
					d = new Date(time_long); // longŸ�� => ��¥����
					time = sdf.format(d);
				} else {
					// ���丮�� ���
					fsize ="";
					time = "\t";
				}
				System.out.println(time + "\t" + str + "\t" + fname + "\t" + fsize);
			} // for--

		} // main

	}
}
