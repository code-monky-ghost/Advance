package thread.day1;

//java.lang.ThreadŬ������ ��ӹ޾� �����ϴ� ���
//run()�޼ҵ带 �������̵� �Ѵ�.
class SnailThread extends Thread {
	public SnailThread(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(this.getName() + "�����尡 ���ϴ�.");

//			try {
//			Thread.sleep(1000);//1�ʰ� ���� �ܴ�. �и��� 1/1000�� ����
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}

		} /////////////////// for loop

	}// run()/////////////////

}///////////////// snail

public class ThreadTest2 {
	public static void main(String[] args) {
		SnailThread tr1 = new SnailThread("1�ʶ��� ������1");
		SnailThread tr2 = new SnailThread("2Ȧ���� ������2");
		SnailThread tr3 = new SnailThread("3�׶��� ������3");

		tr1.setPriority(Thread.MAX_PRIORITY);// 10
		tr2.setPriority(Thread.NORM_PRIORITY);// 5
		tr3.setPriority(Thread.MIN_PRIORITY);// 1

		tr1.start();
		tr2.start();
		tr3.start();

//		tr2.interrupt();
		/*
		 * sleep()�̳� wait(),join���� �����Ҷ� InterruptedException�� �߻���Ų��.
		 */

//		tr2.stop();//������ ����
		/*
		 * stop()�� ������ ���� ���� ������ �߻���Ű�Ƿ� ������� ����. �����ϸ� ������� �ڿ������� �ϻ��� ��ġ���� ���α׷��� �ؾ��Ѵ�.
		 * run()������ ��ġ�� �״´�.
		 */
//		try {
//			tr2.join();
////			tr2 �����尡 �۾��� �� ��ĥ�� ���� tr2.join()�� ȣ���� ������(���⼭�� ���ν����尡 block���°� �ȴ�.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Thread.yield();
		/*�켱������ ���ų� ���� �����忡�Ը� �纸��.
		 * �ݸ� sleep()�� ���� �켱������ ������� ����.
		 * */
		
		System.out.println("Hello World~~");

	}// main
}//
