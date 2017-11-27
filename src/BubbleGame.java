import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;  
 
public class BubbleGame extends JFrame{ 
 	public BubbleGame() { 
 		setTitle("버블 게임"); 
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 		 
 		GamePanel p = new GamePanel(); 
 		setContentPane(p); 
 		setSize(800,800);	 
 		setVisible(true); 
	} 
 	 
 	public static void main(String [] args) { 
 		new BubbleGame(); 
 	} 
 } 
 class GamePanel extends JPanel { 
 	public GamePanel() { 
 		setLayout(null);  
 		addMouseListener(new MouseAdapter() { 
 			public void mousePressed(MouseEvent e) { 
 				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());   //버블 스레드 만들기 
 				bubbleThread.start(); 
 			} 
 		}); 
	}	 
 	class BubbleThread extends Thread { 
 		JLabel bubble; 
 		public BubbleThread(int bubbleX, int bubbleY) { 
 			ImageIcon img = new ImageIcon("balloon.jpg"); // 그림 불러오기
 			bubble = new JLabel(img); 
 			bubble.setSize(img.getIconWidth(),img.getIconWidth()); 
 			bubble.setLocation(bubbleX, bubbleY); 
			add(bubble); // GamePanel에 add() 
 			repaint(); 
		} 
 		 
 		public void run() { 
 			while(true) { 
 				int x = bubble.getX(); 
 				int y = bubble.getY() - 5; // 버블이 y축으로 -5씩 이동
 				 
 			
 				if(y < 0) { 
 					remove(bubble); // 버블 삭제됨
 					repaint(); 
					return;  
 				} 
 				bubble.setLocation(x, y); 
 				repaint(); 
 				try { 
 					sleep(200);
 				} 
 				catch(InterruptedException e) {} 
 			} 
 		} 
 	} 
 } 
 
 
 