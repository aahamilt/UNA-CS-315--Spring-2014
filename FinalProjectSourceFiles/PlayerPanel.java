import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{
	
	JTextField betField = new JTextField("Bet");
	JTextField playerField = new JTextField("Player");
	JTextField walletField = new JTextField("Wallet");
	JTextField totalField = new JTextField("Total");
	JTextField cardField = new JTextField("Cards");
	
	/*JTextField [] betFields = new JTextField[4];
	JTextField [] playerFields = new JTextField[4];
	JTextField [] walletFields = new JTextField[4];
	JTextField [] cardFields = new JTextField[4];
	JTextField [] totalFields = new JTextField[4];*/
	
	
	
	PlayerPanel() {
		
		setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
		//setBackground(Color.RED);
		
		add(betField);
		add(playerField);
		add(walletField);
		add(totalField);
		add(cardField);
		
		
		
		/*setLayout(new GridLayout(5,4));
		
		JPanel betsPanel = new JPanel();
		betsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 125, 0));
		
		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 120, 0));
		
		JPanel walletPanel = new JPanel();
		walletPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 125, 0));
		
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 125, 0));
		
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 125, 0));
		
		for (int i = 0; i < 4; i++)
			betFields[i] = new JTextField("Bet");
		
		for (int i = 0; i < 4; i++)
			playerFields[i] = new JTextField("Player");
		
		for (int i = 0; i < 4; i++)
			walletFields[i] = new JTextField("Wallet");
		
		for (int i = 0; i < 4; i++)
			cardFields[i] = new JTextField("Card");
		
		for (int i = 0; i < 4; i++)
			totalFields[i] = new JTextField("Total");
		
		for (int i = 0; i < 4; i++)
			betsPanel.add(betFields[i]);
		
		for (int i = 0; i < 4; i++)
			playersPanel.add(playerFields[i]);
		
		for (int i = 0; i < 4; i++)
			walletPanel.add(walletFields[i]);
		
		for (int i = 0; i < 4; i++)
			cardPanel.add(cardFields[i]);
		
		for (int i = 0; i < 4; i++)
			totalPanel.add(totalFields[i]);
		
		add(betsPanel);
		add(playersPanel);
		add(walletPanel);
		add(cardPanel);
		add(totalPanel);*/
		
		/*add(betField);
		add(playerField);
		add(walletField);
		add(totalField);
		add(cardField);*/
		
	}
	
}
