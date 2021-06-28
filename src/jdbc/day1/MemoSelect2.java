package jdbc.day1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;
public class MemoSelect2 {

	public static void main(String[] args) throws Exception{
		
		String name = JOptionPane.showInputDialog("�˻��� �ۼ��ڸ� �Է��ϼ���");
		if(name == null) return;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!!");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// �������� : dbms����:driverŸ��:host:port:���������ͺ��̽��̸�
		String user = "scott", pwd = "tiger";

		// 2. DB�� ����=> DriverManagerŬ������ getConnection()�޼ҵ� �̿�
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB���� ��....");

		// 3. Statement���
		Statement stmt = con.createStatement();// �������̽���ü�� new�ϸ� �ȵȴ�.
		
		// 4. select�� �ۼ� where�� �ʿ�
		String sql = "Select * from memo where name = '"+name+"'";
		System.out.println(sql);
		
		//5. ResultSet executeQuery(String sql)
		ResultSet rs = stmt.executeQuery(sql);
		
		//�ݺ���
		while(rs.next()) {
//			int idx = rs.getInt("idx");
			int idx = rs.getInt(1);//-->> Column Index�� �ۼ��� �����
			//�÷����� �� ��쿡�� column index�� ��� �����ϴ�
			String name1 = rs.getString("name");
			String msg = rs.getString("msg");
			Date wdate = rs.getDate("wdate");
			System.out.println(idx+"\t"+name1+"\t"+msg+"\t"+wdate+"\t");
		}
		
		//6. �ڿ�ȸ���� �Է��� ������ �ݴ��(����������) �ݾ���� �Ѵ�.
		rs.close();
		stmt.close();
		con.close();
	}

}
