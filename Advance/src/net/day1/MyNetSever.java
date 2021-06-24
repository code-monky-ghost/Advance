package net.day1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*서버단 (ServerSocket 과 Socket이 필요함)
 * - 포트번호를 지정해야 한다. 포트번호는 1~ 65535까지 가능하나, 1~1024까지는 예약된 포트가 많으므로 피하자
 * - 클라이언트가 접속해 오면 클라이언트의 ip주소를 콘솔에 출력해보자.
 * - 클라이언트에게 랜덤한 정수를 보내자.== 출력스트림(소켓을 통해 얻는다.)을 이용해서 
 * */
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetSever {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(55555); 
		System.out.println("클라이언트 연결을 기다림....");
		while(true) {
			Socket sock = server.accept();
			// accept() : 클라이언트의 접속을 기다리고 있다가, 클라이언트가 접속해오면
			// 해당 클라이언트와 연결된 소켓객체를 반환해준다. 클라이언트가 접속할 때가지 block상태에 있음
			System.out.println("클라이언트가 접속했어요");
			InetAddress inet = sock.getInetAddress();
			System.out.println("클라이언트의 IP주소 : "+inet.getHostAddress());
			
			OutputStream os = sock.getOutputStream();
			//클에게 출력 가능한 스트림 
			DataOutputStream dos = new DataOutputStream(os);
			
			//1~100사이의 랜덤한 정수를 만들어서 dos통해서 보내자.
			int num = (int)(Math.random()*100)+1;
			
			dos.writeInt(num);
			dos.flush();
			
			//클라이언트가 보내온 답변 메세지를 듣고 콘솔에 출력하기.
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			String msg = dis.readUTF();
			System.out.println("From Client["+inet.getHostAddress()+"]"+msg);
			
		}
		
	}//main

}//class
