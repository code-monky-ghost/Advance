package io.day2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarDemo extends JFrame implements Runnable{

	JPanel p = new JPanel();

	JProgressBar bar;
	JButton bt;

	public JProgressBarDemo() {
		super("::JProgressBarDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);

		bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		p.add(bar);
		bt = new JButton("Copy");
		p.add(bt);

		bar.setStringPainted(true);// �ִ밪 �ּҰ� ǥ��
		bar.setValue(50);// ����Ǵ� ��
		/*
		 * bt.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { setTitle("test"); }
		 * });
		 */

		// �� �ڵ带 lambda ���� �̿��� �����غ���.
		bt.addActionListener(e -> {
//			setTitle("lambda");
			//�����带 �����ؼ� ���۽�Ű��
			Thread tr=new Thread(this);
			tr.start();
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// ������------

	public void run() {
		goProgress();
	}
	
	public void goProgress() {
		// 0~100���� �ݺ��� ���鼭 bar�� ���� �����ϰ� bar�� ���� �����ϰ� sleep�ϱ�
		for (int i = 0; i <= bar.getMaximum(); i++) {// bar�� �ƽø� ������ �����ؾ� ���߿� �ƽø� ���� �����ص� ���밡��
			bar.setValue(i);
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}

	public static void main(String[] args) {
		JProgressBarDemo my = new JProgressBarDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}