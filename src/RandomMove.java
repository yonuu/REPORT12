import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.Random; 

 public class RandomMove extends JFrame {	
 	public RandomMove() {  
 		setTitle("원을 0.5초 간격으로 이동"); 
 		setDefaultCloseOperation(EXIT_ON_CLOSE);

 		final MyPanel panel = new MyPanel();   
 		setContentPane(panel);  
 	    
 		setSize(400, 400);  // 프레임 크기 설정
 		setVisible(true);  
 	}
 	class MyPanel extends JPanel {  
	public MyPanel() {  
		new Thread (new Runnable() { 
 			public void run() {
 				try {
 						while( true ) { 
 							repaint();  
 							Thread.sleep(400); // 원이 400ms초 간격으로 이동
 						} 
 					} catch(Exception e) { return; } 
 				}
 			}).start();
		}
		public void paintComponent(Graphics g) {	// 원이 랜덤하게 움직이도록 설정
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
 
 
 