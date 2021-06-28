package jdbc.day1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class MemoSelect {

	public static void main(String[] args) throws Exception{
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
		
		//4.select�� �ۼ�
		String sql = "select idx,name,msg, wdate from memo order by idx asc";
		System.out.println(sql);
		
		//5. ResultSet executeQuery(String sql) //boolean type���δ� ����� ���� ����
		ResultSet rs = stmt.executeQuery(sql);
		/*ResultSet�� select���� ���� ������� ��� ���̺��� �����Ѵ�.
		 * - ������ Ŀ���� �̵���Ű�� ������� �����͸� �����Ѵ�.
		 * - ������ Ŀ���� ù��° ���� ������ ��ġ�ϰ� �ִ�.(before first)
		 * 	 next()�޼ҵ尡 ȣ��Ǹ� Ŀ���� ���� ĭ���� �̵���Ű�� �̵��� ��ġ��
		 * 	���ڵ尡 �ִٸ� true�� ��ȯ�Ѵ�.
		 * 	boolean next()
		 * */
//		System.out.println(rs.next()); --> true
		while(rs.next()) { //Ŀ���� ù��° ���� ������ �ִ�. Ŀ���� �̵��ϸ鼭 ��� 
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String msg = rs.getString("msg");
			Date wdate = rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
			//�������� ���ڵ尡 ������ false�� ��ȯ�ϰ� �ݺ��� �����.
		}
		
		
		//6.
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		
		
		

	}

}
