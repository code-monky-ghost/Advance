//[1]6/21
package net.day2;
import java.net.*;
import java.io.*;

/*구현할 내용
*  - 채팅 서버와 클라이언트가 1대1로 채팅하는 프로그램
*  1)  키보드로 메시지를 입력해서 클쪽에 보냄
*  2) 클라이언트가 메시지를 보내오면 이를 듣고 콘솔에 출력
* */

public class ConsoleChatServer implements Runnable {
	
	ServerSocket server;
	Socket sock;
	final int port=7269;
	//입력스트림
	BufferedReader key, in;
	//출력스트림
	PrintWriter out;
	
	public ConsoleChatServer() {
		System.out.println("##ConsoleChatServer Started...##"+port+"번 포트에서 대기중...##");
		try {//익셉션 처리
			server=new ServerSocket(port);
			sock=server.accept();
			System.out.println("##클라이언트와 연결됨##");
			//1. 키보드 입력 스트림 생성
			key=new BufferedReader(new InputStreamReader(System.in));
			//2. 클라이언트에게 보낼 출력스트림 생성
			out=new PrintWriter(sock.getOutputStream(), true);
			//3. 클이 보내오는 메시지를 듣는 스레드를 생성해서 동작
			Thread listener=new Thread(this);
			listener.start();
			
			//4. 키보드 입력하면서 클에게 메시지 전송
			sendMessage();
			
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}//생성자--------------------------
	
	private void sendMessage() throws IOException {
		String myMsg="";
		while((myMsg=key.readLine())!=null) {
			out.println(myMsg);
		}
		key.close();
		out.close();
	}//----------------------------------------------

	@Override
	public void run() {
		try {
				//클이 보내오는 메시지를 듣고 콘솔에 출력함
				in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String cMsg="";
				while((cMsg=in.readLine())!=null) {
					System.out.println("From Client>>"+cMsg);
			}
		} catch (IOException e) {
				System.out.println("run()에서 예외: "+e.getMessage());
				System.out.println("##클라이언트가 접속을 끊었습니다.###");
				try {
				if(in!=null) in.close();
				if(sock!=null && !sock.isClosed()) {
					sock.close();
				}
		}catch(IOException ex) {}
	}
}//--------------------------------------

	public static void main(String[] args) {
		new ConsoleChatServer();//자기 객체 생성
	}

}
