package javachat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneDemo extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JTextPane tp;
	StyledDocument doc; // JtextPane�� ������

	public JTextPaneDemo() {
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		tp = new JTextPane();
		p.add(new JScrollPane(tp), "Center");
		tp.setText("������ 9�ñ��� ����� �ڷγ�19 �ű� Ȯ���� ���� 616���Դϴ�.\r\n" + "\r\n" + "���� ���� �ð��� ���� 292�� �þ �����Դϴ�.\r\n" + "\r\n"
				+ "�ָ� �˻�Ǽ��� �پ��� ������ ����� ����, �������� �ټ� ū �Ը��� ���ܰ����� �߻��� ſ���� ���Դϴ�.\r\n" + "\r\n"
				+ "������ �� ��ȸ�� ������ ���̿��� ���۵� ���� �������� 33���� �Ѳ����� Ȯ�������� �޾Ҵµ�, ���� ���� �� 150���� ���� �˻��ϰ� �־� Ȯ�� �Ը�� �� Ŀ�� ���ɼ��� �ֽ��ϴ�.\r\n"
				+ "");

		// 1. ���� �� ���
		doc = tp.getStyledDocument();
		// 2. SimpleAttributeset ��ü�� �����ؼ� �� ��ü�� ��Ÿ�� �Ӽ��� �ο��Ѵ�.
		//--> StyleConstantsŬ������ static�޼ҵ带 ���ؼ� ��Ÿ�� �Ӽ��� �����Ѵ�.
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr,"�ü�ü");//��ü
		StyleConstants.setFontSize(attr,28); //����ũ��
		
		
		
		// 3. ���� �𵨿� �ش� �Ӽ��� �����Ų��.
		// - setCharacterAttribute():����Ư��(��Ʈ, �����, ����, ���ڻ�..)
		// - setParagraphAttributes(): ����Ư��(��������, �鿩����, ���ܻ��� ����...)
		doc.setCharacterAttributes(0, 30, attr, true);
							//offset, length
		attr=new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);//����
		StyleConstants.setItalic(attr, true);//���ڸ�ü
		StyleConstants.setForeground(attr, Color.MAGENTA);//���ڻ�
		StyleConstants.setBackground(attr, Color.YELLOW);//����
		doc.setCharacterAttributes(30, 20, attr, true);
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
		doc.setParagraphAttributes(80, 100, attr, true);
		
		
		//tp.append()[x]
		//�������� ���ڿ��� �߰�
		//�������� Ŀ�� ��ġ �˾Ƴ���
		int caretPos =doc.getEndPosition().getOffset()-1;
		
		tp.setCaretPosition(caretPos);//���� ���� Ŀ���� ��ġ��Ų��.
		
		attr=new SimpleAttributeSet();
		
		StyleConstants.setFontSize(attr,30);
		StyleConstants.setForeground(attr, Color.CYAN);
		
		
		try {
			doc.insertString(caretPos, "\r\n�̸� ����..\r\n", attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		//�ؽ�Ʈ ���� �� ����
		String str="\r\n[happy��]\r\n";
		ImageIcon icon = new ImageIcon("src/images/1.png");
		
		JLabel lb = new JLabel(str,icon,JLabel.CENTER);
		
		attr=new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
		
		caretPos=doc.getEndPosition().getOffset()-1;
		tp.setCaretPosition(caretPos);
		tp.insertComponent(lb);
		
		
		doc.setParagraphAttributes(caretPos, str.length(), attr, true);
		
		
		
		
		p.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}// ������------

	public static void main(String[] args) {
		JTextPaneDemo my = new JTextPaneDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
