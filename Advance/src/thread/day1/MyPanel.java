//[4]movecircle을 보여주기위해 만든 것
package thread.day1;
import javax.swing.*;
import java.awt.*;
import java.util.*;//random 쓰기위해




public class MyPanel extends JPanel {
	int x=50, y=130, w=80, h=80;
	Color cr=Color.blue;

	public MyPanel() {
		//[1]rgb 값을 랜덤하게 구해서 랜덤한 색상으로 원을 그려보세요.
		//Math.random() or Random클래스 활용
		//0 ~255
		Random ran=new Random();
		int r=ran.nextInt(256)+0;
		int g=ran.nextInt(256);
		int b=ran.nextInt(256);
		
		cr=new Color(r,g,b);
	}
	//paint()메소드는 그림을 그려야 할 순간에 jvm이 자동으로 호출한다.
	@Override//그림판 오버라이드
	public void paint(Graphics g) {
		System.out.println("paint()호출됨");
		super.paint(g);
		g.setColor(cr);
		g.fillOval(x,y,w,h);//사각형을 그리는 drawRect(투명)--x,y인 부분에 w,h인 삼각형
		//fillRect은 색을 채워서 (기본색 검은색)
		//fillOval은 구를 색을 채워서
	}
	
}


