package thread.day2;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyImagePanel extends JPanel{

	Image img;
	int x=20, y=20;
	public void setImg(Image img) {
		this.img = img;
		
	}
	public Image getImg() {
		return img;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, x, y, this);
	}
}
