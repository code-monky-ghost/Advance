package thread.day1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;




public class MyPanel extends JPanel {

	int x=50, y=130, w=80, h=80;
	Color cr=Color.blue;
	
	
	
	public MyPanel() {
		//rgb ���� �����ϰ� ���ؼ� ������ �������� ���� �׷�������.
		
		//Math.random() or RandomŬ���� Ȱ��
		Random random = new Random();
		int r= random.nextInt(256)+0;
		int g= random.nextInt(256)+0;
		int b= random.nextInt(256)+0;
		
		cr=new Color(r,g,b);
		
		//0 ~255 
	}

	//paint()�޼ҵ�� �׸��� �׷��� �� ������ jvm�� �ڵ����� ȣ��ȴ�.
	@Override
	public void paint(Graphics g) {
//		System.out.println("paint()ȣ���");
		super.paint(g);
		g.setColor(cr);
		g.fillOval(x, y, w, h);
	}
	
	
	
	
	
}/////////////
