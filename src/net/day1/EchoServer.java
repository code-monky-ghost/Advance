package net.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 구현할 내용 -Client가 Server와 접속하면... 1) 서버로부터 먼저 "안녕하세요 클라이언트님?" 이란 메시지를 받는다.
 * 
 * 2) 그러면 클라이언트는 도스 콘솔에서 키보드 입력을 통해 메시지를 보낸다[키보드 입력스트림과 서버쪽 소켓과 연결하여 메시지를 주고받는
 * 인풋/아웃풋 스트림이 필요]
 * 
 * ---------------------------Parsing-------------------------------
 * 
 * 3) 그러면 서버는 클라이언트로부터 받은 메시지를 보고 ㄱ) "안녕하세요?" 나 "하이"란 메시지가 오면 --->"클님 반가워요" 라고
 * 메시지를 보내고 ㄴ) "오늘 날짜는" 이란 메시지가 오면 ----> 오늘 날짜를 보내고 ㄷ) 기타 다른 메시지가 오면 "~~~님 어여
 * 가~~"란 메시지를 보내자.
 * 
 * 
 */
public class EchoServer {

	public static void main(String[] args) throws Exception {

		final int port = 7777;
		ServerSocket server = new ServerSocket(port);
		System.out.println("EchoServer Started");
		Socket sock = server.accept();
		InetAddress inet = sock.getInetAddress();
		String cip = inet.getHostAddress();// 클라이언트 ip주소
		System.out.println(cip + "님이 접속했습니다.###");
		// 1. 서버가 클라이언트에게 "안녕하세요~ ...님" 하고 인사를 건네자.

		PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);// autoflush
		pout.println("안녕하세요?" + cip + "님~~");

		// 2. 클라이언트가 보내오는 메세지를 듣는 입력 스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		// 3. 반복문 돌면서 클라이언트가 보내오는 메세지를 듣고 이를 분석하여 적당한 답변을 보낸다.
		
		String cMsg="";//메세지를 듣기 위한 변수
		while ((cMsg = in.readLine())!=null) {
			System.out.println("cMsg="+cMsg);
			//cMsg를 분석 => parsing 해서 응답을 클라이언트에게 보내자
			if(cMsg.contains("안녕")||cMsg.contains("하이")){
				pout.println(cip+"반가워요");
			}else if (cMsg.contains("오늘 날짜")||cMsg.contains("오늘날짜")) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");
				pout.println(date);
			}else if (cMsg.contains("점심")) {
				pout.println("맛점 하세요~~");
			}else {
				System.out.println("여기...");
				pout.println(cip+"님 어여가~");
				pout.flush();
			}
				
				
		}
		
		// 4. 연결된 자원 close
		pout.close();
		in.close();
		sock.close();
		server.close();
		
		
	}
}
