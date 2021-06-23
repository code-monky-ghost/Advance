package thread.day2;

public class Account {

	private int money = 10;
	private boolean flag = false;

	// 동기화를 하면 Thread의 동시작업의 기능을 약화시키지만 데이터의 정확도는 높여준다.
	// synchronized 를 붙이면 해당 객체의 lock을 쥐어야만 메소드를 수행할 수 있다.
	synchronized public void get(int val) {

		if (!flag) {
			try {
				wait();
				// wait()가 호출이되면 스레드는 수행권한을 포기하고 waiting pool에서 대기함
				// 이때 락을 반납하고 대기상태로 들어간다.

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		} // if---------------------------

		if (money - val < 0) {

			System.out.println("현금 부족: 현재잔액 =" + money + ", 요청금액 : " + val);
			flag = false;
			notify();
			return;
		}
		money -= val;
		System.out.println("출금액 :" + val + "출금 후 잔액:" + money);
		flag = false;
		notify();
	}// get()-------------------------

	public void save(int val) {
		synchronized (this) {
			if (flag) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		////// 다른 동기화방법
			money += val;
			System.out.println("입금액 :" + val + "입금 후 잔액:" + money);

			flag = true; // 반복문 돌기위한 장치

			notify();// waiting pool에 대기 중인 스레드 하나를 깨워 runnable한 상태로 전환시킴
						// notifyAll() ==> 대기 중인 스레드 모두를 깨움
		}//synch----------------------------------------

	}// save()------------------------

}///////////////
