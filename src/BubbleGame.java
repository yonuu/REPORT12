import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;  
 
public class BubbleGame extends JFrame{ 
 	public BubbleGame() { 
 		setTitle("���� ����"); 
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
 				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());   //���� ������ ����� 
 				bubbleThread.start(); 
 			} 
 		}); 
	}	 
 	class BubbleThread extends Thread { 
 		JLabel bubble; 
 		public BubbleThread(int bubbleX, int bubbleY) { 
 			ImageIcon img = new ImageIcon("balloon.jpg"); // �׸� �ҷ�����
 			bubble = new JLabel(img); 
 			bubble.setSize(img.getIconWidth(),img.getIconWidth()); 
 			bubble.setLocation(bubbleX, bubbleY); 
			add(bubble); // GamePanel�� add() 
 			repaint(); 
		} 
 		 
 		public void run() { 
 			while(true) { 
 				int x = bubble.getX(); 
 				int y = bubble.getY() - 5; // ������ y������ -5�� �̵�
 				 
 			
 				if(y < 0) { 
 					remove(bubble); // ���� ������
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
 
 
 