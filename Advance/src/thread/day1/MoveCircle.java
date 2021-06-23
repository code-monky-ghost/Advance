//[3]
package thread.day1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//버튼에 대한 액션 이벤트 처리하기 => Anonymous class로 하기
//스레드 클래스 만들기=> inner class로 만들기
//스레드 할일=> MyPanel의 x 또는 y좌표를 반복해서 증가시키기
//시작 버튼 누르면 스레드 동작 시키기


public class MoveCircle extends JFrame {
	
	JPanel p = new JPanel(new BorderLayout());
	JPanel pN=new JPanel();
	MyPanel pC=new MyPanel();
	JButton btStart, btStop;
	MyThread tr=null;
	boolean isStop=false;
	
	
	public MoveCircle() {
		super("::MoveCircle::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		p.add(pN,"North");
		p.add(pC,"Center");
		
		pN.setBackground(Color.cyan);
		btStart=new JButton(" Start ");
		btStop=new JButton(" Stop ");
		
		pN.add(btStart);
		pN.add(btStop);
		//버튼에 액션 이벤트 처리(anonymous class)로
		btStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//setTitle("start"); 처리가 잘 되는지 확인하기 위해 만든 것
				//스레드 생성해서 동작시키기
				//MyThread tr=new MyThread();지역변수로 하지말고 전역변수로 만듬 위에 확인
				isStop=false;
				if(tr==null) {
				tr=new MyThread();
				tr.start();
				}
			}
		});
		
		btStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//setTitle("stop");
				//스레드 중지시키기
				isStop=true;
				if(tr!=null) {
					tr.interrupt();
					tr=null;
				}
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------
	int i=5;
	class MyThread extends Thread{
		
		@Override
		public void run() {
			//pC의 x좌표를 반복 돌면서 증가시키기
			while(!isStop) {//튕겨내기 위해 i를 소환해서 부
					if(pC.x>400) {
						i=-5;
						}
					if(pC.x<0)
					{
						i=5;
					}
					pC.x+=i;
					System.out.println("pC.x="+pC.x);//이건 호출되는지 볼려고 넣어봄
					pC.repaint();//repaint()를 호출하면 jvm이 자동으로 paint()호출함
					try {
						Thread.sleep(100);//0.1초간 슬립(안하면 확인하기 힘듬)
					}catch(InterruptedException e) {
						System.out.println("error: "+e.getMessage());
					//e.printStackTrace();--스탑버튼이 먹는가 확인하기 위해
					break;//break를 걸어줘야 stop먹음
					//interrup()을 호출하면 예외가 발생함
					//catch블럭에서 break하면 while루프를 벗어나면서 run()
					//수행을 마치게 된다.
					}
				}//while----------------
		}//run()------------------
	}//////////////////
	
	
	public static void main(String[] args) {
		MoveCircle my = new MoveCircle();
		my.setSize(500, 500);
		my.setVisible(true);
	}
}
	