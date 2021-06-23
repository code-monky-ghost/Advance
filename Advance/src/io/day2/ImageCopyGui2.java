package io.day2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/* [실습]
 * [1] copy버튼에 대한 액션이벤트 처리 
 * [2]
 * FileInputStream/FileOutputStream
 * BufferedInputStream/BufferedOutputStream
 * 등을 활용해서
 * 원본파일을 목적파일로 카피한 뒤에
 * [3]JLabel에 해당 이미지파일이 나타나도록 처리해보자.
 * 
 * [4] 진행바에 카피되는 퍼센티지를 함께 진행시키도록 처리
 * */

public class ImageCopyGui2 extends JFrame implements Runnable {

	JPanel p = new JPanel(new GridLayout(2, 1));
	JPanel p2 = new JPanel(new GridLayout(4, 1, 10, 10));

	JTextField tfSource, tfTarget;
	JButton btCopy;
	JProgressBar bar;
	JLabel lb;

	FileInputStream fis;
	BufferedInputStream bis;

	FileOutputStream fos;
	BufferedOutputStream bos;

	// 파일

	public ImageCopyGui2() {
		super("::ImageCopyGui::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.add(p2);

		lb = new JLabel("NO IMAGE", JLabel.CENTER);
		p.add(new JScrollPane(lb));// 스크롤바 생성

		tfSource = new JTextField();
		p2.add(tfSource);

		tfTarget = new JTextField();
		p2.add(tfTarget);

		btCopy = new JButton("Copy");
		p2.add(btCopy);

		bar = new JProgressBar();
		p2.add(bar);

		bar.setStringPainted(true);// 퍼센테이지

		// 타이틀보더
		tfSource.setBorder(new TitledBorder("::원본 이미지 파일::"));
		tfTarget.setBorder(new TitledBorder("::목적 이미지 파일::"));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btCopy.addActionListener(e -> {
			// 스레드 생성 및 동작
			Thread tr = new Thread(this);
			tr.start();
		});

	}// 생성자------

	public void run() {
		try {
			fileCopy();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	synchronized public void fileCopy() throws IOException { // 동기화로 작업이 끝나기전에 쓰레드가 멈추지 않게

		// 테스트
		// System.out.println("aaaa");

		// tfSource, tfTarget에 입력한 값 얻어오기
		String f1 = tfSource.getText();
		String f2 = tfTarget.getText();

		// 입력값 널, 입력값 공백
		if (f1 == null || f2 == null || f1.trim().isEmpty() || f2.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "원본파일명, 목적파일명을 모두 입력하세요");
			tfSource.requestFocus();
			return;

		}

		// 원본파일의 크기를 알아내자.
		File file1 = new File(f1);
		long fsize = file1.length();
		setTitle("원본파일 크기: " + fsize + "bytes");

		// 프로그래스바의 최대값을 파일 크기로 설정.
		bar.setMaximum((int) fsize);

		// 스트림 연결.
		fis = new FileInputStream(file1);
		bis = new BufferedInputStream(fis);

		fos = new FileOutputStream(f2);
		bos = new BufferedOutputStream(fos);

		// bar의 최대값을 원본파일 크기로 설정.

		// 반복문 돌면서 읽고 읽은 남은 바이트 수 만큼 bar에 값을 표시
		int n = 0, count = 0;

		while ((n = bis.read()) != -1) {
			bos.write(n);
			bos.flush();
			count++;
			bar.setValue(count);

		}

		bos.close();
		fos.close();
		bis.close();
		fis.close();

		lb.setIcon(new ImageIcon(f2));
		lb.setText("");
	}

	public static void main(String[] args) {
		ImageCopyGui2 my = new ImageCopyGui2();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
