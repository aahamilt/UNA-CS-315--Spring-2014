import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{
	
	private JTextField betField = new JTextField("Bet");
	private JTextField playerField = new JTextField("Player");
	private JTextField walletField = new JTextField("Wallet");
	private JTextField totalField = new JTextField("Total");
	
	
	
	PlayerPanel(Player p) {
		
		betField.setBorder(null);
		playerField.setBorder(null);
		walletField.setBorder(null);
		totalField.setBorder(null);
		
		betField.setHorizontalAlignment(JTextField.CENTER);
		playerField.setHorizontalAlignment(JTextField.CENTER);
		walletField.setHorizontalAlignment(JTextField.CENTER);
		totalField.setHorizontalAlignment(JTextField.CENTER);
		
		betField.setFont(new Font("AR Julian", Font.BOLD, 20));
		betField.setForeground(Color.YELLOW);
		playerField.setFont(new Font("AR Julian", Font.BOLD, 20));
		playerField.setForeground(Color.YELLOW);
		walletField.setFont(new Font("AR Julian", Font.BOLD, 20));
		walletField.setForeground(Color.YELLOW);
		totalField.setFont(new Font("AR Julian", Font.BOLD, 20));
		totalField.setForeground(Color.YELLOW);
		
		setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
		setBackground(new Color(0,153,0));
		betField.setBackground(new Color(0,153,0));
		playerField.setBackground(new Color(0,153,0));
		walletField.setBackground(new Color(0,153,0));
		totalField.setBackground(new Color(0,153,0));

		add(betField);
		add(playerField);
		add(walletField);
		add(totalField);
		
		
	}
	


	public void setBetField(String bet) {
		
		betField.setText(bet);
	}
	
	public void setWalletField(String wallet) {
		
		walletField.setText(wallet);
	}
	
	public void setTotalField(String total) {
		
		totalField.setText(total);
	}
}