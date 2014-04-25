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
		BufferedImage subImg = null;
		
		for(int i = 0, x = 0; i < player.getHandSize(); ++i, x += 10){
			subImg = cardImg.getSubimage(player.getCard(i).getX(), player.getCard(i).getY(), player.getCard(i).getWidth(), player.getCard(i).getHeight());
			g.drawImage(subImg, x, 0, null);
		}
		//for (int i = 0; i < player.getHandSize(); i++) {
		
			//g.drawImage()
			//player.getCard(i);
		//}
		
		} catch (IOException e) {} 
		
		
	}
}
