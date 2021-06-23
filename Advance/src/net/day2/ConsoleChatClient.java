//[2]6/21
package net.day2;
import java.net.*;
import java.io.*;
import javax.swing.*;
/*구현할 내용
 *  - 채팅 서버와 클라이언트가 1대1로 채팅하는 프로그램
 *  1)  키보드로 메시지를 입력해서 서버쪽에 보냄
 *  2) 서버가 메시지를 보내오면 이를 듣고 콘솔에 출력
 * */
public class ConsoleChatClient extends Thread{

   Socket sock;
   String ip;
   final int port=7369;
   BufferedReader key, in;
   PrintWriter out;
   
   public ConsoleChatClient() {
      // TODO Auto-generated constructor stub
      if(ip==null) return;
      //1. 소켓 생성
      
      //2. 키보드 입력스트림 생성
      
      //3. 서버로 내보낼 출력스트림 생성
      
      //4. 서버가 보내오는 메시지를 듣는 스레드 생성해서 동작시키기
      
      
      //5. 키보드 입력하면서 메시지 보내기
   }
   
   public void run() {
      //서버가 보내오는 메시지를 계속 듣고 콘솔에 출력한다.
   }

   public static void main(String[] args) {
      ConsoleChatClient client=new ConsoleChatClient();
      client.ip=JOptionPane.showInputDialog("접속할 서버의 IP주소를 입력하세요");
      

   }

}