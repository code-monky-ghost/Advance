package net.day1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*������ (ServerSocket �� Socket�� �ʿ���)
 * - ��Ʈ��ȣ�� �����ؾ� �Ѵ�. ��Ʈ��ȣ�� 1~ 65535���� �����ϳ�, 1~1024������ ����� ��Ʈ�� �����Ƿ� ������
 * - Ŭ���̾�Ʈ�� ������ ���� Ŭ���̾�Ʈ�� ip�ּҸ� �ֿܼ� ����غ���.
 * - Ŭ���̾�Ʈ���� ������ ������ ������.== ��½�Ʈ��(������ ���� ��´�.)�� �̿��ؼ� 
 * */
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetSever {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(55555); 
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ�....");
		while(true) {
			Socket sock = server.accept();
			// accept() : Ŭ���̾�Ʈ�� ������ ��ٸ��� �ִٰ�, Ŭ���̾�Ʈ�� �����ؿ���
			// �ش� Ŭ���̾�Ʈ�� ����� ���ϰ�ü�� ��ȯ���ش�. Ŭ���̾�Ʈ�� ������ ������ block���¿� ����
			System.out.println("Ŭ���̾�Ʈ�� �����߾��");
			InetAddress inet = sock.getInetAddress();
			System.out.println("Ŭ���̾�Ʈ�� IP�ּ� : "+inet.getHostAddress());
			
			OutputStream os = sock.getOutputStream();
			//Ŭ���� ��� ������ ��Ʈ�� 
			DataOutputStream dos = new DataOutputStream(os);
			
			//1~100������ ������ ������ ���� dos���ؼ� ������.
			int num = (int)(Math.random()*100)+1;
			
			dos.writeInt(num);
			dos.flush();
			
			//Ŭ���̾�Ʈ�� ������ �亯 �޼����� ��� �ֿܼ� ����ϱ�.
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String msg = dis.readUTF();
			System.out.println("From Client["+inet.getHostAddress()+"]"+msg);
			
		}
		
	}//main

}//class
