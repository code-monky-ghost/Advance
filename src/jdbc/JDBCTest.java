package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 /*==JDBC=========================================
  * - Java Database Connectivity�� ����
  * - �ڹ� ���α׷��� �����ͺ��̽��� �����Ǵ� ���α׷�
  * - ���� �ǹ̷δ� java.sql ��Ű���� �ǹ��Ѵ�.
  * [����ȯ��] DB(����Ŭ)�� �����ϱ� ���ؼ��� jdbc driver�� �ʿ��ϴ�.
  * java 8.0 ==> ojdbc6.jar(����̹�)
  * => ����Ŭ ����Ʈ���� jdbc driver�� �˻��ؼ� �ٿ�ε� �޴���
  * �ƴ� ���ÿ� ��ġ�Ǿ� �ִ� �Ʒ� ��η� ���� ã�ƺ���.
  * [1] C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
  * 
  * [2] ojdbc6.jar������ �����Ͽ� �Ʒ� ��� �ٿ��ֱ� ����.
  * C:\Program Files\Java\jdk1.8.0_261\jre\lib\ext\
  * 
  * [3] eclipse������ �ش� ������Ʈ�� �����ؼ� Installed JRE ��θ�
  * C:\Program Files\Java\jdk1.8.0_261 �� �����Ͽ� ����������.
  * [4] ����Ŭ ���� ����
  *     ����Ŭ TNS������ ����Ǿ� �־�� ��
  * ================================================
  * #jdbc ����
  * [1] ����̹��� �ε�==> Class.forName("����̹���")�� �̿�
  * [2] DB�� ����==> DriverManager.getConnection(db����url,user,password)
  * [3] sql���� �����ϱ� ���� ��ü Statement�� ���´�.
  *     ==> Connection�� createStatement()�޼ҵ带 �̿��ؼ�
  * [4] ������ �ۼ�
  * [5] Statement�� executeXXX()�޼ҵ�� �ش� �������� �����Ų �� �� ����� �޾ƿ´�.
  * [6] DB���� �ڿ� �ݳ�    
  * */
class JDBCTest 
{
	public static void main(String[] args) 
	{
		try{
		//1. ����̹� �ε� = > Class.forName("����̹���")�޼ҵ� �̿��ؼ� �ε��Ѵ�.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!!");

		String url="jdbc:oracle:thin:@localhost:1521:XE";
					//�������� : dbms����:driverŸ��:host:port:���������ͺ��̽��̸�
		String user ="scott", pwd="tiger";
		//2. DB�� ����=> DriverManagerŬ������ getConnection()�޼ҵ� �̿�
		Connection con = DriverManager.getConnection(url,user,pwd);
		System.out.println("DB���� ��....");
		



			if(con!=null) con.close();
		}catch(ClassNotFoundException e){
			System.out.println("Driver Loading Fail");
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}
