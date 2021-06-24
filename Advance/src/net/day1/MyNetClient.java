package net.day1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class MyNetClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//클라이언트 쪽에서는 Socket만 있으면 된다.
		//이 때 서버의 ip주소(호스트명), 포트번호가 필요하다.
		Socket sock = new Socket("192.168.0."+args[0],55555);
//		Socket sock = new Socket(InetAddress.getLocalHost()+args[0],55555);
		
		System.out.println("##서버와 연결됨######");
		//서버와 연결이 되면 Socket객체가 생성됨. 연결되지 않으면 IOExeption이 발생한다.
		
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		int num = dis.readInt();
		System.out.println("서버로부터 온 행운의 숫자 :"+num);
		
		//클라이언트가 숫자를 받으면 서버에게 "잘 받았어요~~ 숫자 55"이란 메세지를 전송하자.
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF("잘 받았어요~~ 숫자"+num);
		dos.flush();
		
		//소켓통해서 출력스트림 얻어오고 필터링 ==> 문자열을 보내는 메소드 호출 ==> flush
		
		
		
		dis.close();
		is.close();
		sock.close();
	}

}
