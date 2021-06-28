package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args) throws Exception {
		String idx = JOptionPane.showInputDialog("삭제할 글 번호를 입력하세요.");
		// 취소시 널값이 들어올수 있으니 널값 체크
		if (idx == null)
			return;
		// 1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!!");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott", pwd = "tiger";
		// 2.
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB연결 됨...");
		// 3.
		Statement stmt = con.createStatement();

		// 4. sql문 ==> delete문 작상
		String sql = "delete from memo where idx=" + idx;
		System.out.println(sql);
		System.out.println(idx + "번이 삭제되었습니다.");
		/*
		 * Statement의 메소드 [1] boolean execute(String sql) :모든 sql문을 실행시킨다. [2] int
		 * executeUpdate(String sql) : DML문장(INSERT, DELETE, UPDATE)을 실행시키고, DML문장에 의해
		 * 영향을 받은 레코드 개수를 반환한다. [3] ResultSet executeQuery(Stirng sql) : DQL(SELECT문)
		 * 문장을 실행시키고 그 결과 셋을 반환한다.
		 */

		// 5.
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "개의 레코드를 삭제했습니다.");
//		boolean b = stmt.execute(sql);
//		System.out.println("b=="+b);

		/* 기본적으로 외워야 하는 sql문
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
