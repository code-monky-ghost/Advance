package thread.day2;

public class Account {

	private int money = 10;
	private boolean flag = false;

	// ����ȭ�� �ϸ� Thread�� �����۾��� ����� ��ȭ��Ű���� �������� ��Ȯ���� �����ش�.
	// synchronized �� ���̸� �ش� ��ü�� lock�� ���߸� �޼ҵ带 ������ �� �ִ�.
	synchronized public void get(int val) {

		if (!flag) {
			try {
				wait();
				// wait()�� ȣ���̵Ǹ� ������� ��������� �����ϰ� waiting pool���� �����
				// �̶� ���� �ݳ��ϰ� �����·� ����.

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		} // if---------------------------

		if (money - val < 0) {

			System.out.println("���� ����: �����ܾ� =" + money + ", ��û�ݾ� : " + val);
			flag = false;
			notify();
			return;
		}
		money -= val;
		System.out.println("��ݾ� :" + val + "��� �� �ܾ�:" + money);
		flag = false;
		notify();
	}// get()-------------------------

	public void save(int val) {
		synchronized (this) {
			if (flag) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		////// �ٸ� ����ȭ���
			money += val;
			System.out.println("�Աݾ� :" + val + "�Ա� �� �ܾ�:" + money);

			flag = true; // �ݺ��� �������� ��ġ

			notify();// waiting pool�� ��� ���� ������ �ϳ��� ���� runnable�� ���·� ��ȯ��Ŵ
						// notifyAll() ==> ��� ���� ������ ��θ� ����
		}//synch----------------------------------------

	}// save()------------------------

}///////////////
