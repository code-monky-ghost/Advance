package io.day2;

/**
 * ��ü�� ��Ʈ������ �������ų�, ��Ʈ��ũ�� �����Ϸ���
 * �ݵ�� java.io.Serializable �������̽��� ��ӹ޾ƾ� �Ѵ�.
 * Serializable �������̽����� �߻�޼ҵ�� ����  �ܼ���
 * ��ü�� �Ϸķ� �����ؼ� ��Ʈ��ũ�� ������ �غ� �Ǿ��ٴ� 
 * ǥ�ø� ���ִ� ����� �Ѵ�.
 * */
import sun.net.www.content.text.plain;
import java.io.*;

public class Employee implements Serializable{

	private String name;
	private int deptno;
	private String job;
	transient private int sal;
	//transient�� ���� �����ʹ� ����ȭ�� ����Ʈ������ ������
	public Employee(String name, int deptno, String job, int sal) {
		super();
		this.name = name;
		this.deptno = deptno;
		this.job = job;
		this.sal = sal;
	}
	//��ü�� �����Ϸ��� ����ȭ�� �ؾ��Ѵ�.
	public void print() {
		System.out.println("-------Record for "+name+"---------");
		System.out.println("Dept No"+deptno);
		System.out.println("Job: "+job);
		System.out.println("Salary: "+sal);
		
	}
	
	
	
	
	
}////////////////////////
