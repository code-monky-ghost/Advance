package thread.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JComboBox=> ItemEventListenr => �̺�Ʈ ó���ϱ�
// [1] combo���� ������ �̹����� �����ֱ� InnerClass

// [2] Start��ư ������ �̹��� ������ T0.gif ~ T13.gif������ ���ʷ�
//     �ε��� �ڿ� �ٽ� �׷��ִ� �����带 �����Ѵ�. (�� Runnable�� ��ӹ޾� ����)

// [3] Stop��ư ������ �̹��� ���� �����带 ������Ű��     

public class MyAnimation extends JFrame implements Runnable {

	JPanel p = new JPanel(new BorderLayout());
	JButton btStart, btStop;
	JComboBox<String> combo; // view
	DefaultComboBoxModel<String> cmodel;// model => �����͸� ���´�.

	String[] data = new String[14];// => ������

	MyImagePanel imgP;
	JPanel pN = new JPanel();

	Thread tr;
	boolean isStop = false;

	Toolkit tkit;// ��Ŷ ��ü�� ���ؼ� �̹����� �޾ƿ�
	Image img;

	public MyAnimation() {
		super("::MyAnimation::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.add(pN, "North");
		imgP = new MyImagePanel();
		p.add(imgP, "Center");

		// �𵨿� �޺��ڽ��� ���� �̹��� �̸��ű��
		for (int i = 0; i < data.length; i++) {
			data[i] = "T" + i + ".gif";
		}
		cmodel = new DefaultComboBoxModel<String>(data);
		combo = new JComboBox<String>(cmodel); // view�� model�� ����
		pN.add(combo);

		pN.add(btStart = new JButton("Start"));
		pN.add(btStop = new JButton("Stop"));
		pN.setBackground(Color.white);
		imgP.setBackground(Color.white);

		tkit = Toolkit.getDefaultToolkit();// ��Ŷ ��ü�� ���ؼ� �̹����� �޾ƿ�
		img = tkit.getImage("images/a.png");
		imgP.setImg(img);
		// �̹����� �޸𸮿� �ε�
		imgP.setImg(img);
		// ������ ����---

		Myhander handler = new Myhander();
		combo.addItemListener(handler);
		// ����, ���� ��ư�� ������ ����
		btStart.addActionListener(handler);
		btStop.addActionListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// ������------

	@Override
	public void run() {
		int i = 0;
		while (!isStop) {
			//�ݺ�
//			if(i>13) {
//				i=0;               
//			}
			
			i%=14; ///�ݺ�
			
			
			System.out.println("i=" + i);

			// �̹����� T0.gif ~ T13.gif�� ���ʴ�� �ε��ϰ�
			img = tkit.getImage("images/T" + i + ".gif");

			// imgP�� setter�� �ش� �̹��� �����ϰ� �ٽ� �׷��ֱ�
			imgP.setImg(img);
			imgP.repaint();
			i++;

			// sleep�ɾ��ֱ�
			try {
				Thread.sleep(300);

			} catch (InterruptedException e) {
				System.out.println("error: " + e);
				break;
			}

		} ////////////////////////// while
	}/////////////// run

	// �̺�Ʈ �ڵ鷯
	class Myhander implements ItemListener, ActionListener {

		public void actionPerformed(ActionEvent e) {

			Object o = e.getSource();
			if (o == btStart) {
				isStop = false;

				// tr �����ؼ� ���۽�Ű����
				if (tr == null) {
					
					tr = new Thread(MyAnimation.this);
					// MyHandler ���忡�� �ƿ���Ŭ������ MyAnimation�� ��Ī�ؾ���
					if(!tr.isAlive())//�����尡 ���۵Ǵ� ���� �ƴ϶��
						tr.start();// ��ư�� �������� �����尡 �ߺ����� ���� �ʵ��� ��.
				}

//----------------------------------------------------
//				MyAnimation r = new MyAnimation();
//				r.pack();
//				r.setVisible(true);
//				tr=new Thread(r);
//				tr.start();
//-----------------------------------------------------
//���������� Ʋ���� ������ ���� ��ü�� �ؿ� �ִ� main�� �����尡 ��

			} else if (o == btStop) {
				isStop = true;
				//Ȯ�λ��κ� (�Ʒ�)
				if(tr!=null) {
					tr.interrupt();
					tr=null;
				}
			}
			setTitle("isStop = " + isStop);

		}

		public void itemStateChanged(ItemEvent e) { // Ŭ���ϸ� �ι�Ŭ���Ǿ ==>>

			Object obj = combo.getSelectedItem();
			String file = obj.toString();
			int n = e.getStateChange();
//			System.out.println("file = " + file+", n ="+n);
			if (n == ItemEvent.SELECTED) {
				// �ش� �̹��� ������ �ε�
				img = tkit.getImage("images/" + file);
				// imgP�� ����
				imgP.setImg(img);
				imgP.repaint(); // �׸��� ���� ����°��� �����ش�.
			}

		}

	}

	public static void main(String[] args) {
		MyAnimation my = new MyAnimation();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}