package javachat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

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
			// ���� : �����ʿ��� in,out������ �����ϸ� client�ʿ����� out,in ������ ��������
			// �׷��� ����� ��.

		} catch (IOException e) {
			System.out.println("JavaChatHandler()������ ����" + e);
		}

	}

	public void run() {
		// Ŭ���̾�Ʈ�� ���� �����ϸ� "100|���̵�|��ȭ��"�� ������. ==> �̰� ���� ����.
		try {
			Object obj = in.readObject();
			if (obj == null)// null check
				return;

			Message data = null;
			System.out.println("obj==" + obj);
			if (obj instanceof Message) { // ��ü�� �´��� Ȯ���ϰ�
				data = (Message) obj; // ���� ����ȯ
			}

			if (data.getCode() == 100) {// ���� �޼����� �Դٸ�
				userId = data.getId();// ��������� �Ҵ�
				nick = data.getNick();// ��������� �Ҵ�
				checkNick();
				// ��ȭ��(nick)�� �ߺ����� üũ�ϱ�
				// 1.��ȭ���� �ߺ��ȴٸ�.....

				// 2.��ȭ���� �ߺ����� �ʴ´ٸ�.....

			} // if------------

			while (!isStop) {
				// Ŭ���̾�Ʈ�� �������� �޼����� ��� ��� �� ������ �м��ؼ� �������� ó������.
				data = (Message) in.readObject();
				process(data);

			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("JavaChatHandler run() ����" + e);
		}

	}

	/** �г��� �ߺ�Ȯ�� �޼ҵ� */
	private void checkNick() {
		// ��ȭ�� �ߺ� ���θ� üũ�ϴ� �޼ҵ� ȣ��
		boolean isExist = isDuplicateNick(nick);
		// �ߺ��Ǵ� �г����̸� true�� ��ȯ
		if (isExist) {
			// ��ȭ���� �ߺ��ȴٸ� ==> 700(�г��� �ߺ����� protocol)
			Message data = new Message();
			data.setCode(700);
			sendMessageTo(data);

		} else {
			// ��ȭ���� �ߺ����� �ʴ´ٸ�
			// 1) ��� ������ Ŭ���̾�Ʈ���� ������ �̹� ������ �ִ� Ŭ���̾�Ʈ�� ������ ��������.
			for (JavaChatHandler userChat : userV) {
				Message sendData = new Message(100, userChat.userId, userChat.nick);
				sendMessageTo(sendData);
			}

			// 2) ��� ������ Ŭ���̾�Ʈ�� ������ ������ �̹� ������ �ִ� ��� Ŭ���̾�Ʈ���� �����ش�.
			userV.add(this);// JavaChatHandler�� userV�� ��������.
			Message data = new Message(100, userId, nick);
			sendMessageAll(data);

		}
	}

	/***/
	public void process(Message data) {
		int code = data.getCode();
		System.out.println("code:"+code);
		switch (code) {
		case 400: {// Ŭ���̾�Ʈ=> �������� "400|�޼���|���ڻ�"
			//����=> Ŭ���̾�Ʈ "400|������ ��� ��ȭ��|�޼���|���ڻ�
			Message sendData =new Message(400,userId,nick,data.getFontRGB(),data.getMsg());//�����ε� �� �Ϳ��� �� ��������.
			sendMessageAll(sendData);//��ο��� ���ڸ� ���
		}
			break;
			
		case 900: // 900�� ��쿡 break���� ��� 800�� ���� ���� ��������.
					// Ŭ���̾�Ʈ => �������� "900|���̵�|��ȭ��"����������������
		case 800: {// Ŭ���̾�Ʈ => �������� "800|���̵�|��ȭ��"
			// ��� Ŭ���� ���� �����Ѵٰ� �˷��ְ�,
			this.sendMessageAll(data);
			// userV���� JavaChathandler ����
			userV.remove(this);
			// �ڿ� �ݳ�.
			closeAll();
		} // case 800------
			break;
			
		}// switch---------
	}// process------------------

	/** ��Ʈ�� �ݾ��ִ� �޼ҵ� */
	public void closeAll() {
		isStop = true;
		try {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
			if (sock != null) {
				sock.close();
				sock = null;
			}
		} catch (Exception e) {
			System.out.println("clossAll()����" + e);
		}
	}

	/** Ư���� Ŭ���̾�Ʈ���׸� �޼����� ������ �޼ҵ� */
	public synchronized void sendMessageTo(Message msg) {
		try {
			out.writeObject(msg);
			out.flush();

		} catch (IOException e) {
			System.out.println("sendMessageTo()����" + e);
		}
	}

	/** ��� ������ ����� ������ ������ ����鿡�� ��� ���ִ� �޼ҵ� */
	public synchronized void sendMessageAll(Message msg) {
		for (JavaChatHandler userChat : userV) {
			try {
				userChat.out.writeObject(msg);
				userChat.out.flush();
			} catch (IOException e) {
				System.out.println("sendMessageAll()����:" + e);
				userV.remove(userChat);
				break;
			}

		}
	}

	/** ��� ���� ������� ������ ������ ������ ������ üũ�ϴ� �޼ҵ� */
	public boolean isDuplicateNick(String nick) {
		// ������ ������ �ִ� ������� ��ȭ���� �˻�
		for (JavaChatHandler userChat : userV) {
			if (userChat.nick.equals(nick)) {// �Ű������� ���� nick(��ݵ��»��)�� userChat�� nick(�������)
				return true;// ���� ��ȭ�� ������ true��ȯ

			} // if----------------//ã���� ���ϵǰ�
		} // for----------------//������ for���� ������
		return false;// ������ ��ȭ���� ������ false��ȯ

	}

	public static void main(String[] args) {

	}

}