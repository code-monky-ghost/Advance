package io.day2;

/**
 * 객체를 스트림으로 내보내거나, 네트워크로 전송하려면
 * 반드시 java.io.Serializable 인터페이스를 상속받아야 한다.
 * Serializable 인터페이스에는 추상메소드는 없고  단순히
 * 객체를 일렬로 나열해서 네트워크로 전송할 준비가 되었다는 
 * 표시를 해주는 기능을 한다.
 * */
import sun.net.www.content.text.plain;
import java.io.*;

public class Employee implements Serializable{

	private String name;
	private int deptno;
	private String job;
	transient private int sal;
	//transient가 붙은 데이터는 직렬화시 디폴트값으로 저장함
	public Employee(String name, int deptno, String job, int sal) {
		super();
		this.name = name;
		this.deptno = deptno;
		this.job = job;
		this.sal = sal;
	}
	//객체를 생성하려면 직렬화를 해야한다.
	public void print() {
		System.out.println("-------Record for "+name+"---------");
		System.out.println("Dept No"+deptno);
		System.out.println("Job: "+job);
		System.out.println("Salary: "+sal);
		
	}
	
	
	
	
	
}////////////////////////
