package thread.day1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;




public class MyPanel extends JPanel {

	int x=50, y=130, w=80, h=80;
	Color cr=Color.blue;
	
	
	
	public MyPanel() {
		//rgb 값을 랜덤하게 구해서 랜덤한 색상으로 원을 그려보세요.
		
		//Math.random() or Random클래스 활용
		Random random = new Random();
		int r= random.nextInt(256)+0;
		int g= random.nextInt(256)+0;
		int b= random.nextInt(256)+0;
		
		cr=new Color(r,g,b);
		
		//0 ~255 
	}

	//paint()메소드는 그림을 그려야 할 순간에 jvm이 자동으로 호출된다.
	@Override
	public void paint(Graphics g) {
//		System.out.println("paint()호출됨");
		super.paint(g);
		g.setColor(cr);
		g.fillOval(x, y, w, h);
	}
	
	
	
	
	
}/////////////
