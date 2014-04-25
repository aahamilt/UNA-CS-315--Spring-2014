import javax.swing.JFrame;


public class Driver {

	public static void main(String[] args) {
		
		Player [] players = new Player[4];
		
		for (int i = 0; i < 4; i++)
			players[i] = new Player(i);
		
		Player dealer = new Player(4);
		
		BlackJack game = new BlackJack(players, dealer);
		
		Board board = new Board("Test", game);
		
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
