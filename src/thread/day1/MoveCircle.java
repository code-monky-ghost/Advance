package thread.day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//��ư�� ���� �׼� �̺�Ʈ ó���ϱ� => Anonymous class�� �ϱ�
//������ Ŭ���� ����� => inner class�� �����
//������ ���� => MyPanel�� x�Ǵ� y��ǥ�� �ݺ��ؼ� ������Ű�� (sleep�ɱ�)
//���� ��ư ������ ������ ���� ��Ű��
public class MoveCircle extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pN = new JPanel();
	MyPanel pC = new MyPanel();
	JButton btStart, btStop;
	MyThread tr = null; // ������ �۵��ϴ� ���� �����ϱ� ���� null�� �ʱ�ȭ
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
				// ������ �����ؼ� ���۽�Ű��
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
				// ������ ������Ű�� ==> �ݺ������� break
				isStop=true;// ����� �ϴ� true�� ��ȯ
				if(tr!=null) {
				tr.interrupt();
				tr=null;
				}
			}
		});

		// â�ݱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// ������------

	int i= 5;//���� �¿�� �����̱� ���ؼ� ������ ���� ������ �������� �����ؾ�
			// x��ǥ�� �ǹٸ��� ��
	class MyThread extends Thread {
		
		@Override
		public void run() {
			// pC�� x��ǥ�� �ݺ� ���鼭 ������ ������Ű��
			while (!isStop) {// false������ �Ǵ� ���� �־ �ݺ��� �������ϴ� ����
				
				pC.x += i;
				
				if (pC.x > 400) {
					i=-5;// x��ǥ�� ���� �������� �̵��ϱ� ���� ����
				}else if(pC.x<0){
					i=5;// x��ǥ�� ���� �������� �̵��ϱ� ���� ����
				}
				System.out.println("pC.x = " + pC.x);
				pC.repaint();
				// repaint�� ȣ���ϸ� jvm�� �ڵ����� paint()�� ȣ����.
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("error : " + e.getMessage());
//					e.printStackTrace();

					break;// interrup()�� ȣ���ϸ� ���ܰ� �߻���
					// catch������ break�ϸ� while������ ����鼭 run()���� ��ħ

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
