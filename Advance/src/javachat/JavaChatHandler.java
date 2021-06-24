package javachat;

import java.net.*;
import java.io.*;
import java.util.*;

public class JavaChatHandler extends Thread {

	private Socket sock;
	private Vector<JavaChatHandler> userV;
	private String userId;
	private String nick;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private boolean isStop;

	public JavaChatHandler(Socket sock, Vector<JavaChatHandler> v) {
		this.sock = sock;
		this.userV = v;
		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());
			//주의 : 서버쪽에서 in,out순서로 생성하면 client쪽에서는 out,in 순서로 생성하자
			//		그래야 통신이 됨.
			
		} catch (IOException e) {
			System.out.println("JavaChatHandler()생성자 예외"+e);
		}

	}

	public void run() {
		//클라이언트가 먼저 접속하면 
	}

	public void process() {

	}

	public void closeAll() {

	}

	public void sendMessageTo(String msg) {

	}

	public void sendMessageAll(String msg) {

	}

	public boolean isDuplicateNick(String nick) {
		return false;
	}

	public static void main(String[] args) {

	}

}