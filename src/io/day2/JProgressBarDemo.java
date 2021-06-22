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

		bar.setStringPainted(true);// 최대값 최소값 표시
		bar.setValue(50);// 진행되는 값
		/*
		 * bt.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { setTitle("test"); }
		 * });
		 */

		// 위 코드를 lambda 식을 이용해 적용해보자.
		bt.addActionListener(e -> {
//			setTitle("lambda");
			//스레드를 생성해서 동작시키기
			Thread tr=new Thread(this);
			tr.start();
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 생성자------

	public void run() {
		goProgress();
	}
	
	public void goProgress() {
		// 0~100까지 반복문 돌면서 bar의 값을 변경하고 bar의 값을 변경하고 sleep하기
		for (int i = 0; i <= bar.getMaximum(); i++) {// bar의 맥시멈 값으로 설정해야 나중에 맥시멈 값을 변경해도 적용가능
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