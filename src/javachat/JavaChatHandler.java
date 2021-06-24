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
			// 주의 : 서버쪽에서 in,out순서로 생성하면 client쪽에서는 out,in 순서로 생성하자
			// 그래야 통신이 됨.

		} catch (IOException e) {
			System.out.println("JavaChatHandler()생성자 예외" + e);
		}

	}

	public void run() {
		// 클라이언트가 먼저 접속하면 "100|아이디|대화명"을 보낸다. ==> 이걸 먼저 듣자.
		try {
			Object obj = in.readObject();
			if (obj == null)// null check
				return;

			Message data = null;
			System.out.println("obj==" + obj);
			if (obj instanceof Message) { // 객체가 맞는지 확인하고
				data = (Message) obj; // 강제 형변환
			}

			if (data.getCode() == 100) {// 입장 메세지가 왔다면
				userId = data.getId();// 멤버변수에 할당
				nick = data.getNick();// 멤버변수에 할당
				checkNick();
				// 대화명(nick)의 중복여부 체크하기
				// 1.대화명이 중복된다면.....

				// 2.대화명이 중복되지 않는다면.....

			} // if------------

			while (!isStop) {
				// 클라이언트가 보내오는 메세지를 계속 듣고 그 내용을 분석해서 로직별로 처리하자.
				data = (Message) in.readObject();
				process(data);

			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("JavaChatHandler run() 예외" + e);
		}

	}

	/** 닉네임 중복확인 메소드 */
	private void checkNick() {
		// 대화명 중복 여부를 체크하는 메소드 호출
		boolean isExist = isDuplicateNick(nick);
		// 중복되는 닉네임이면 true를 반환
		if (isExist) {
			// 대화명이 중복된다면 ==> 700(닉네임 중복때의 protocol)
			Message data = new Message();
			data.setCode(700);
			sendMessageTo(data);

		} else {
			// 대화명이 중복되지 않는다면
			// 1) 방금 접속한 클라이언트에게 기존에 이미 접속해 있는 클라이언트의 정보를 보내주자.
			for (JavaChatHandler userChat : userV) {
				Message sendData = new Message(100, userChat.userId, userChat.nick);
				sendMessageTo(sendData);
			}

			// 2) 방금 접속한 클라이언트의 정보를 기존에 이미 접속해 있는 모든 클라이언트에게 보내준다.
			userV.add(this);// JavaChatHandler를 userV에 저장하자.
			Message data = new Message(100, userId, nick);
			sendMessageAll(data);

		}
	}

	/***/
	public void process(Message data) {
		int code = data.getCode();
		System.out.println("code:"+code);
		switch (code) {
		case 400: {// 클라이언트=> 서버에게 "400|메세지|글자색"
			//서버=> 클라이언트 "400|보내는 사람 대화명|메세지|글자색
			Message sendData =new Message(400,userId,nick,data.getFontRGB(),data.getMsg());//오버로드 한 것에서 잘 선택하자.
			sendMessageAll(sendData);//모두에게 글자를 출력
		}
			break;
			
		case 900: // 900인 경우에 break문이 없어서 800과 같은 값을 내보낸다.
					// 클라이언트 => 서버에게 "900|아이디|대화명"↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		case 800: {// 클라이언트 => 서버에게 "800|아이디|대화명"
			// 모든 클에게 누가 퇴장한다고 알려주고,
			this.sendMessageAll(data);
			// userV에서 JavaChathandler 제거
			userV.remove(this);
			// 자원 반납.
			closeAll();
		} // case 800------
			break;
			
		}// switch---------
	}// process------------------

	/** 스트림 닫아주는 메소드 */
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
			System.out.println("clossAll()예외" + e);
		}
	}

	/** 특정한 클라이언트한테만 메세지를 보내는 메소드 */
	public synchronized void sendMessageTo(Message msg) {
		try {
			out.writeObject(msg);
			out.flush();

		} catch (IOException e) {
			System.out.println("sendMessageTo()예외" + e);
		}
	}

	/** 방금 입장한 사람을 기존에 입장한 사람들에게 모두 쏴주는 메소드 */
	public synchronized void sendMessageAll(Message msg) {
		for (JavaChatHandler userChat : userV) {
			try {
				userChat.out.writeObject(msg);
				userChat.out.flush();
			} catch (IOException e) {
				System.out.println("sendMessageAll()예외:" + e);
				userV.remove(userChat);
				break;
			}

		}
	}

	/** 방금 들어온 사람들이 기존에 입장한 사람들과 같은지 체크하는 메소드 */
	public boolean isDuplicateNick(String nick) {
		// 기존에 입장해 있는 사람들의 대화명을 검사
		for (JavaChatHandler userChat : userV) {
			if (userChat.nick.equals(nick)) {// 매개변수로 들어온 nick(방금들어온사람)과 userChat의 nick(기존사람)
				return true;// 동일 대화명 있으면 true반환

			} // if----------------//찾으면 리턴되고
		} // for----------------//없으면 for루프 밑으로
		return false;// 동일한 대화명이 없으면 false반환

	}

	public static void main(String[] args) {

	}

}