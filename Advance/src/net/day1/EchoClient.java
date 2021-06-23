package net.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws IOException {

		String ip = "192.168.0." + args[0];
		final int port = 7777;

		// ���ϻ���
		Socket sock = new Socket(ip, port);
		System.out.println("##���� ������ �����##");

		// 1. ������ ���� ��� ��Ʈ�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		// 2. ������ ���� ����ϴ� ��Ʈ�� ����
		PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
		// 3. Ű����� ����� �Է½�Ʈ�� ����
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		// ���� ������ ������ �޼����� ��� �ֿܼ� �������
		String ServerMsg = in.readLine();
		System.out.println("From EchoServer>>"+ServerMsg);
		
		String myMsg="";
		
		// Ű����� �Է��Ͽ� ������ �޼����� ������
		while((myMsg=key.readLine())!=null) {
			//������ �������� �޾Ƹ� �޽����� ��´�.
			out.println(myMsg);
			ServerMsg=in.readLine();
			System.out.println("from EchoSevver>>"+ServerMsg);;
			
		}
		
		
		
		// ������ �������� �޾Ƹ� �޼����� ��´�.
			ServerMsg=in.readLine();
			System.out.println("From EchoServer>>"+ServerMsg);
			
			in.close();
			out.close();
			key.close();
			sock.close();
			
			
	}//

}//
