package io.day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

import javax.swing.JFrame;

/*
 * [실습] src/io/day02/obj.txt 파일을 읽어서 저장된 객체들을 복원시킨다.
 * Employee객체를 복원시켜서 print()메소드 호출해보기
 * 
 * JFrame도 복원시켜서 setSize(), setVisible(true)주기
 * 
 * Date객체를 복원시켜서 toString()호출해서 출력하기
 * 
 * JFrame도 복원시켜서 setSize(), setVisible(true)주기
 * 
 * [1] 데이터 소스: 파일===> FileInputStream ===>ObjectInputStream
 * 
 *       Object readObject()
 *      쓴 순서대로 읽어야 함에 주의하자.
 * */
public class ReadEmployee {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String file = "obj.txt";

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

		//순서대로 적용해줘야 하는점 주의해야한다.
		Employee o1 = (Employee) ois.readObject();
		o1.print();

		Employee o2 = (Employee) ois.readObject();
		o2.print();

		JFrame jf = (JFrame) ois.readObject();
		jf.setSize(200, 200);
		jf.setVisible(true);

		Date d = (Date) ois.readObject();
		System.out.println(d.toString());//저장되었던 시간을 보여줌

		ois.close();

	}// 불러올 클래스의 객체의 순서대로
}
