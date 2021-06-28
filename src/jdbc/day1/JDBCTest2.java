package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc�� auto commit�ȴ�.
import javax.swing.JOptionPane;

public class JDBCTest2 {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���.");
		String msg = JOptionPane.showInputDialog("�޸� ������ �Է��ϼ���.");
		if(name == null|| msg==null) {
			System.out.println("�̸��� �ݵ�� �Է��ؾ� �ؿ�.");
			return;
		}
		/*
		 * memo���̺� �Ʒ��� ���� �����͸� �����ϴ� ������ �ۼ��ؼ� �����Ű���� 1 ȫ�浿 �ȳ��ϼ���? �ݰ����ϴ�.
		 * ���ó�¥(sysdate:21/06/28) ==> Insert��
		 * 
		 */
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott", pwd = "tiger";
			// 2. db����
			Connection con = DriverManager.getConnection(url, user, pwd);// auto commit�� ���ش�.
			System.out.println("DB���� ��...");
			// 3. Statement���
			Statement stmt = con.createStatement();
			// ��������: memo_seq
			// 4. ������ �ۼ� ==> insert��
			
			String sql = "Insert INTO MEMO(idx,name,msg,wdate)";
			sql += " VALUES (memo_seq.nextval,'"+name+"','"+msg+"',SYSDATE)";// ���� �ϴ� ������ ����
								//���ǻ��� => ''�� �ݾƾ� �Ѵ�.
			System.out.println(sql);
			
			// 5. �����Ű��
			boolean b = stmt.execute(sql);
			System.out.println("b==" + b);
			
			// 6. �ڿ��ݳ�
			if (stmt != null) // null check
				stmt.close();
			if (con != null) // null check
				con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// main()---------------------

}// -------------------
