package javachat2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

public class JavaChatHandler2 extends Thread {

	private Socket sock;
	private Vector<JavaChatHandler2> userV;
	private String userId; // ������ id [Ű��]
	private String nick; // ���� �г���
	private ObjectInputStream in; // ���� ������� �����ϱ� ���� ��Ʈ��
	private ObjectOutputStream out;// ���� ������� �����ϱ� ���� ��Ʈ��
	private boolean isStop; // run()���� ���� ����

	/** JavaChatServer2 ������ ���� ������ */
	public JavaChatHandler2(Socket sock, Vector<JavaChatHandler2> v) {
		this.sock = sock;
		this.userV = v;
		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());// ���� �����带 ���� ������Ʈ�� ����
			// ���� : �����ʿ��� in,out������ �����ϸ� client�ʿ����� out,in ������ ��������
			// �׷��� ����� ��.
		} catch (IOException e) {
			System.out.println("JavaChatHandler()������ ����" + e);
		} // ���� �����带 ���� ������Ʈ�� ����

	}// JavaChatServer2----------------------Constructor

	/** ������ ������ ���� �������̵� */
	public void run() {
		Object obj;
		try {
			obj = in.readObject();
			if (obj == null)
				return; // null�� üũ

			Message2 data = null;
			System.out.println("obj==" + obj);

			if (obj instanceof Message2) { // ��ü�� �´��� Ȯ���ϰ�
				data = (Message2) obj; // ���� �� ��ȯ
			}

			if (data.getCode() == 100) {
				userId = data.getId();
				nick = data.getNick();
				checkNick();
				// ��ȭ��(nick)�� �ߺ����� üũ�ϱ�
				// 1.��ȭ���� �ߺ��ȴٸ�.....

				// 2.��ȭ���� �ߺ����� �ʴ´ٸ�.....
				while(!isStop) {
					data=(Message2) in.readObject();
					process(data);
					
					
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("JavaChatHandler run()����" + e);
		}

	}// run()--------------------------------------------------

	private void process(Message2 data) {
		// TODO Auto-generated method stub
		
	}

	private void checkNick() {
		// ��ȭ�� �ߺ� ���θ� üũ�ϴ� �޼ҵ� ȣ��
		boolean isExist = isDuplicateNick(nick);
		// �ߺ��Ǵ� �г����̸� true�� ��ȯ
		if(isExist) {
			Message2 data = new Message2();
			data.setCode(700);//��ȭ�� �ߺ� ��������
			sendMessageTo(data);
		}else {
			//��ȭ���� �ߺ����� �ʴ´ٸ�
			//1) ��� ������ Ŭ���̾�Ʈ���� ������ �̹� ������ �ִ� Ŭ���̾�Ʈ�� ������ ��������.
			for(JavaChatHandler2 userChat: userV) {
				//����� �ʿ��� ���� �����ε� �� ���ҷ�����
				Message2 sendData = new Message2(userChat.userId, userChat.nick,100);// userV�� �ִ� id�� nick, �ڵ尪
				sendMessageTo(sendData);
			}
			
			//2) ��� ������ Ŭ���̾�Ʈ�� ������ ������ �̹� ������ �ִ� ��� Ŭ���̾�Ʈ���� �����ش�.
			userV.add(this);// ������ �����ڿ��� �����ֱ� ���� �迭�� ����
			Message2 data = new Message2(userId, nick, 100); //�ߺ����� �ʴ� ���� �迭�� ����
			sendMessageAll(data);
			
			
		}
		
	}

	/**��� ������ Ŭ���̾�Ʈ�� ���� �������� ��ο��� �޼����� �����ִ� �޼ҵ�*/
	private synchronized void sendMessageAll(Message2 msg) {// ����ȭ�� �ʿ��ϴ�.
		for(JavaChatHandler2 userChat : userV) {
			try {
				userChat.out.writeObject(msg);
				userChat.out.flush();
			} catch (IOException e) {
				System.out.println("sendMessageAll()����:"+e);
				userV.remove(userChat);// �迭���� �����ϴ� ��� ������ ��ĭ�� ������.
				break;// �ݺ��� ���߱�
			}
		}
	}// sendMessageAll()----------------------

	private void sendMessageTo(Message2 data) {
		
	}

	private boolean isDuplicateNick(String nick2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {

	}

}
