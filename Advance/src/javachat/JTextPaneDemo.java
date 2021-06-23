package javachat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class JTextPaneDemo extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JTextPane tp;
	StyledDocument doc; // JtextPane의 문서모델

	public JTextPaneDemo() {
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		tp = new JTextPane();
		p.add(new JScrollPane(tp), "Center");
		tp.setText("어젯밤 9시까지 집계된 코로나19 신규 확진자 수는 616명입니다.\r\n" + "\r\n" + "전날 같은 시간에 비해 292명 늘어난 숫자입니다.\r\n" + "\r\n"
				+ "주말 검사건수가 줄었던 영향이 사라진 데다, 곳곳에서 다소 큰 규모의 집단감염이 발생한 탓으로 보입니다.\r\n" + "\r\n"
				+ "대전의 한 교회와 가족들 사이에서 시작된 집단 감염으로 33명이 한꺼번에 확진판정을 받았는데, 현재 교인 등 150명을 전수 검사하고 있어 확진 규모는 더 커질 가능성도 있습니다.\r\n"
				+ "");

		// 1. 문서 모델 얻기
		doc = tp.getStyledDocument();
		// 2. SimpleAttributeset 객체를 생성해서 이 객체에 스타일 속성을 부여한다.
		//--> StyleConstants클래스의 static메소드를 통해서 스타일 속성을 설정한다.
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr,"궁서체");//서체
		StyleConstants.setFontSize(attr,28); //글자크기
		
		
		
		// 3. 문서 모델에 해당 속성을 적용시킨다.
		// - setCharacterAttribute():문자특성(폰트, 기울임, 밑줄, 글자색..)
		// - setParagraphAttributes(): 문단특성(문단정렬, 들여쓰기, 문단사이 간격...)
		doc.setCharacterAttributes(0, 30, attr, true);
							//offset, length
		attr=new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);//밑줄
		StyleConstants.setItalic(attr, true);//이텔릭체
		StyleConstants.setForeground(attr, Color.MAGENTA);//글자색
		StyleConstants.setBackground(attr, Color.YELLOW);//배경색
		doc.setCharacterAttributes(30, 20, attr, true);
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
		doc.setParagraphAttributes(80, 100, attr, true);
		
		
		//tp.append()[x]
		//문서끝에 문자열을 추가
		//문서끝의 커릿 위치 알아내기
		int caretPos =doc.getEndPosition().getOffset()-1;
		
		tp.setCaretPosition(caretPos);//문서 끝에 커릿을 위치시킨다.
		
		attr=new SimpleAttributeSet();
		
		StyleConstants.setFontSize(attr,30);
		StyleConstants.setForeground(attr, Color.CYAN);
		
		
		try {
			doc.insertString(caretPos, "\r\n이만 총총..\r\n", attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		//텍스트 페인 라벨 띄우기
		String str="\r\n[happy님]\r\n";
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
		
		
		
		
		
	}// 생성자------

	public static void main(String[] args) {
		JTextPaneDemo my = new JTextPaneDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
