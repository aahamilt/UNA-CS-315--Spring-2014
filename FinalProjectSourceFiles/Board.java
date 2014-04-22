import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
	
	PlayerPanel p1;
	PlayerPanel p2;
	PlayerPanel p3;
	PlayerPanel p4;
	
	JButton hit = new JButton("Hit");
	JButton stay = new JButton("Stay");
	JButton bet = new JButton("Bet");
	
	JPanel centerPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	
	JTextField playerTurn = new JTextField("Player's Turn");
	JPanel dealerPanel = new JPanel();
	JPanel turnPanel = new JPanel();
	JPanel cardsPanel = new JPanel();
	
	Board(String n) {
		
		super(n);
		
		/* Holds the four players info. */
		JPanel playersBoard = new JPanel();
		playersBoard.setLayout(new GridLayout(1,4));
		
		/* Create and add players to the board. */
		p1 = new PlayerPanel();
		p2 = new PlayerPanel();
		p3 = new PlayerPanel();
		p4 = new PlayerPanel();
		playersBoard.add(p1);
		playersBoard.add(p2);
		playersBoard.add(p3);
		playersBoard.add(p4);
		
		/* Hit, stay, bet button panel. */
		buttonsPanel.setLayout(new GridLayout(1,3));
		buttonsPanel.add(hit);
		buttonsPanel.add(stay);
		buttonsPanel.add(bet);
		
		
		dealerPanel.setBackground(new Color(0,153,0));
		dealerPanel.add(new JTextField("Dealer"));
		turnPanel.add(new JTextField("Player turn"));
		turnPanel.setBackground(new Color(0,153,0));
		
		centerPanel.setLayout(new GridLayout(3,1));
		centerPanel.setBackground(new Color(0,153,0));
		centerPanel.add(dealerPanel);
		centerPanel.add(turnPanel);
		centerPanel.add(new CardPanel());
		
		
		/* Layout for the whole board, consists of upper, center, and north panels. */
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.NORTH);
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

