package net.day2;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
/*특정 포트로 클의 연결을 무한정 기다림
 * -클과 연결이 이루어지면 클과 통신을 담당하는 스레드(ChatHandler)를 생성한 후 스레드를 동작시킨다.
 * -여러명과 통신하기 위해 ChatHandler를 Vector에 저장하면 관리한다.
 * */

public class MyChatServer extends Thread{
	
	Vector<ChatHandler> v=new Vector<>(5, 3);
	final int port=33333;
	ServerSocket server;
	
	public MyChatServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("##채팅 서버 시작됨 ["+port+"]번 에서 대기중...##");
			this.start();
		} catch (IOException e) {
			System.out.println("##채팅 서버 시작 중 예외 발생: "+e.getMessage()+"##");
		}
	}

	public void run() {
		while(true) {
			try {
				Socket sock=server.accept();
				System.out.println("##["+sock.getInetAddress()+"]+님이 접속했어요##");
				//통신을 담당하는 스레드 동작
				//이때 소켓과 백터를 생성자에 전달한다.
				ChatHandler chatThread=new ChatHandler(sock,v);
				chatThread.start();
				
			} catch (IOException e) {
				System.out.println("#클과 연결 실패: "+e+"##");
			}
			
		}
	}
	
	public static void main(String[] args) {

		new MyChatServer();

	}

}
