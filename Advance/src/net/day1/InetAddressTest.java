package net.day1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress Ŭ���� : IP�� �߻�ȭ�� Ŭ����
 */
public class InetAddressTest {

	public static void main(String[] args) {
		InetAddress inet = null; // �����ڰ� public �ƴϴ�.
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
