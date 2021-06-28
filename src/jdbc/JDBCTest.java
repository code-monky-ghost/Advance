package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 /*==JDBC=========================================
  * - Java Database Connectivity의 약자
  * - 자바 프로그램과 데이터베이스가 연동되는 프로그램
  * - 좁은 의미로는 java.sql 패키지를 의미한다.
  * [개발환경] DB(오러클)과 연동하기 위해서는 jdbc driver가 필요하다.
  * java 8.0 ==> ojdbc6.jar(드라이버)
  * => 오라클 사이트가서 jdbc driver로 검색해서 다운로드 받던지
  * 아님 로컬에 설치되어 있는 아래 경로로 가서 찾아보자.
  * [1] C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
  * 
  * [2] ojdbc6.jar파일을 복사하여 아래 경로 붙여넣기 하자.
  * C:\Program Files\Java\jdk1.8.0_261\jre\lib\ext\
  * 
  * [3] eclipse에서는 해당 프로젝트를 선택해서 Installed JRE 경로를
  * C:\Program Files\Java\jdk1.8.0_261 로 변경하여 설정해주자.
  * [4] 오라클 서버 실행
  *     오라클 TNS리스너 실행되어 있어야 함
  * ================================================
  * #jdbc 절차
  * [1] 드라이버를 로딩==> Class.forName("드라이버명")을 이용
  * [2] DB와 연결==> DriverManager.getConnection(db서버url,user,password)
  * [3] sql문을 실행하기 위한 객체 Statement를 얻어온다.
  *     ==> Connection의 createStatement()메소드를 이용해서
  * [4] 쿼리문 작성
  * [5] Statement의 executeXXX()메소드로 해당 쿼리문을 실행시킨 뒤 그 결과를 받아온다.
  * [6] DB연결 자원 반납    
  * */
class JDBCTest 
{
	public static void main(String[] args) 
	{
		try{
		//1. 드라이버 로딩 = > Class.forName("드라이버명")메소드 이용해서 로딩한다.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!!");

		String url="jdbc:oracle:thin:@localhost:1521:XE";
					//프로토콜 : dbms유형:driver타입:host:port:전역데이터베이스이름
		String user ="scott", pwd="tiger";
		//2. DB와 연결=> DriverManager클래스의 getConnection()메소드 이용
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결 됨....");
		



			if(con!=null) con.close();
		}catch(ClassNotFoundException e){
			System.out.println("Driver Loading Fail");
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}
