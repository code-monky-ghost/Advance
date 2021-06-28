package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args) throws Exception {
		String idx = JOptionPane.showInputDialog("������ �� ��ȣ�� �Է��ϼ���.");
		// ��ҽ� �ΰ��� ���ü� ������ �ΰ� üũ
		if (idx == null)
			return;
		// 1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!!");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott", pwd = "tiger";
		// 2.
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB���� ��...");
		// 3.
		Statement stmt = con.createStatement();

		// 4. sql�� ==> delete�� �ۻ�
		String sql = "delete from memo where idx=" + idx;
		System.out.println(sql);
		System.out.println(idx + "���� �����Ǿ����ϴ�.");
		/*
		 * Statement�� �޼ҵ� [1] boolean execute(String sql) :��� sql���� �����Ų��. [2] int
		 * executeUpdate(String sql) : DML����(INSERT, DELETE, UPDATE)�� �����Ű��, DML���忡 ����
		 * ������ ���� ���ڵ� ������ ��ȯ�Ѵ�. [3] ResultSet executeQuery(Stirng sql) : DQL(SELECT��)
		 * ������ �����Ű�� �� ��� ���� ��ȯ�Ѵ�.
		 */

		// 5.
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "���� ���ڵ带 �����߽��ϴ�.");
//		boolean b = stmt.execute(sql);
//		System.out.println("b=="+b);

		/* �⺻������ �ܿ��� �ϴ� sql��
		 * DML (insert, update, delete)
		 * DQL (select)
		 * DDL (create, drop)
		 * */
		
		
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		// 6.

	}

}
