package io.day2;

import java.io.*;

/*BufferedInputStream/BufferedOutputStream
 * - 1byte ��� ��Ʈ��
 * - ���ͽ�Ʈ��
 * - ��� : �����͵��� ���ۿ� ���� ���� ��Ƶξ��ٰ�
 *         ���۰� ���� ���� �Ѳ����� �о����
 * [�ǽ�] Ű����� �Է¹޾� �ֿܼ� �������
 * ��彺Ʈ��: System.in/System.out
 * ���ͽ�Ʈ��: BufferedInputStream/BufferedOutputStream
 * */
public class BIStream {

	public static void main(String[] args) throws IOException {

		BufferedInputStream bis = new BufferedInputStream(System.in);

		BufferedOutputStream bos = new BufferedOutputStream(System.out);

		// �����ʹ� �޸� ���ۿ� �����ǰ� ���۰� �������� �Ѳ����� �о���̰ų�
		// ����Ѵ�.

		int n = 0, count = 0;
		bos.write("�Է��ϼ���=>".getBytes());//
		bos.flush();
		while ((n = bis.read()) != -1) {
			bos.write(n);
			bos.flush();
			count++;

		}
		bos.write((count + "bytes �а� ��").getBytes());
		
		bos.close();
		bis.close();

	}

}
