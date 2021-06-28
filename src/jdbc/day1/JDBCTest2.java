package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc는 auto commit된다.
import javax.swing.JOptionPane;

public class JDBCTest2 {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("작성자를 입력하세요.");
		String msg = JOptionPane.showInputDialog("메모 내용을 입력하세요.");
		if(name == null|| msg==null) {
			System.out.println("이름은 반드시 입력해야 해요.");
			return;
		}
		/*
		 * memo테이블에 아래와 같은 데이터를 삽입하는 문장을 작성해서 실행시키세요 1 홍길동 안녕하세요? 반갑습니다.
		 * 오늘날짜(sysdate:21/06/28) ==> Insert문
		 * 
		 */
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott", pwd = "tiger";
			// 2. db연결
			Connection con = DriverManager.getConnection(url, user, pwd);// auto commit을 해준다.
			System.out.println("DB연결 됨...");
			// 3. Statement얻기
			Statement stmt = con.createStatement();
			// 시퀀스명: memo_seq
			// 4. 쿼리문 작성 ==> insert문
			
			String sql = "Insert INTO MEMO(idx,name,msg,wdate)";
			sql += " VALUES (memo_seq.nextval,'"+name+"','"+msg+"',SYSDATE)";// 띄어쓰기 하는 버릇을 갖자
								//주의사항 => ''로 닫아야 한다.
			System.out.println(sql);
			
			// 5. 실행시키기
			boolean b = stmt.execute(sql);
			System.out.println("b==" + b);
			
			// 6. 자원반납
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
