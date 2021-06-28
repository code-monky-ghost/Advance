package javachat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class JavaChatServer2 extends Thread{

	private ServerSocket server;//클라이언트가 접속하기 위한 준비
	private int port = 9999;
	Vector<JavaChatHandler2> userV = new Vector<>(5,3);//기본크기 5 증가값 3
	
	public JavaChatServer2() {
	try {
		server = new ServerSocket(port);//클라이언트와 통신할때 필요한 포트값 입력
		System.out.println("##채팅 서버 시작 되었어요.##");// 서버실행 출력
		System.out.println("##"+port+"포트에서 대기중....##"); //서버 포트값 출력
		
	} catch (IOException e) {
		System.out.println("###채팅 서버 시작 중 예외:##"+e+"##");//예외값 출력
	} //
		
	}//생성자 ------------
	
	
	/**클라이언트 서버의 작동*/
	public void run() {
		while(true) {
			try {
				Socket sock = server.accept();//서버에 접속을 요청
				System.out.println("["+sock.getInetAddress()+"]님이 접속했어요###");//클라이언트 접속자 주소값 확인
				JavaChatHandler2 chat = new JavaChatHandler2(sock,userV);//클라이언트 접속하는 주소값과 저장하는 배열값 
				chat.start();
			} catch (IOException e) {
				System.out.println("JavaChatServer2()의 예외"+e);
			}
		}
	}

	public static void main(String[] args) {
		new JavaChatServer2().start();// 서버스레드 실행
	}

}
