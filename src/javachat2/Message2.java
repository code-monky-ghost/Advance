package javachat2;
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
import java.io.Serializable;

public class Message2 implements Serializable{

	private String msg;//��ȭ�޼���
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	private String id;//������ ��� ���̵�
	private String nick;// ������ ��� �г���
	private int fontRGB;//���ڻ�
	private int code;// �������ݿ� ���س��� �ڵ尪�� ���� ����.
	
	
	
	//getter & setter
	

	
	
	
	public Message2() {

	}
	
	/**������ ��ü �޾Ƶ��̴� ������.*/
	public Message2(String msg, String id, String nick, int fontRGB, int code) {
		super();
		this.msg = msg;
		this.id = id;
		this.nick = nick;
		this.fontRGB = fontRGB;
		this.code = code;
	}

	/**����� �ʿ��� �����ε� ������*/
	public Message2(String id, String nick, int code) {
		super();
		this.id = id;
		this.nick = nick;
		this.code = code;
	}
	/**���� ���� ���� �� ä��â�� ǥ���ϱ� ���� �ʿ��� ������*/
	public Message2(String msg, int fontRGB, int code) {
		super();
		this.msg = msg;
		this.fontRGB = fontRGB;
		this.code = code;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
