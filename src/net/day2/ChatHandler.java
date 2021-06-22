package net.day2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

//Ŭ�� ����� ����ϴ� ������
public class ChatHandler extends Thread {
	Socket sock;
	Vector<ChatHandler> userV;

	DataInputStream in;
	DataOutputStream out;
	String nickName;

	public ChatHandler(Socket s, Vector<ChatHandler> v) {
		this.sock = s;
		this.userV = v;
		//////////////////
		userV.add(this);// ChatHandler�� Vector�� ����
		////////////////////////

		try {
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			System.out.println("ChatHandler()������ ����: " + e);

		}
	}

	boolean isStop = false;

	public void run() {
		// Ŭ�� �޽����� ��� �ش� �޽����� ������ ��� Ŭ���� �����ش�.
		// 1. ���� Ŭ�� �г����� �ޱ�.
		try {
			nickName = in.readUTF();// ���ڿ��� �������� readUTF
			System.out.println("##" + nickName + "���� ������##");
			broadcast("[" + nickName + "]���� �����߽��ϴ�.");
			while (!isStop) {
				// Ŭ�� �������� �޽��� ���
				String cMsg = in.readUTF();
				// cMsg�� parsing����.
				System.out.println(cMsg);
				if (cMsg.startsWith("Exit#")) {// Exit#nick
					// ����޼����� �Դٸ�
					String[] token = cMsg.split("#");// Exit, nick
					String exitNick = token[1];
					broadcast("[" + exitNick + "]���� �����Ͽ����ϴ�.");
					userV.remove(this);
					// userV���� ChatHandler�� ����
					close();
				

				} else {
					broadcast(nickName + ">>" + cMsg);

				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ChatHandler run() ����: " + e);
		}

	}

	private void close() throws IOException {
		isStop=true;
		if(in!=null) in.close();
		if(out!=null) out.close();
		if(sock!=null) sock.close();
	}

	/** ��� Ŭ���� �޼����� �����ϴ� ��� */
	private synchronized void broadcast(String msg) {// synchronized�� ����ȭ�� �ϸ� �����̶� ���� �ϸ� ���� ������
		// userV�� ���嵵�� ChatHandler�� �Ѳ����� ��������.
		Iterator<ChatHandler> it = userV.iterator();
		while (it.hasNext()) {
			ChatHandler chat = it.next();
			try {
				chat.out.writeUTF(msg);
				chat.out.flush();
			} catch (IOException e) {
				System.out.println("broadcast()����: " + e);
				userV.remove(this);
				// userV���� ChatHandler�� ����
				try {
					close();
				} catch (IOException e1) {
					break;
				}
			}

		}

	}
}
