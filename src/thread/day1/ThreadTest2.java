package thread.day1;

//java.lang.Thread클래스를 상속받아 구현하는 방법
//run()메소드를 오버라이드 한다.
class SnailThread extends Thread {
	public SnailThread(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(this.getName() + "스레드가 기어갑니다.");

//			try {
//			Thread.sleep(1000);//1초간 잠을 잔다. 밀리초 1/1000초 단위
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}

		} /////////////////// for loop

	}// run()/////////////////

}///////////////// snail

public class ThreadTest2 {
	public static void main(String[] args) {
		SnailThread tr1 = new SnailThread("1똘똘이 달팽이1");
		SnailThread tr2 = new SnailThread("2홀쭉이 달팽이2");
		SnailThread tr3 = new SnailThread("3뚱뚱이 달팽이3");

		tr1.setPriority(Thread.MAX_PRIORITY);// 10
		tr2.setPriority(Thread.NORM_PRIORITY);// 5
		tr3.setPriority(Thread.MIN_PRIORITY);// 1

		tr1.start();
		tr2.start();
		tr3.start();

//		tr2.interrupt();
		/*
		 * sleep()이나 wait(),join등을 실행할때 InterruptedException을 발생시킨다.
		 */

//		tr2.stop();//강제로 죽임
		/*
		 * stop()은 스레드 사용시 많은 문제를 발생시키므로 사용하지 말자. 가능하면 스레드는 자연스럽게 일생을 마치도록 프로그래밍 해야한다.
		 * run()수행을 마치면 죽는다.
		 */
//		try {
//			tr2.join();
////			tr2 스레드가 작업을 다 마칠때 까지 tr2.join()을 호출한 스레드(여기서는 메인스레드가 block상태가 된다.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Thread.yield();
		/*우선순위가 같거나 높은 스레드에게만 양보함.
		 * 반면 sleep()의 경우는 우선순위와 상관없이 블럭됨.
		 * */
		
		System.out.println("Hello World~~");

	}// main
}//
