package thread.day2;

public class AccountTest {

	public static void main(String[] args) {

		Account ac = new Account();
		
		UserIn u1 = new UserIn("����", ac);
		UserOut u2 = new UserOut("��¯��", ac);
		
		u2.start();
		u1.start();
		
		
		
		
	}

}
