package net.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������ ���� -Client�� Server�� �����ϸ�... 1) �����κ��� ���� "�ȳ��ϼ��� Ŭ���̾�Ʈ��?" �̶� �޽����� �޴´�.
 * 
 * 2) �׷��� Ŭ���̾�Ʈ�� ���� �ֿܼ��� Ű���� �Է��� ���� �޽����� ������[Ű���� �Է½�Ʈ���� ������ ���ϰ� �����Ͽ� �޽����� �ְ�޴�
 * ��ǲ/�ƿ�ǲ ��Ʈ���� �ʿ�]
 * 
 * ---------------------------Parsing-------------------------------
 * 
 * 3) �׷��� ������ Ŭ���̾�Ʈ�κ��� ���� �޽����� ���� ��) "�ȳ��ϼ���?" �� "����"�� �޽����� ���� --->"Ŭ�� �ݰ�����" ���
 * �޽����� ������ ��) "���� ��¥��" �̶� �޽����� ���� ----> ���� ��¥�� ������ ��) ��Ÿ �ٸ� �޽����� ���� "~~~�� �
 * ��~~"�� �޽����� ������.
 * 
 * 
 */
public class EchoServer {

	public static void main(String[] args) throws Exception {

		final int port = 7777;
		ServerSocket server = new ServerSocket(port);
		System.out.println("EchoServer Started");
		Socket sock = server.accept();
		InetAddress inet = sock.getInetAddress();
		String cip = inet.getHostAddress();// Ŭ���̾�Ʈ ip�ּ�
		System.out.println(cip + "���� �����߽��ϴ�.###");
		// 1. ������ Ŭ���̾�Ʈ���� "�ȳ��ϼ���~ ...��" �ϰ� �λ縦 �ǳ���.

		PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);// autoflush
		pout.println("�ȳ��ϼ���?" + cip + "��~~");

		// 2. Ŭ���̾�Ʈ�� �������� �޼����� ��� �Է� ��Ʈ�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		// 3. �ݺ��� ���鼭 Ŭ���̾�Ʈ�� �������� �޼����� ��� �̸� �м��Ͽ� ������ �亯�� ������.
		
		String cMsg="";//�޼����� ��� ���� ����
		while ((cMsg = in.readLine())!=null) {
			System.out.println("cMsg="+cMsg);
			//cMsg�� �м� => parsing �ؼ� ������ Ŭ���̾�Ʈ���� ������
			if(cMsg.contains("�ȳ�")||cMsg.contains("����")){
				pout.println(cip+"�ݰ�����");
			}else if (cMsg.contains("���� ��¥")||cMsg.contains("���ó�¥")) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");
				pout.println(date);
			}else if (cMsg.contains("����")) {
				pout.println("���� �ϼ���~~");
			}else {
				System.out.println("����...");
				pout.println(cip+"�� ���~");
				pout.flush();
			}
				
				
		}
		
		// 4. ����� �ڿ� close
		pout.close();
		in.close();
		sock.close();
		server.close();
		
		
	}
}
