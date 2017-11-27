import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class VibrationFrame extends JFrame{
	public VibrationFrame() {
		super("�����ϴ� ������ �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(400, 400);		
		setLocation(100, 100); 
		setVisible(true);
		
		VibratingThread vt = new VibratingThread(this);	 // Vibrating ������ ���
		vt.start();	
	}
	class VibratingThread extends Thread implements Runnable{
		Component c;
		public VibratingThread(Component c) {
			this.c = c;
		}
		public void run() {
			Random r = new Random();
			int x = c.getX();
			int y = c.getY();
			
			while(true) {
				try {
					Thread.sleep(10);   // ���� ���� ����
				} catch(InterruptedException e) {return;}
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x + r.nextInt(5)*sign;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpY = y + r.nextInt(5)*sign;
				
				c.setLocation(tmpX, tmpY);   // �������� ��ġ �̵���Ű��
			}
		}	
	}
	public static void main(String[] args) {
		new VibrationFrame();
	}
}

