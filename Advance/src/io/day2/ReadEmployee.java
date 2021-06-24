package io.day2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

import javax.swing.JFrame;

/*
 * [�ǽ�] src/io/day02/obj.txt ������ �о ����� ��ü���� ������Ų��.
 * Employee��ü�� �������Ѽ� print()�޼ҵ� ȣ���غ���
 * 
 * JFrame�� �������Ѽ� setSize(), setVisible(true)�ֱ�
 * 
 * Date��ü�� �������Ѽ� toString()ȣ���ؼ� ����ϱ�
 * 
 * JFrame�� �������Ѽ� setSize(), setVisible(true)�ֱ�
 * 
 * [1] ������ �ҽ�: ����===> FileInputStream ===>ObjectInputStream
 * 
 *       Object readObject()
 *      �� ������� �о�� �Կ� ��������.
 * */
public class ReadEmployee {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String file = "obj.txt";

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

		//������� ��������� �ϴ��� �����ؾ��Ѵ�.
		Employee o1 = (Employee) ois.readObject();
		o1.print();

		Employee o2 = (Employee) ois.readObject();
		o2.print();

		JFrame jf = (JFrame) ois.readObject();
		jf.setSize(200, 200);
		jf.setVisible(true);

		Date d = (Date) ois.readObject();
		System.out.println(d.toString());//����Ǿ��� �ð��� ������

		ois.close();

	}// �ҷ��� Ŭ������ ��ü�� �������
}
