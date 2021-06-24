package net.day2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class MyChatGui extends JFrame implements Runnable{

   JPanel p = new JPanel(new BorderLayout());
   JPanel pN = new JPanel(new GridLayout(1,0));

   JTextArea ta;
   JTextField tfInput, tfHost, tfNick;
   JButton btCon, btExit;
   
   Socket sock;
   DataInputStream in;
   DataOutputStream out;
   
   Thread listener;
   boolean isStop=false;
   String host, nick;
   
   //상수만들기
   public static final int INIT=0;
   public static final int EXIT=-1;

   public MyChatGui() {
      super("::MyChatGui::");
      Container cp = this.getContentPane();
      cp.add(p, "Center");
      p.setBackground(Color.white);

      //붙이기
      p.add(pN,"North");
      ta=new JTextArea("Welcome to MyChat");
      p.add(new JScrollPane(ta),"Center");
      ta.setBackground(Color.black);
      ta.setForeground(Color.yellow);
      ta.setFont(new Font("sans-serif",Font.BOLD, 18));
      
      tfInput=new JTextField();
      p.add(tfInput,"South");
      tfInput.setBorder(new LineBorder(Color.orange,3));
      
      tfHost=new JTextField("localhost");
      tfNick=new JTextField();
      btCon=new JButton("연결(C)");
      btExit=new JButton("나가기(X)");
      
      btCon.setMnemonic('C');//Alt+C//단축키는 다 대문자로 해야 한다.
      btExit.setMnemonic('X');//Alt+X
      
      pN.add(tfHost);
      pN.add(tfNick);
      pN.add(btCon);
      pN.add(btExit);
      
      tfHost.setBorder(new TitledBorder("::Host::"));
      tfNick.setBorder(new TitledBorder("::Nick::"));
      setEnabled(INIT);
      
      MyHandler my=new MyHandler();
      btCon.addActionListener(my);
      btExit.addActionListener(my);
      tfNick.addActionListener(my);
      tfInput.addActionListener(my);
      
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);에러발생: 
      
      this.addWindowListener(new WindowAdapter() {
    	  
    	  public void windowClosing(WindowEvent e) {
    		  chatExit();
    		  System.exit(0);
    	  }
    	  
	});
      
      
   }//생성자------
   
   public void chatLogin() {
      //닉네임과 호스트명 받기
      nick=tfNick.getText();
      host=tfHost.getText();
      if(nick==null||host==null||nick.trim().isEmpty()||host.trim().isEmpty()) {
         showMSg("호스트명, 닉네임 모두 입력해야 해요");
         return;
      }
      //서버msg를 듣는 리스너 스레드 동작
      isStop=false;
      if(listener==null) {
         listener=new Thread(this);
         listener.start();
         this.setEnabled(EXIT);
      }
   }
   /**나가기 메소드*/
   private void chatExit() {
      //퇴장 확인
      int yn=JOptionPane.showConfirmDialog(ta,"퇴장 할까요?", "퇴장 확인",JOptionPane.YES_NO_OPTION);//퇴장 여부를 한번더 물어줌
      //띄워줄 컴퍼런스위치 넣어주기,나올 내용, 결과내용, 조건
      if(yn==JOptionPane.NO_OPTION) return;
      
      //서버쪽에 퇴장 메시지를 보내자. "Exit#닉네임"
      try {
         out.writeUTF("Exit#"+nick);
         out.flush();
         
         //스레드 중지
         isStop=true;
         listener=null;
         
         //버튼 활성화 여부 지정 
         setEnabled(INIT);
         ta.setText("Welcome to MyChat\n");//초기화
         close();
         
         
      } catch (IOException e) {
         System.out.println("퇴장 중 예외: "+e);
      }
   }
   
   /***/
   private void close() throws IOException{
      isStop=true;
      if(in!=null) {in.close();}
      if(out!=null) {out.close();}
      if(sock!=null) {sock.close();}
   }
   
   private void showMSg(String str) {
      JOptionPane.showMessageDialog(ta, str);
   }
   
   final int port=33333;
   public void run() {
      try {
         sock=new Socket(host,port);
         ta.append("\nConnected to "+host+":33333\n");
         out=new DataOutputStream(sock.getOutputStream());
         in =new DataInputStream(sock.getInputStream());
         //닉네임을 서버쪽에 보내자.
         out.writeUTF(nick);
         out.flush();
         
         //서버가 보내오는 메시지를 듣는 메소드 호출
         listen();
         
      } catch (IOException e) {
         System.out.println("클의 run()예외: "+e);
         ta.append("\n서버 접속 또는 듣는 중 예외 발생: "+e+"\n");
          try {
            close();
         } catch (Exception ex) {
            
         }
      }
   }
   
   /**서버가 보내오는 메시지를 계속 듣고 ta에 출력하는 메소드*/
   private void listen() throws IOException {
      while(!isStop) {
         String serMsg=in.readUTF();
         ta.append(serMsg+"\n");
         //커서의 위치를 ta의 끝으로 이동시키자
         String txt = ta.getText();
         ta.setCaretPosition(txt.length()-1);//
         
         
         
      }
   }


   class MyHandler implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
         Object o=e.getSource();
         if(o==btCon||o==tfNick) {
            chatLogin();
         }else if(o==btExit) {
            chatExit();
         }else if(o==tfInput) {
            String myMsg=tfInput.getText();
            sendMessage(myMsg);
            tfInput.setText("");
         }
      }

   
   }////////
   
   
   /**메세지 보내는 메소드*/
   private void sendMessage(String myMsg) {
      try {
         out.writeUTF(myMsg);
         out.flush();
         
      } catch (Exception e) {
         System.out.println("sendMessage()예외: "+e);
      }
   }
   


   public void setEnabled(int mode) {
      if(mode==INIT) {
         btCon.setEnabled(true);
         btExit.setEnabled(false);
      }else if(mode==EXIT) {
         btCon.setEnabled(false);
         btExit.setEnabled(true);
      }
   }//---------------------------------------

   public static void main(String[] args) {
      MyChatGui my = new MyChatGui();
      my.setSize(500, 700);
      my.setVisible(true);
   }

}