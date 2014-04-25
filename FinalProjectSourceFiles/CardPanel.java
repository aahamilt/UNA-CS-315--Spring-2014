import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CardPanel extends JPanel{
	
	Player player;
	
	CardPanel(Player p) {
		
		player = p;
		
		setBackground(new Color(0,153,0));
		setLayout(new GridLayout(1,4));
		repaint();
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		try {
			
		BufferedImage cardImg = ImageIO.read(new File("Cards.png"));
		
		BufferedImage subImg = cardImg.getSubimage(0, 0, 73, 102);
		
		//for (int i = 0; i < player.getHandSize(); i++) {
		
		g.drawImage(subImg, 0, 0, null);
		
			//g.drawImage()
			//player.getCard(i);
		//}
		
		} catch (IOException e) {} 
		
		
	}
}
