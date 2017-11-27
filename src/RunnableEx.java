import java.util.Scanner;

public class RunnableEx {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine();   // �ƹ� Ű�� �Էµ�
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start();
	}
}

class CountingThread implements Runnable {   // Runnable �������̽� �̿�
	
	@Override
	public void run() {
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++)
			System.out.print(i + " ");   // for���� ���� 1���� 10���� ���
		
		System.out.println();
		System.out.println("������ ����");
	}
}

