package io.day2;
import java.io.*;
/* FileŬ������ �ֿ� �޼ҵ� ���캸��
 * 
 * 
 * 
 * */
public class FileTest {

	public static void main(String[] args) throws IOException{

		String fileName="src/io/day2/ReadEmployee.java";
		
		File file = new File(fileName);
		
		long fsize=file.length();//����ũ�� 
		
		System.out.println("����ũ�� :" +fsize);
		System.out.println("���ϸ� :"+file.getName());
		System.out.println("����� :"+file.getPath());
		System.out.println("������ :"+file.getAbsolutePath());
		
		File file2 = new File("sample"); //(�θ���丮 , ���ϸ�)
		System.out.println("����/DIR �� ���� ���� :" + file2.exists());

		//������ �������� �ʾ� ����� ����.
		if(!file2.exists()) {
			boolean b=file2.mkdir();//���丮 ����
			//���丮�� �����Ǹ�  true�� ��ȯ��.
			System.out.println("b="+b);
						
		}
		//���� ���丮������ mkdirs
		File file3 = new File("example","day01");
		if(!file3.exists()) {
			file3.mkdirs();
			
			
			
		}
		
		//sample���丮���� mydata��� �̸����� �����ϱ�
		//boolean renameto(file newF)
		
		file2.renameTo(new File("mydata"));
		
		//boolean delete() : ���� �Ǵ� dir����
		
		
		boolean b2=file3.delete();//�������丮 ���� (day01)
		System.out.println("���� ����:"+b2);
		//����ó���� �ش� ���丮 ���� �����̳� ���� ���丮�� ������ ����
	}

}
