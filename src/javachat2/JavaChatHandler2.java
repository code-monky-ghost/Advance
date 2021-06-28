package javachat2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

public class JavaChatHandler2 extends Thread {

	private Socket sock;
	private Vector<JavaChatHandler2> userV;
	private String userId; // 유저의 id [키값]
	private String nick; // 유저 닉네임
	private ObjectInputStream in; // 서버 스레드와 연결하기 위한 스트림
	private ObjectOutputStream out;// 서버 스레드와 연결하기 위한 스트림
	private boolean isStop; // run()에서 사용될 변수

	/** JavaChatServer2 구현을 위한 생성자 */
	public JavaChatHandler2(Socket sock, Vector<JavaChatHandler2> v) {
		this.sock = sock;
		this.userV = v;
		try {
			in = new ObjectInputStream(this.sock.getInputStream());
			out = new ObjectOutputStream(this.sock.getOutputStream());// 서버 스레드를 위한 보조스트림 생성
			// 주의 : 서버쪽에서 in,out순서로 생성하면 client쪽에서는 out,in 순서로 생성하자
			// 그래야 통신이 됨.
		} catch (IOException e) {
			System.out.println("JavaChatHandler()생성자 예외" + e);
		} // 서버 스레드를 위한 보조스트림 생성

	}// JavaChatServer2----------------------Constructor

	/** 스레드 구현을 위한 오버라이드 */
	public void run() {
		Object obj;
		try {
			obj = in.readObject();
			if (obj == null)
				return; // null값 체크

			Message2 data = null;
			System.out.println("obj==" + obj);

			if (obj instanceof Message2) { // 객체가 맞는지 확인하고
				data = (Message2) obj; // 강제 형 변환
			}

			if (data.getCode() == 100) {
				userId = data.getId();
				nick = data.getNick();
				checkNick();
				// 대화명(nick)의 중복여부 체크하기
				// 1.대화명이 중복된다면.....

				// 2.대화명이 중복되지 않는다면.....
				while(!isStop) {
					data=(Message2) in.readObject();
					process(data);
					
					
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("JavaChatHandler run()예외" + e);
		}

	}// run()--------------------------------------------------

	private void process(Message2 data) {
		// TODO Auto-generated method stub
		
	}

	private void checkNick() {
		// 대화명 중복 여부를 체크하는 메소드 호출
		boolean isExist = isDuplicateNick(nick);
		// 중복되는 닉네임이면 true를 반환
		if(isExist) {
			Message2 data = new Message2();
			data.setCode(700);//대화명 중복 프로토콜
			sendMessageTo(data);
		}else {
			//대화명이 중복되지 않는다면
			//1) 방금 접속한 클라이언트에게 기존에 이미 접속해 있는 클라이언트의 정보를 보내주자.
			for(JavaChatHandler2 userChat: userV) {
				//입장시 필요한 값들 오버로딩 한 값불러오기
				Message2 sendData = new Message2(userChat.userId, userChat.nick,100);// userV에 있는 id와 nick, 코드값
				sendMessageTo(sendData);
			}
			
			//2) 방금 접속한 클라이언트의 정보를 기존에 이미 접속해 있는 모든 클라이언트에게 보내준다.
			userV.add(this);// 기존의 접속자에게 보여주기 위해 배열에 저장
			Message2 data = new Message2(userId, nick, 100); //중복되지 않는 값을 배열에 저장
			sendMessageAll(data);
			
			
		}
		
	}

	/**방금 입장한 클라이언트를 기존 입장유저 모두에게 메세지를 보내주는 메소드*/
	private synchronized void sendMessageAll(Message2 msg) {// 동기화가 필요하다.
		for(JavaChatHandler2 userChat : userV) {
			try {
				userChat.out.writeObject(msg);
				userChat.out.flush();
			} catch (IOException e) {
				System.out.println("sendMessageAll()예외:"+e);
				userV.remove(userChat);// 배열에서 제거하는 경우 앞으로 한칸씩 땡겨짐.
				break;// 반복문 멈추기
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
