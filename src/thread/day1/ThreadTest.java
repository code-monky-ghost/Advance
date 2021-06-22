package thread.day1;

/*main()����                  main()����
 * |---------------------------------|
 * 
 * |---thread���� -------->|          |main()
 * |---------thread����-------------- |main()---------->|thread����
 * 
 * 
 * */
public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("Hello world~~");
		// ���� �������� �����带 �˾ƺ���.
		Thread tr = Thread.currentThread();
		System.out.println(tr.getName()+"�����尡 ������ �Դϴ�.");
		
		int cnt=Thread.activeCount();
		System.out.println("���� �������� ������ ����:"+cnt);
		
		Thread.currentThread().setName("Happy Thread");
		System.out.println(Thread.currentThread().getName()+"�� �̸� ����");
		
		
		
	}

}
