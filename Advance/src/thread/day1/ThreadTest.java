//[1]
package thread.day1;
/*main()시작                  main()종료
 * |---------------------------------|
 * 
 * |---thread생성 -------->|          |main()
 * |---------thread생성-------------- |main()---------->|thread종료
 * 
 * 
 * */

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("Hello World~~");
		//[1]현재 실행 중인 스레드를 알아보자.
		Thread tr=Thread.currentThread();//currentThread는 작동중인 스레드를 보여준다.
		System.out.println(tr.getName()+"스레드가 실행 중 입니다..");
		
		int cnt=Thread.activeCount();//activeCount는 작동중인 스레드의 개수를 보여준다.
		System.out.println("현재 실행 중인 스레드 개수: "+cnt);
		
		Thread.currentThread().setName("Happy Thread");//스레드 이름 변경
		System.out.println(Thread.currentThread().getName());//변경된 이름 호출
	}

}
