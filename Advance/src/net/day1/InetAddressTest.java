package net.day1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress 클래스 : IP를 추상화한 클래스
 */
public class InetAddressTest {

	public static void main(String[] args) {
		InetAddress inet = null; // 생성자가 public 아니다.
//		static InetAddress getByName(String host)  

		try {
			inet = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName():"+inet.getHostName());
			System.out.println("getHostAddress():"+inet.getHostAddress());
			System.out.println("getLocalHost():"+inet.getLocalHost());
			
			InetAddress[] inets = InetAddress.getAllByName("www.daum.net");
			
			if(inets!=null) {
				for(InetAddress ia: inets) {
					System.out.println(ia.getHostAddress());
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
