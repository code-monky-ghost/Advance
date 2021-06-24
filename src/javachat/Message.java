package javachat;
import java.io.Serializable;
/*프로토콜 정의
protocol: 통신 규약(통신할 때 정해놓은 약속)
http, ftp, smtp, pop .....

100 : 클라이언트 리스트 정보(100|아이디|대화명)

400 : 일반 대화 메시지(400|글꼴색|메시지)
500 : 귓속말(500|귓속말 보내는 사람의 대화명|귓속말 메시지)
600 : 대화명 변경(600|아이디|기존대화명|바뀐대화명)
800 : 동일한 아이디가 있을 시 접속을 종료시킨다(800|)
810 : 로그아웃-퇴장 처리(810|대화명)
900 : 채팅 종료 (900|대화명)
*/

public class Message implements Serializable{//오브젝트를 보내기 위함.

	private int code; //프로토콜에 정해놓은 코드값을 위한 변수
	private String msg;//대화메세지
	private String id; //보내는 사람 아이디
	private String nick;// 보내는 사람 닉네임
	private int fontRGB;//글자색
	
	
	public Message() {
		
	}
	//Overload 전부 받아들이는 생성자
	public Message(int code, String id, String nick, int fontRGB, String msg) {
		super();
		this.code = code;
		this.msg = msg;
		this.id = id;
		this.nick = nick;
		this.fontRGB = fontRGB;
	}//-----

		/**입장할때 필요한 생성자*/
	public Message(int code, String id, String nick) {
		super();
		this.code = code;
		this.id = id;
		this.nick = nick;
	}
	
	
		/***/
	public Message(int code, String msg, int fontRGB) {
			super();
			this.code = code;
			this.msg = msg;
			this.fontRGB = fontRGB;
		}
	//setter & getter
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getFontRGB() {
		return fontRGB;
	}
	public void setFontRGB(int fontRGB) {
		this.fontRGB = fontRGB;
	}
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", id=" + id + ", nick=" + nick + ", fontRGB=" + fontRGB
				+ "]";
	}
	
	//toString() 메소드 오버라이드 (Object가 갖고 있는 메소드)
	
	
	
	
}///////////////////class
