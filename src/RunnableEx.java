import java.util.Scanner;

public class RunnableEx {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine();   // 아무 키나 입력됨
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start();
	}
}

class CountingThread implements Runnable {   // Runnable 인터페이스 이용
	
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++)
			System.out.print(i + " ");   // for문을 통해 1에서 10까지 출력
		
		System.out.println();
		System.out.println("스레드 종료");
	}
}

