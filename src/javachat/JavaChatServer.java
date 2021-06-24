package javachat;
import java.net.*;
import java.io.*;
import java.util.*;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Wildcard;

public class JavaChatServer extends Thread {
   
   private ServerSocket server;
   private int port=9999;
   Vector<JavaChatHandler> userV = new Vector<>(5,3);// �⺻ũ�� 5, ����ġ 3
   
   
   public JavaChatServer() {
      try {
		server = new ServerSocket(port);
		System.out.println("##ä�� ���� ���� �Ǿ����##");
		System.out.println("##["+port+"]��Ʈ���� �����.....##");
	} catch (IOException e) {
		System.out.println("##ä�� ���� ���� �� ����: "+e+"##");
	}
   }
   
   public void run() {
      while (true) {
		try {
			Socket sock=server.accept();
			System.out.println("["+sock.getInetAddress()+"]���� �����߾��###");
			JavaChatHandler chat = new JavaChatHandler(sock,userV);
			chat.start();
			
			
		} catch (IOException e) {
			System.out.println("JavaChatServer()����"+e);
		}
		
	}
   }

   public static void main(String[] args) {
	   new JavaChatServer().start();
	   
	   
   }

}