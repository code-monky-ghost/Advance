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
/* [�ǽ�]
 * [1] copy��ư�� ���� �׼��̺�Ʈ ó�� 
 * [2]
 * FileInputStream/FileOutputStream
 * BufferedInputStream/BufferedOutputStream
 * ���� Ȱ���ؼ�
 * ���������� �������Ϸ� ī���� �ڿ�
 * [3]JLabel�� �ش� �̹��������� ��Ÿ������ ó���غ���.
 * 
 * [4] ����ٿ� ī�ǵǴ� �ۼ�Ƽ���� �Բ� �����Ű���� ó��
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

	// ����

	public ImageCopyGui2() {
		super("::ImageCopyGui::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		p.add(p2);

		lb = new JLabel("NO IMAGE", JLabel.CENTER);
		p.add(new JScrollPane(lb));// ��ũ�ѹ� ����

		tfSource = new JTextField();
		p2.add(tfSource);

		tfTarget = new JTextField();
		p2.add(tfTarget);

		btCopy = new JButton("Copy");
		p2.add(btCopy);

		bar = new JProgressBar();
		p2.add(bar);

		bar.setStringPainted(true);// �ۼ�������

		// Ÿ��Ʋ����
		tfSource.setBorder(new TitledBorder("::���� �̹��� ����::"));
		tfTarget.setBorder(new TitledBorder("::���� �̹��� ����::"));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btCopy.addActionListener(e -> {
			// ������ ���� �� ����
			Thread tr = new Thread(this);
			tr.start();
		});

	}// ������------

	public void run() {
		try {
			fileCopy();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	synchronized public void fileCopy() throws IOException { // ����ȭ�� �۾��� ���������� �����尡 ������ �ʰ�

		// �׽�Ʈ
		// System.out.println("aaaa");

		// tfSource, tfTarget�� �Է��� �� ������
		String f1 = tfSource.getText();
		String f2 = tfTarget.getText();

		// �Է°� ��, �Է°� ����
		if (f1 == null || f2 == null || f1.trim().isEmpty() || f2.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "�������ϸ�, �������ϸ��� ��� �Է��ϼ���");
			tfSource.requestFocus();
			return;

		}

		// ���������� ũ�⸦ �˾Ƴ���.
		File file1 = new File(f1);
		long fsize = file1.length();
		setTitle("�������� ũ��: " + fsize + "bytes");

		// ���α׷������� �ִ밪�� ���� ũ��� ����.
		bar.setMaximum((int) fsize);

		// ��Ʈ�� ����.
		fis = new FileInputStream(file1);
		bis = new BufferedInputStream(fis);

		fos = new FileOutputStream(f2);
		bos = new BufferedOutputStream(fos);

		// bar�� �ִ밪�� �������� ũ��� ����.

		// �ݺ��� ���鼭 �а� ���� ���� ����Ʈ �� ��ŭ bar�� ���� ǥ��
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
