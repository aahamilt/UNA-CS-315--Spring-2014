import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JFrame implements ActionListener{
	
	
	PlayerPanel [] playerPanels;
	Player [] players;
	CardPanel [] cardPanels;
	BlackJack game;
	Player dealer;
	ArrayList<Player> winners = new ArrayList<Player>();
	
	JButton hit = new JButton("Hit");
	JButton stay = new JButton("Stay");
	JButton bet = new JButton("Bet");
	JButton next = new JButton("Next Hand");
	
	JPanel centerPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	
	JTextField playerTurn = new JTextField("Player's Turn");
	JTextField dealerField = new JTextField("Dealer");
	JTextField pot = new JTextField("Pot: 0");
	JTextField dealerTotal = new JTextField("Total");
	
	JPanel potPanel = new JPanel();
	JPanel turnPanel = new JPanel();
	JPanel cardsPanel = new JPanel();
	JPanel dealerPanel = new JPanel();
	
	CardPanel dealerCards = new CardPanel(dealer);
	
	Board(String n, BlackJack g) {
		
		super(n);
	
		game = g;
		dealer = g.getDealer();
		initializePlayers(game);
		initializePlayerPanels();
		initializeButtonsPanel();
		initializeCardPanels();
		
		cardsPanel.setLayout(new GridLayout(1,4));
		
		/* Holds the four players info. */
		JPanel playersBoard = new JPanel();
		playersBoard.setLayout(new GridLayout(1,4));
		
		/* Add playerPanels to the player board. */
		for (int i = 0; i < 4; i++) 
			playersBoard.add(playerPanels[i]);
		
		/* Add cardPanels to the cardsPanel.*/
		for (int i = 0; i < 4; i++)
			cardsPanel.add(cardPanels[i]);
		
		/* Dealer stuff. */
		dealerPanel.setLayout(new BoxLayout(dealerPanel ,BoxLayout.Y_AXIS));
		pot.setBackground(new Color(0,153,0));
		pot.setFont(new Font("AR Julian", Font.BOLD, 30));
		pot.setForeground(Color.YELLOW);
		pot.setBorder(null);
		pot.setBackground(new Color(0,153,0));
		pot.setHorizontalAlignment(JTextField.CENTER);
		
		dealerTotal.setBackground(new Color(0,153,0));
		dealerTotal.setFont(new Font("AR Julian", Font.BOLD, 30));
		dealerTotal.setForeground(Color.YELLOW);
		dealerTotal.setBorder(null);
		dealerTotal.setBackground(new Color(0,153,0));
		dealerTotal.setHorizontalAlignment(JTextField.CENTER);
		
		dealerField.setBackground(new Color(0,153,0));
		dealerField.setFont(new Font("AR Julian", Font.BOLD, 30));
		dealerField.setForeground(Color.YELLOW);
		dealerField.setBorder(null);
		dealerField.setBackground(new Color(0,153,0));
		dealerField.setHorizontalAlignment(JTextField.CENTER);
		
		dealerPanel.add(dealerField);
		dealerPanel.add(dealerTotal);
		dealerPanel.setBorder(null);
		potPanel.setLayout(new GridLayout(1,3));
		potPanel.add(pot);
		potPanel.add(dealerPanel);
		potPanel.add(dealerCards);
		potPanel.setBorder(null);
		potPanel.setBackground(new Color(0,153,0));
		
		/* Turn stuff. */
		playerTurn.setBackground(new Color(0,153,0));
		playerTurn.setFont(new Font("AR Julian", Font.BOLD, 30));
		playerTurn.setForeground(Color.YELLOW);
		playerTurn.setBorder(null);
		playerTurn.setHorizontalAlignment(JTextField.CENTER);
		turnPanel.add(playerTurn);
		turnPanel.setBackground(new Color(0,153,0));
		
		centerPanel.setLayout(new GridLayout(3,1));
		centerPanel.setBackground(new Color(0,153,0));
		centerPanel.add(potPanel);
		centerPanel.add(playerTurn);
		centerPanel.add(cardsPanel);
		
		/* Layout for the whole board, consists of upper, center, and north panels. */
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.NORTH);
		add(playersBoard, BorderLayout.SOUTH);
		
		setBounds(60, 60, 800, 600);
		setVisible(true);
		getContentPane().setBackground(new Color(0,153,0));
		
		startNewHand();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
	
	public void initializePlayerPanels() {
		
		playerPanels = new PlayerPanel[4];
		
		for (int i = 0; i < 4; i++)
			playerPanels[i] = new PlayerPanel(players[i]);
		
		for (int i = 0; i < 4; i++) {
			
			playerPanels[i].setWalletField(Integer.toString(game.getPlayer(i).getWallet()));
		}
	
	}
	
	public void initializePlayers(BlackJack game) {
		
		players = new Player[4];
		
		for (int i = 0; i < 4; i++)
			players[i] = game.getPlayer(i);
		
	}
	
	

	public void initializeCardPanels() {
		
		cardPanels = new CardPanel[4];
		
		for (int i = 0; i < 4; i++) 
			cardPanels[i] = new CardPanel(players[i]);
	}
	
	public void initializeButtonsPanel() {
		
		buttonsPanel.setLayout(new GridLayout(1,4));
		next.addActionListener(this);
		hit.addActionListener(this);
		stay.addActionListener(this);
		bet.addActionListener(this);
		buttonsPanel.add(hit);
		buttonsPanel.add(stay);
		buttonsPanel.add(bet);
		buttonsPanel.add(next);
		next.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if (source == hit) {
			
			game.hit(game.getPlayer());
			
			if (game.getPlayer(game.getTurn()).getBust()) {
				
				playerPanels[game.getTurn()].setTotalField("Bust");
				game.nextTurn();
				playerTurn.setText("Player " + Integer.toString((game.getTurn()) + 1) + "'s Turn");
				if (checkEnd())
					handleEnd();
			}
			
			else {
				
				playerPanels[game.getTurn()].
				setTotalField(Integer.toString(game.getPlayer(game.getTurn()).getTotal()));
			}
			
			
			
		}
		
		else if (source == stay) {
			
			game.getPlayer(game.getTurn()).stay();
			game.nextTurn();
			
			if (checkEnd())
				handleEnd();
			
			else
				playerTurn.setText("Player " + Integer.toString((game.getTurn()) + 1) + "'s Turn");
			
		}
		
		else if (source == bet) {
			
			game.getPlayer(game.getTurn()).makeBet(25);
			game.getBet(25);
			pot.setText("Pot: " + game.getPot());
			playerPanels[game.getTurn()].setWalletField("Wallet: "  + Integer.toString(game.getPlayer().getWallet()));
			playerPanels[game.getTurn()].setBetField("Bet: " + Integer.toString(game.getPlayer().getBet()));
			
			
		}
		
		else if (source == next) {
			
			startNewHand();
		}
	}
	
	public void startNewHand() {
		
		game.reset();
		game.shuffle();
		game.deal();
		
		for(int i = 0; i < game.getNumPlayers(); ++i){
			cardPanels[i].repaint();
		}
		
		next.setEnabled(false);
		
		pot.setText("Pot: 0");
		
		playerTurn.setText("Player " + (game.getTurn()+1) + "'s Turn.");
		
		
		for (int i = 0; i < 4; i++) {
			
			playerPanels[i].setTotalField(Integer.toString(game.getPlayer(i).getTotal()));
		}
		
		dealerTotal.setText(Integer.toString(game.getDealer().getTotal()));
		
	}
	
	public boolean checkEnd() {
		
		if(game.getTurn() == 4)
			return true;
		
		return false;
	}
	
	public void handleEnd() {
		
		boolean bust = false;
		
		
		while(dealer.getTotal() < 15) {
			
			game.hit(dealer);
			dealerTotal.setText(Integer.toString(game.getDealer().getTotal()));
		}
		
		if (dealer.getBust()) {
			
			dealerField.setText("Bust");
			bust = true;
		}
		
		else if (dealer.getTotal() < 17) {
			
			game.hit(dealer);
			dealerTotal.setText(Integer.toString(game.getDealer().getTotal()));
		}
		
		if (dealer.getBust()) {
			bust = true;
			dealerField.setText("Bust");
		}
		
		/* Dealer busted, all players who didn't bust win. */
		if (bust) {
			
			for (int i = 0; i < 4; i++) {
				
				if(game.getPlayer(i).getBust() == false)
					winners.add(game.getPlayer(i));
			}	
		}
		
		/* Dealer didn't bust, all players who didn't bust and are closer to 21 (total > dealer) win. */
		else {
			
			for (int i = 0; i < 4; i++) {
				
				if (game.getPlayer(i).getBust() == false && game.getPlayer(i).getTotal() > dealer.getTotal())
					winners.add(game.getPlayer(i));
			}
		}
			
		next.setEnabled(true);
		
	}
}