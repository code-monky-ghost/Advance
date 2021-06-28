package javachat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class JavaChatServer2 extends Thread{

	private ServerSocket server;//Ŭ���̾�Ʈ�� �����ϱ� ���� �غ�
	private int port = 9999;
	Vector<JavaChatHandler2> userV = new Vector<>(5,3);//�⺻ũ�� 5 ������ 3
	
	public JavaChatServer2() {
	try {
		server = new ServerSocket(port);//Ŭ���̾�Ʈ�� ����Ҷ� �ʿ��� ��Ʈ�� �Է�
		System.out.println("##ä�� ���� ���� �Ǿ����.##");// �������� ���
		System.out.println("##"+port+"��Ʈ���� �����....##"); //���� ��Ʈ�� ���
		
	} catch (IOException e) {
		System.out.println("###ä�� ���� ���� �� ����:##"+e+"##");//���ܰ� ���
	} //
		
	}//������ ------------
	
	
	/**Ŭ���̾�Ʈ ������ �۵�*/
	public void run() {
		while(true) {
			try {
				Socket sock = server.accept();//������ ������ ��û
				System.out.println("["+sock.getInetAddress()+"]���� �����߾��###");//Ŭ���̾�Ʈ ������ �ּҰ� Ȯ��
				JavaChatHandler2 chat = new JavaChatHandler2(sock,userV);//Ŭ���̾�Ʈ �����ϴ� �ּҰ��� �����ϴ� �迭�� 
				chat.start();
			} catch (IOException e) {
				System.out.println("JavaChatServer2()�� ����"+e);
			}
		}
	}

	public static void main(String[] args) {
		new JavaChatServer2().start();// ���������� ����
	}

}
