package thread.day2;

public class SnailTest {

	public static void main(String[] args) {
		// [1] Runnable객체 생성하기
		Snail r = new Snail(); // 스레드의 코드부분을 갖고 있다.

		// [2] Thread와 [1]번 객체를 연결
		Thread tr = new Thread(r);

		// [3] 스레드 동작
		tr.start();

	}

}
