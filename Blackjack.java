//**************************
// Author: Kyle Kurzhal
// Filename: Blackjack.java
//***************************
public class Blackjack extends CardGame{

	//Constructors:
/***************************************************************
 Input: None
 Output: None
 Purpose: Creates a default of 2 players and deals their hands.
****************************************************************/
	public Blackjack(){	//creates two players by default and deals their hands
		super();
		players = new Player[2];
		players[0] = new Player();
		players[1] = new Player();
		deal(players[0]);
		deal(players[1]);
	}

/***********************************************************************
 Input: playNum - The number of players specified for the game.
 Output: None
 Purpose: Creates the specified number of players and deals their hands.
***********************************************************************/
	public Blackjack(int playNum){	//creates the players and deals their hands
		super();
		if(playNum > 10)
			playNum = 10;
		else if(playNum < 2)
			playNum = 2;
		players = new Player[playNum];
		for(int i = 0; i < playNum; ++i){
			players[i] = new Player();
			deal(players[i]);
		}
	}

	//Methods:
/****************************************************************
 Input: None
 Output: Prints the game description to the screen.
 Purpose: Allows the user to know the rules and goal of the game.
*****************************************************************/
	public void displayDescription(){	//displays a description of the game
		System.out.println("Blackjack");
		System.out.println("---------");
		System.out.println("Goal: Have the closest overall value of cards to '21' when the game ends.");
		System.out.println("Rules: (2-10 players) Each player receives a one card face up, and one card face down.  You may choose increase your bet and then choose to draw a card or hold.  The game ends when each player is ready to reveal their cards.");
	}

/******************************************************************
 Input: None
 Output: Prints the current status of the game.
 Purpose: Allows the user to know how many cards are in the deck, 		  discard pile, and the cards in each hand.
******************************************************************/
	public void displayStatus(){	//displays the status of all game elements
		System.out.println("Deck Cards: "+(deckTop+1));
		System.out.println("Discard Cards: "+(discardTop+1));
		for(int i = 0; i < players.length; ++i){
			System.out.print("Player "+(i+1)+" Hand: ");	//print each player's hand
			players[i].showHand();
		}
	}

/*********************************************************************
 Input: The player to which the cards will be dealt.
 Output: None
 Purpose: Fills the hand of the specified player with the dealt cards.
*********************************************************************/
	public void deal(Player aPlayer){
		aPlayer.addToHand(DeckStack[deckTop--]);
		aPlayer.addToHand(DeckStack[deckTop--]);
	}

	//Data Members:
	private Player[] players;	//holds all players for the game
}
