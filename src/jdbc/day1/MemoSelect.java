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
		// 프로토콜 : dbms유형:driver타입:host:port:전역데이터베이스이름
		String user = "scott", pwd = "tiger";

		// 2. DB와 연결=> DriverManager클래스의 getConnection()메소드 이용
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB연결 됨....");

		// 3. Statement얻기
		Statement stmt = con.createStatement();// 인터페이스객체라 new하면 안된다.
		
		//4.select문 작성
		String sql = "select idx,name,msg, wdate from memo order by idx asc";
		System.out.println(sql);
		
		//5. ResultSet executeQuery(String sql) //boolean type으로는 결과값 빼기 힘듬
		ResultSet rs = stmt.executeQuery(sql);
		/*ResultSet은 select문에 의해 영향받은 결과 테이블을 참조한다.
		 * - 논리적인 커서를 이동시키는 방식으로 데이터를 추출한다.
		 * - 논리적인 커서는 첫번째 행의 직전에 위치하고 있다.(before first)
		 * 	 next()메소드가 호출되면 커서를 다음 칸으로 이동시키고 이동한 위치에
		 * 	레코드가 있다면 true를 반환한다.
		 * 	boolean next()
		 * */
//		System.out.println(rs.next()); --> true
		while(rs.next()) { //커서는 첫번째 행의 직전에 있다. 커서를 이동하면서 출력 
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String msg = rs.getString("msg");
			Date wdate = rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
			//마지막에 레코드가 없으면 false를 반환하고 반복문 벗어난다.
		}
		
		
		//6.
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		
		
		

	}

}
