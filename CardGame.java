//*************************
// Author: Kyle Kurzhal
// Filename: CardGame.java
//*************************
import java.util.Random;
import java.util.ArrayList;
public abstract class CardGame{

	//Constructors:
	/********************************************************
	* Input: None
	* Output: None
	* Purpose: Creates an instance of a card game, with a deck and discard, and then shuffles the deck.
	********************************************************/
	public CardGame(){
		DeckStack = new Card[52];
		DiscardStack = new Card[52];
		deckTop = 51;
		discardTop = -1;

		//create the deck
		for(int i = 1, k = 0; i < 14; ++i){
			for(int j = 0; j < 4; ++j, ++k){
				DeckStack[k] = new Card(j,i);
			}
		}
		shuffle();
	}

	//Methods:
	/***********************************************************************
	* Purpose: Abstract methods that are to be defined in the child classes.
	************************************************************************/
	public abstract void displayStatus();
	public abstract void displayDescription();
	public abstract void deal(Player aPlayer);

	/*******************************************
	* Input: None
	* Output: None
	* Purpose: Shuffles the deck very randomly.
	*******************************************/
	public void shuffle(){
		//create two random variables to increase shuffle variability
		Random randomSeed = new Random();;
		Random randomNum = new Random(randomSeed.nextLong());
		//create an array to hold the shuffled cards
		for(int i = randomNum.nextInt(501); i > 0; --i){
			Card theNewDeck[] = new Card[deckTop+1];
			int endShuffle = randomNum.nextInt(52);
		//	System.out.println(endShuffle);
			for(int j = 0, k = deckTop, z = 0; z < deckTop+1; ++j, --k){
				if(k >= endShuffle){
					theNewDeck[z++] = DeckStack[k];
				}
				if(j < endShuffle)
					theNewDeck[z++] = DeckStack[j];
			}
			//make the deck reference refer to the shuffled deck
			DeckStack = theNewDeck;
		}
	}

	//Data Members:
	protected Card[] DeckStack;
	protected Card[] DiscardStack;
	protected int deckTop;
	protected int discardTop;

	protected class Player{

		//Constructor:
		/******************************************************
		* Input: None
		* Output: None
		* Purpose: Creates an instance of a player with a hand.
		*******************************************************/
		public Player(){
			hand = new ArrayList<Card>();
		}

		//Methods:
		/**************************************************************
		* Input: card - A card that will be added to the player's hand.
		* Output: None
		* Purpose: Adds a card to the player's hand.
		**************************************************************/
		public void addToHand(Card card){
			hand.add(card);
		}

		/****************************************************************
		* Input: None
		* Output: Returns the number of cards in the player's hand.
		* Purpose: Allows the user to know the number of cards in his hand.
		****************************************************************/
		public int getHandSize(){
			return hand.size();
		}

		/*************************************************************
		* Input: None
		* Output: Prints all cards in a player's hand.
		* Purpose: Allows the user to see what cards are in his hand.
		*************************************************************/
		public void showHand(){
			for(int i = 0; i < getHandSize(); ++i){
				System.out.print(Integer.toString((hand.get(i)).getValue())+(hand.get(i)).getSuit()+",");
			}
		}

		//Data Members:
		protected ArrayList<Card> hand;
	}

	protected class Card{

		//Constructors:
		/******************************************************
		* Input: kind - the number that specifies the card suit.
		*        val - the number that specifies the card value.
		* Output: None
		* Purpose: Creates an instance of a card.
		******************************************************/
		public Card(int kind, int val){
			if(kind == 0)
				suit = 'c';
			else if(kind == 1)
				suit = 'h';
			else if(kind == 2)
				suit = 's';
			else
				suit = 'd';

			value = val;
		}

		//Methods:
		/**********************************
		* Input: None
		* Output: Returns the card value.
		* Purpose: Allows the user to get the card value.
		**********************************/
		public int getValue(){
			return value;
		}

		/**********************************
		* Input: None
		* Output: Returns the card suit as a char.
		* Purpose: Allows the user to get the card suit.
		**********************************/
		public char getSuit(){
			return suit;
		}

		//Data Members:
		private char suit;
		private int value;
	}
}

