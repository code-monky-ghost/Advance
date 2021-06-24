package javachat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class JavaChatServer extends Thread {
   
   private ServerSocket server;
   private int port=9999;
   Vector<JavaChatHandler> userV = new Vector<>(5,3);// 기본크기 5, 증가치 3
   
   
   public JavaChatServer() {
      try {
		server = new ServerSocket(port);
		System.out.println("##채팅 서버 시작 되었어요##");
		System.out.println("##["+port+"]포트에서 대기중.....##");
	} catch (IOException e) {
		System.out.println("##채팅 서버 시작 중 예외: "+e+"##");
	}
   }
   /**클라이언트 서버의 작동*/
   public void run() {
      while (true) {
		try {
			Socket sock=server.accept();
			System.out.println("["+sock.getInetAddress()+"]님이 접속했어요###");
			JavaChatHandler chat = new JavaChatHandler(sock,userV);
			chat.start();
			
			
		} catch (IOException e) {
			System.out.println("JavaChatServer()예외"+e);
		}
		
	}
   }

   public static void main(String[] args) {
	   new JavaChatServer().start();
	   
	   
   }

}