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

		// 소켓생성
		Socket sock = new Socket(ip, port);
		System.out.println("##에코 서버와 연결됨##");

		// 1. 소켓을 통해 듣는 스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		// 2. 소켓을 통해 출력하는 스트림 생성
		PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
		// 3. 키보드와 연결된 입력스트림 생성
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		// 먼저 서버가 보내온 메세지를 듣고 콘솔에 출력하자
		String ServerMsg = in.readLine();
		System.out.println("From EchoServer>>"+ServerMsg);
		
		String myMsg="";
		
		// 키보드로 입력하여 서버에 메세지를 보내고
		while((myMsg=key.readLine())!=null) {
			//서버가 보내오는 메아리 메시지를 듣는다.
			out.println(myMsg);
			ServerMsg=in.readLine();
			System.out.println("from EchoSevver>>"+ServerMsg);;
			
		}
		
		
		
		// 서버가 보내오는 메아리 메세지를 듣는다.
			ServerMsg=in.readLine();
			System.out.println("From EchoServer>>"+ServerMsg);
			
			in.close();
			out.close();
			key.close();
			sock.close();
			
			
	}//

}//
