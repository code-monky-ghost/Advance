package thread.day2;

import javax.swing.*;

//java.lang.Runnable �������̽��� ��ӹ޾� ���� => �߻�޼ҵ� : run()
public class Snail extends JPanel implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {

			System.out.println("�����̰� ����~~");

			// TODO: handle exception
			int sec = (int) (Math.random() * 2000);
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
