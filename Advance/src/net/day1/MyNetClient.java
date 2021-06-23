package net.day1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class MyNetClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Ŭ���̾�Ʈ �ʿ����� Socket�� ������ �ȴ�.
		//�� �� ������ ip�ּ�(ȣ��Ʈ��), ��Ʈ��ȣ�� �ʿ��ϴ�.
		Socket sock = new Socket("192.168.0."+args[0],55555);
//		Socket sock = new Socket(InetAddress.getLocalHost()+args[0],55555);
		
		System.out.println("##������ �����######");
		//������ ������ �Ǹ� Socket��ü�� ������. ������� ������ IOExeption�� �߻��Ѵ�.
		
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		int num = dis.readInt();
		System.out.println("�����κ��� �� ����� ���� :"+num);
		
		//Ŭ���̾�Ʈ�� ���ڸ� ������ �������� "�� �޾Ҿ��~~ ���� 55"�̶� �޼����� ��������.
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF("�� �޾Ҿ��~~ ����"+num);
		dos.flush();
		
		//�������ؼ� ��½�Ʈ�� ������ ���͸� ==> ���ڿ��� ������ �޼ҵ� ȣ�� ==> flush
		
		
		
		dis.close();
		is.close();
		sock.close();
	}

}
