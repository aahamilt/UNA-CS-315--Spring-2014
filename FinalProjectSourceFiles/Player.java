import java.util.*;


public class Player {

	ArrayList<Card> hand = new ArrayList<Card>();
	private int total;
	private int wallet;
	private int handSize;
	private int handIndex;
	private boolean bust;
	

	Player() {
		
		bust = false;
		total = 0;
		wallet = 300;
		handSize = 0;
		handIndex = 0;
	}
	
	public void addToHand(Card c) {
		
		hand.add(handIndex, c);
		handSize++;
		handIndex++;
		total += c.getValue();
		
		if (total > 21)
			bust = true;
	}
	
	public void makeBet(int amount) {
		
		wallet -= amount;
	}
	
	public void addToWallet(int amount) {
		
		wallet += amount;
	}
	
	public void reset() {
		
		handIndex = 0;
		handSize = 0;
		total = 0;
	}
	
	public boolean getBust() {
		
		return bust;
	}
	
	public int getTotal() {
		
		return total;
	}
	
	public int getWallet() {
		
		return wallet;
	}
	
	public int getHandSize() {
		
		return handSize;
	}
	
	public int getHandIndex() {
		
		return handIndex;
	}
}
