import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.Random; 

 public class RandomMove extends JFrame {	
 	public RandomMove() {  
 		setTitle("���� 0.5�� �������� �̵�"); 
 		setDefaultCloseOperation(EXIT_ON_CLOSE);

 		final MyPanel panel = new MyPanel();   
 		setContentPane(panel);  
 	    
 		setSize(400, 400);  // ������ ũ�� ����
 		setVisible(true);  
 	}
 	class MyPanel extends JPanel {  
	public MyPanel() {  
		new Thread (new Runnable() { 
 			public void run() {
 				try {
 						while( true ) { 
 							repaint();  
 							Thread.sleep(400); // ���� 400ms�� �������� �̵�
 						} 
 					} catch(Exception e) { return; } 
 				}
 			}).start();
		}
		public void paintComponent(Graphics g) {	// ���� �����ϰ� �����̵��� ����
			Random r = new Random();
			int x = r.nextInt(getWidth()-50);
			int y = r.nextInt(getHeight()-50);
			g.clearRect(0, 0, getWidth(), getHeight()); 
			g.drawOval(x, y, 50, 50); 
		}  
 	}  
 	public static void main(String[] args) {  
 		new RandomMove();  
    }  
 }  
 
 
 