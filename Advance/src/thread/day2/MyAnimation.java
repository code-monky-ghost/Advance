package thread.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JComboBox=> ItemEventListenr => 이벤트 처리하기
// [1] combo에서 선택한 이미지를 보여주기 InnerClass

// [2] Start버튼 누르면 이미지 파일이 T0.gif ~ T13.gif파일을 차례로
//     로드한 뒤에 다시 그려주는 스레드를 구현한다. (단 Runnable을 상속받아 구현)

// [3] Stop버튼 누르면 이미지 동작 스레드를 중지시키기     

public class MyAnimation extends JFrame implements Runnable {

	JPanel p = new JPanel(new BorderLayout());
	JButton btStart, btStop;
	JComboBox<String> combo; // view
	DefaultComboBoxModel<String> cmodel;// model => 데이터를 갖는다.

	String[] data = new String[14];// => 데이터

	MyImagePanel imgP;
	JPanel pN = new JPanel();

	Thread tr;
	boolean isStop = false;

	Toolkit tkit;// 툴킷 객체를 통해서 이미지를 받아옴
	Image img;

	public MyAnimation() {
		super("::MyAnimation::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.add(pN, "North");
		imgP = new MyImagePanel();
		p.add(imgP, "Center");

		// 모델에 콤보박스에 넣을 이미지 이름매기기
		for (int i = 0; i < data.length; i++) {
			data[i] = "T" + i + ".gif";
		}
		cmodel = new DefaultComboBoxModel<String>(data);
		combo = new JComboBox<String>(cmodel); // view와 model을 결합
		pN.add(combo);

		pN.add(btStart = new JButton("Start"));
		pN.add(btStop = new JButton("Stop"));
		pN.setBackground(Color.white);
		imgP.setBackground(Color.white);

		tkit = Toolkit.getDefaultToolkit();// 툴킷 객체를 통해서 이미지를 받아옴
		img = tkit.getImage("images/a.png");
		imgP.setImg(img);
		// 이미지를 메모리에 로드
		imgP.setImg(img);
		// 리스너 부착---

		Myhander handler = new Myhander();
		combo.addItemListener(handler);
		// 시작, 중지 버튼에 리스너 부착
		btStart.addActionListener(handler);
		btStop.addActionListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 생성자------

	@Override
	public void run() {
		int i = 0;
		while (!isStop) {
			//반복
//			if(i>13) {
//				i=0;               
//			}
			
			i%=14; ///반복
			
			
			System.out.println("i=" + i);

			// 이미지를 T0.gif ~ T13.gif로 차례대로 로드하고
			img = tkit.getImage("images/T" + i + ".gif");

			// imgP에 setter로 해당 이미지 설정하고 다시 그려주기
			imgP.setImg(img);
			imgP.repaint();
			i++;

			// sleep걸어주기
			try {
				Thread.sleep(300);

			} catch (InterruptedException e) {
				System.out.println("error: " + e);
				break;
			}

		} ////////////////////////// while
	}/////////////// run

	// 이벤트 핸들러
	class Myhander implements ItemListener, ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object o = e.getSource();
			if (o == btStart) {
				isStop = false;

				// tr 생성해서 동작시키세요
				if (tr == null) {
					
					tr = new Thread(MyAnimation.this);
					// MyHandler 입장에서 아우터클래스인 MyAnimation을 지칭해야함
					if(!tr.isAlive())//스레드가 동작되는 것이 아니라면
						tr.start();// 버튼을 눌렀을때 스레드가 중복생성 되지 않도록 함.
				}

//----------------------------------------------------
//				MyAnimation r = new MyAnimation();
//				r.pack();
//				r.setVisible(true);
//				tr=new Thread(r);
//				tr.start();
//-----------------------------------------------------
//문법적으로 틀리지 않으나 실제 객체는 밑에 있는 main의 스레드가 됨

			} else if (o == btStop) {
				isStop = true;
				//확인사살부분 (아래)
				if(tr!=null) {
					tr.interrupt();
					tr=null;
				}
			}
			setTitle("isStop = " + isStop);

		}

		public void itemStateChanged(ItemEvent e) { // 클릭하면 두번클릭되어서 ==>>

			Object obj = combo.getSelectedItem();
			String file = obj.toString();
			int n = e.getStateChange();
//			System.out.println("file = " + file+", n ="+n);
			if (n == ItemEvent.SELECTED) {
				// 해당 이미지 파일을 로드
				img = tkit.getImage("images/" + file);
				// imgP에 설정
				imgP.setImg(img);
				imgP.repaint(); // 그림자 같이 생기는것을 없애준다.
			}

		}

	}

	public static void main(String[] args) {
		MyAnimation my = new MyAnimation();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}