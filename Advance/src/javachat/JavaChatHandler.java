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
			//���� : �����ʿ��� in,out������ �����ϸ� client�ʿ����� out,in ������ ��������
			//		�׷��� ����� ��.
			
		} catch (IOException e) {
			System.out.println("JavaChatHandler()������ ����"+e);
		}

	}

	public void run() {
		//Ŭ���̾�Ʈ�� ���� �����ϸ� 
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