package thread.day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//버튼에 대한 액션 이벤트 처리하기 => Anonymous class로 하기
//스레드 클래스 만들기 => inner class로 만들기
//스레드 할일 => MyPanel의 x또는 y좌표를 반복해서 증가시키기 (sleep걸기)
//시작 버튼 누르면 스레드 동작 시키기
public class MoveCircle extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel();
	MyPanel pC = new MyPanel();
	JButton btStart, btStop;
	MyThread tr = null; // 여러번 작동하는 것을 방지하기 위해 null로 초기화
	boolean isStop = false;

	public MoveCircle() {
		super("::MoveCircle::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);

		p.add(pN, "North");
		p.add(pC, "Center");

		pN.setBackground(Color.cyan);
		btStart = new JButton("Start");
		btStop = new JButton("Stop");

		pN.add(btStart);
		pN.add(btStop);

		btStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				setTitle("Start");
				// 스레드 생성해서 동작시키기
				isStop=false;
				if (tr == null) {
					tr = new MyThread();
					tr.start();
				}
			}
		});
		btStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				setTitle("Stop");
				// 스레드 중지시키기 ==> 반복문에서 break
				isStop=true;// 멈춰야 하니 true로 반환
				if(tr!=null) {
				tr.interrupt();
				tr=null;
				}
			}
		});

		// 창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자------

	int i= 5;//원이 좌우로 움직이기 위해서 변수로 선언 변수를 전역으로 선언해야
			// x좌표가 옳바르게 감
	class MyThread extends Thread {
		
		@Override
		public void run() {
			// pC의 x좌표를 반복 돌면서 무한정 증가시키기
			while (!isStop) {// false값으로 되는 값을 넣어서 반복문 나가게하는 과정
				
				pC.x += i;
				
				if (pC.x > 400) {
					i=-5;// x좌표가 음의 방향으로 이동하기 위한 변수
				}else if(pC.x<0){
					i=5;// x좌표가 양의 방향으로 이동하기 위한 변수
				}
				System.out.println("pC.x = " + pC.x);
				pC.repaint();
				// repaint를 호출하면 jvm이 자동으로 paint()를 호출함.
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("error : " + e.getMessage());
//					e.printStackTrace();

					break;// interrup()을 호출하면 예외가 발생함
					// catch블럭에서 break하면 while루프를 벗어나면서 run()수행 마침

				}
			} ///////////// while
		}//////// run()
	}//////////////////////

	public static void main(String[] args) {
		MoveCircle my = new MoveCircle();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
