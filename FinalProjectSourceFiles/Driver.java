
public class Driver {

	public static void main(String[] args) {
		
		Player [] players = new Player[4];
		
		for (int i = 0; i < 4; i++)
			players[i] = new Player();
		
		Player dealer = new Player();
		
		BlackJack game = new BlackJack(players, dealer);
		
		Board board = new Board("Test", game);
		
	}
}
