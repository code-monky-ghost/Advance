/**Ű����� �Է¹��� ������ ���Ͽ� �����ϴ� Stream*/
package io.day1;

import java.io.FileOutputStream;
import java.io.IOException;

/*[�ǽ�] Ű����� �Է¹��� ������ ����*(C:MyJava/Workspace/Advance/result/txt)�� �����ϴ� ���
 * ---------------------------------------------
 * ������ �ҽ� : Ű���� =====>> ��彺Ʈ��(System.in)
 * �����͸����� : ���� ======>> ��彺Ʈ��(FileOutputStream)
 * */
public class FOStreamTest {

	public static void main(String[] args) throws IOException {

		String file = "C:/MyJava/Advance/result.txt";
		FileOutputStream fos = new FileOutputStream(file,true);//true���� �ָ� append����� ���´�. ���� ���� ���뿡 ���ο� ������ �����̱� ��.
		

		System.out.println("���Ͽ� ������ ������ �Է��ϼ���=>");
		int n = 0, cnt = 0;
		//�迭�� ��Ƽ� �а� ���Ͽ� �Ẹ��
				
		byte[] data = new byte[1024];
		
		while((n=System.in.read(data))!=-1) {
			fos.write(data,0,n);
			fos.flush();//��Ʈ���� �����ִ� �����Ͱ� ������ �о�� ����
			cnt+=n;
			
			
		}//while
		System.out.println(cnt+"byte��");
		//��� �����ϸ� �ݵ�� close����� �Ѵ�.
		fos.close();
		System.in.close();
		
	}//main

}//class
