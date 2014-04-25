
public class BlackJack {

	
	private Card [] deck = new Card[52];
	private Player [] players;
	private Player dealer;
	private int deckIndex;
	
	private final int INIT_DEAL = 4;
	private final int NUM_PLAYERS = 4;
	private final int NUM_SHUFFLE = 200;
	
	private int turn;
	private int pot;
	
	BlackJack(Player [] p, Player d) {
		
		initializeDeck();
		
		dealer = d;
		players = p;
		
		turn = 0;
		pot = 0;
	}
	
	public void shuffle() {
		
		int swap1; 
		int swap2;
		Card temp;
		
		for (int i = 0; i < NUM_SHUFFLE; i++) {
			
			/* Generate cards to be swapped. */
			swap1 = (int)(51 * Math.random());
			swap2 = (int)(51 * Math.random());
			
			/* Swap contents. */
			temp = deck[swap1];
			deck[swap1] = deck[swap2];
			deck[swap2] = temp;	
		}
	}
	
	public void deal() {
		
		/* Deal first card to each player. */
		for (int i = 0; i < INIT_DEAL; i++) {
			
			if (getPlayer().getInGame() == false) {
				
				continue;
			}
			
			players[i].addToHand(deck[deckIndex]);
			deckIndex++;
		}
		
		/* Deal second card to each player. */
		for (int i = 0; i < INIT_DEAL; i++) {
			
			players[i].addToHand(deck[deckIndex]);
			deckIndex++;
		}
		
		/* Deal to dealer. */
		
		dealer.addToHand(deck[deckIndex]);
		deckIndex++;
		dealer.addToHand(deck[deckIndex]);
		deckIndex++;
		
	}
	
	public void hit(Player p) {
		
		p.addToHand(deck[deckIndex]);
		deckIndex++;
		
	}
	
	public Player getPlayer() {
		
		return players[turn];
	}
	
	public Player getPlayer(int index) {
		
		return players[index];
	}
	
	public void getBet(int amount) {
		
		pot += amount;
	}
	
	public void stay() {
		
		
		nextTurn();
	}
	
	public void reset() {
		
		deckIndex = 0;
		turn = 0;
		pot = 0;
		shuffle();
		
		for (int i = 0; i < NUM_PLAYERS; i++) 
			players[i].reset();
		
		dealer.reset();
	}
	
	public int getNumPlayers(){
		return NUM_PLAYERS;
	}
	
	public int getTurn() {
		
		return turn;
	}
	
	public void nextTurn() {
		
		turn++;
	}
	
	public int getPot() {
		
		return pot;
	}

	public Player getDealer() {
		
		return dealer;
	}
	
	public void initializeDeck() {
	 
		deck[0] = new Card("Spades", "Ace", 1, 0, 204);
		deck[1] = new Card("Spades", "Two", 2, 73, 204);
		deck[2] = new Card("Spades", "Three", 3, 146, 204);
		deck[3] = new Card("Spades", "Four", 4, 219, 204);
		deck[4] = new Card("Spades", "Five", 5, 292, 204);
		deck[5] = new Card("Spades", "Six", 6, 365, 204);
		deck[6] = new Card("Spades", "Seven", 7, 438, 204);
		deck[7] = new Card("Spades", "Eight", 8, 511, 204);
		deck[8] = new Card("Spades", "Nine", 9, 584, 204);
		deck[9] = new Card("Spades", "Ten", 10, 657, 204);
		deck[10] = new Card("Spades", "Jack", 10, 730, 204);
		deck[11] = new Card("Spades", "Queen", 10, 803, 204);
		deck[12] = new Card("Spades", "King", 10, 876, 204);
		
		deck[13] = new Card("Clubs", "Ace", 1, 0, 0);
		deck[14] = new Card("Clubs", "Two", 2, 73, 0);
		deck[15] = new Card("Clubs", "Three", 3, 146, 0);
		deck[16] = new Card("Clubs", "Four", 4, 219, 0);
		deck[17] = new Card("Clubs", "Five", 5, 292, 0);
		deck[18] = new Card("Clubs", "Six", 6, 365, 0);
		deck[19] = new Card("Clubs", "Seven", 7, 438, 0);
		deck[20] = new Card("Clubs", "Eight", 8, 511, 0);
		deck[21] = new Card("Clubs", "Nine", 9, 584, 0);
		deck[22] = new Card("Clubs", "Ten", 10, 657, 0);
		deck[23] = new Card("Clubs", "Jack", 10, 730, 0);
		deck[24] = new Card("Clubs", "Queen", 10, 803, 0);
		deck[25] = new Card("Clubs", "King", 10, 876, 0);

		deck[26] = new Card("Hearts", "Ace", 1, 0, 102);
		deck[27] = new Card("Hearts", "Two", 2, 73,102);
		deck[28] = new Card("Hearts", "Three", 3, 146, 102);
		deck[29] = new Card("Hearts", "Four", 4, 219, 102);
		deck[30] = new Card("Hearts", "Five", 5, 292, 102);
		deck[31] = new Card("Hearts", "Six", 6, 365, 102);
		deck[32] = new Card("Hearts", "Seven", 7, 438, 102);
		deck[33] = new Card("Hearts", "Eight", 8, 511, 102);
		deck[34] = new Card("Hearts", "Nine", 9, 584, 102);
		deck[35] = new Card("Hearts", "Ten", 10, 657, 102);
		deck[36] = new Card("Hearts", "Jack", 10, 730, 102);
		deck[37] = new Card("Hearts", "Queen", 10, 803, 102);
		deck[38] = new Card("Hearts", "King", 10, 876, 102);		

		deck[39] = new Card("Diamonds", "Ace", 1, 0, 306);
		deck[40] = new Card("Diamonds", "Two", 2, 73, 306);
		deck[41] = new Card("Diamonds", "Three", 3, 146, 306);
		deck[42] = new Card("Diamonds", "Four", 4, 219, 306);
		deck[43] = new Card("Diamonds", "Five", 5, 292, 306);
		deck[44] = new Card("Diamonds", "Six", 6, 365, 306);
		deck[45] = new Card("Diamonds", "Seven", 7, 438, 306);
		deck[46] = new Card("Diamonds", "Eight", 8, 511, 306);
		deck[47] = new Card("Diamonds", "Nine", 9, 584, 306);
		deck[48] = new Card("Diamonds", "Ten", 10, 657, 306);
		deck[49] = new Card("Diamonds", "Jack", 10, 730, 306);
		deck[50] = new Card("Diamonds", "Queen", 10, 803, 306);
		deck[51] = new Card("Diamonds", "King", 10, 876, 306);	
 	}


}
