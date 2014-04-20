
public class BlackJack {

	
	private Card [] deck = new Card[52];
	private Player [] players;
	private int deckIndex;
	
	private final int INIT_DEAL = 4;
	private final int NUM_PLAYERS = 4;
	private final int NUM_SHUFFLE = 200;
	
	BlackJack(Player [] p) {
		
		initializeDeck();
		
		/*players = new Player[NUM_PLAYERS];
		
		for(int i = 0; i < NUM_PLAYERS; i++)
			players[i] = new Player();*/
		
		players = p;
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
			
			players[i].addToHand(deck[deckIndex]);
			deckIndex++;
		}
		
		/* Deal second card to each player. */
		for (int i = 0; i < INIT_DEAL; i++) {
			
			players[i].addToHand(deck[deckIndex]);
			deckIndex++;
		}
	}
	
	public void hit(Player p) {
		
		p.addToHand(deck[deckIndex]);
		deckIndex++;
	}
	
	public Player getPlayer(int index) {
		
		return players[index];
	}
	
	public void reset() {
		
		deckIndex = 0;
		shuffle();
		
		for (int i = 0; i < NUM_PLAYERS; i++) 
			players[i].reset();
	}

	public void initializeDeck() {
	 
	 	deck[ 0] = new Card("Spades", "Ace", 1);
		deck[ 1] = new Card("Spades", "Two", 2);
		deck[ 2] = new Card("Spades", "Three", 3);
		deck[ 3] = new Card("Spades", "Four", 4);
		deck[ 4] = new Card("Spades", "Five", 5);
		deck[ 5] = new Card("Spades", "Six", 6);
		deck[ 6] = new Card("Spades", "Seven", 7);
		deck[ 7] = new Card("Spades", "Eight", 8);
		deck[ 8] = new Card("Spades", "Nine", 9);
		deck[ 9] = new Card("Spades", "Ten", 10);
		deck[10] = new Card("Spades", "Jack", 10);
		deck[11] = new Card("Spades", "Queen", 10);
		deck[12] = new Card("Spades", "King", 10);
		deck[13] = new Card("Clubs", "Ace", 1);
		deck[14] = new Card("Clubs", "Two", 2);
		deck[15] = new Card("Clubs", "Three", 3);
		deck[16] = new Card("Clubs", "Four", 4);
		deck[17] = new Card("Clubs", "Five", 5);
		deck[18] = new Card("Clubs", "Six", 6);
		deck[19] = new Card("Clubs", "Seven", 7);
		deck[20] = new Card("Clubs", "Eight", 8);
		deck[21] = new Card("Clubs", "Nine", 9);
		deck[22] = new Card("Clubs", "Ten", 10);
		deck[23] = new Card("Clubs", "Jack", 10);
		deck[24] = new Card("Clubs", "Queen", 10);
		deck[25] = new Card("Clubs", "King", 10);
		deck[26] = new Card("Hearts", "Ace", 1);
		deck[27] = new Card("Hearts", "Two", 2);
		deck[28] = new Card("Hearts", "Three", 3);
		deck[29] = new Card("Hearts", "Four", 4);
		deck[30] = new Card("Hearts", "Five", 5);
		deck[31] = new Card("Hearts", "Six", 6);
		deck[32] = new Card("Hearts", "Seven", 7);
		deck[33] = new Card("Hearts", "Eight", 8);
		deck[34] = new Card("Hearts", "Nine", 9);
		deck[35] = new Card("Hearts", "Ten", 10);
		deck[36] = new Card("Hearts", "Jack", 10);
		deck[37] = new Card("Hearts", "Queen", 10);
		deck[38] = new Card("Hearts", "King", 10);
		deck[39] = new Card("Diamonds", "Ace", 1);
		deck[40] = new Card("Diamonds", "Two", 2);
		deck[41] = new Card("Diamonds", "Three", 3);
		deck[42] = new Card("Diamonds", "Four", 4);
		deck[43] = new Card("Diamonds", "Five", 5);
		deck[44] = new Card("Diamonds", "Six", 6);
		deck[45] = new Card("Diamonds", "Seven", 7);
		deck[46] = new Card("Diamonds", "Eight", 8);
		deck[47] = new Card("Diamonds", "Nine", 9);
		deck[48] = new Card("Diamonds", "Ten", 10);
		deck[49] = new Card("Diamonds", "Jack", 10);
		deck[50] = new Card("Diamonds", "Queen", 10);
		deck[51] = new Card("Diamonds", "King", 10);
 	}


}
