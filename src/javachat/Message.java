package javachat;
import java.io.Serializable;
/*�������� ����
protocol: ��� �Ծ�(����� �� ���س��� ���)
http, ftp, smtp, pop .....

100 : Ŭ���̾�Ʈ ����Ʈ ����(100|���̵�|��ȭ��)

400 : �Ϲ� ��ȭ �޽���(400|�۲û�|�޽���)
500 : �ӼӸ�(500|�ӼӸ� ������ ����� ��ȭ��|�ӼӸ� �޽���)
600 : ��ȭ�� ����(600|���̵�|������ȭ��|�ٲ��ȭ��)
800 : ������ ���̵� ���� �� ������ �����Ų��(800|)
810 : �α׾ƿ�-���� ó��(810|��ȭ��)
900 : ä�� ���� (900|��ȭ��)
*/

public class Message implements Serializable{//������Ʈ�� ������ ����.

	private int code; //�������ݿ� ���س��� �ڵ尪�� ���� ����
	private String msg;//��ȭ�޼���
	private String id; //������ ��� ���̵�
	private String nick;// ������ ��� �г���
	private int fontRGB;//���ڻ�
	
	
	public Message() {
		
	}
	//Overload ���� �޾Ƶ��̴� ������
	public Message(int code, String id, String nick, int fontRGB, String msg) {
		super();
		this.code = code;
		this.msg = msg;
		this.id = id;
		this.nick = nick;
		this.fontRGB = fontRGB;
	}//-----

		/**�����Ҷ� �ʿ��� ������*/
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
	
	//toString() �޼ҵ� �������̵� (Object�� ���� �ִ� �޼ҵ�)
	
	
	
	
}///////////////////class
