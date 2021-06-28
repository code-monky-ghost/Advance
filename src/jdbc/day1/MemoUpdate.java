package jdbc.day1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class MemoUpdate {

	public static void main(String[] args) throws Exception{
		String idx = JOptionPane.showInputDialog("수정할 글번호 입력");
		String name = JOptionPane.showInputDialog("수정할 작성자 입력");
		String msg = JOptionPane.showInputDialog("수정할 글내용 입력");
		
		if(idx==null||msg==null||name==null) return;
		
		//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott", pwd="tiger";
			
			//2.
			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("DB연결됨....");
			//3.
			Statement stmt = con.createStatement();
			//4.
			String sql = "Update memo set name  = '"+name+"', msg='"+msg+"' where idx="+idx;
			System.out.println(sql);
			//5.
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt+"개의 레코드가 업데이터 되었습니다.");
			//6.
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
	}

}
