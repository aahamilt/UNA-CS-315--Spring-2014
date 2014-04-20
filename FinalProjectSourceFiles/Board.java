import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
	
	PlayerPanel p1;
	PlayerPanel p2;
	PlayerPanel p3;
	PlayerPanel p4;
	
	Board(String n) {
		
		super(n);
		
		JPanel playersBoard = new JPanel();
		playersBoard.setLayout(new GridLayout(1,4));
		
		p1 = new PlayerPanel();
		p2 = new PlayerPanel();
		p3 = new PlayerPanel();
		p4 = new PlayerPanel();
		
		playersBoard.add(p1);
		playersBoard.add(p2);
		playersBoard.add(p3);
		playersBoard.add(p4);
		
		setLayout(new BorderLayout());
		add(playersBoard, BorderLayout.SOUTH);
		
		setBounds(60, 60, 800, 600);
		setVisible(true);
		getContentPane().setBackground(new Color(0,153,0));
	    
	    
	    
	}
	
	public static void main(String[] args) {
		
		Board b = new Board("Test");
		b.setVisible(true);
	}
}

