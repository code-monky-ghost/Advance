package jdbc.day1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;
public class MemoSelect2 {

	public static void main(String[] args) throws Exception{
		
		String name = JOptionPane.showInputDialog("검색할 작성자를 입력하세요");
		if(name == null) return;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!!");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 프로토콜 : dbms유형:driver타입:host:port:전역데이터베이스이름
		String user = "scott", pwd = "tiger";

		// 2. DB와 연결=> DriverManager클래스의 getConnection()메소드 이용
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB연결 됨....");

		// 3. Statement얻기
		Statement stmt = con.createStatement();// 인터페이스객체라 new하면 안된다.
		
		// 4. select문 작성 where절 필요
		String sql = "Select * from memo where name = '"+name+"'";
		System.out.println(sql);
		
		//5. ResultSet executeQuery(String sql)
		ResultSet rs = stmt.executeQuery(sql);
		
		//반복문
		while(rs.next()) {
//			int idx = rs.getInt("idx");
			int idx = rs.getInt(1);//-->> Column Index로 작성한 경우임
			//컬럼명이 길 경우에는 column index로 적어도 가능하다
			String name1 = rs.getString("name");
			String msg = rs.getString("msg");
			Date wdate = rs.getDate("wdate");
			System.out.println(idx+"\t"+name1+"\t"+msg+"\t"+wdate+"\t");
		}
		
		//6. 자원회수시 입력한 순서의 반대로(마지막부터) 닫아줘야 한다.
		rs.close();
		stmt.close();
		con.close();
	}

}
