package jdbc.day1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class MemoUpdate {

	public static void main(String[] args) throws Exception{
		String idx = JOptionPane.showInputDialog("������ �۹�ȣ �Է�");
		String name = JOptionPane.showInputDialog("������ �ۼ��� �Է�");
		String msg = JOptionPane.showInputDialog("������ �۳��� �Է�");
		
		if(idx==null||msg==null||name==null) return;
		
		//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott", pwd="tiger";
			
			//2.
			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("DB�����....");
			//3.
			Statement stmt = con.createStatement();
			//4.
			String sql = "Update memo set name  = '"+name+"', msg='"+msg+"' where idx="+idx;
			System.out.println(sql);
			//5.
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt+"���� ���ڵ尡 �������� �Ǿ����ϴ�.");
			//6.
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
	}

}
