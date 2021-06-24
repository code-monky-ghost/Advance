package thread.day2;

import javax.swing.*;

//java.lang.Runnable 인터페이스를 상속받아 구현 => 추상메소드 : run()
public class Snail extends JPanel implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {

			System.out.println("달팽이가 기어가요~~");

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
