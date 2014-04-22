import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CardPanel extends JPanel{
	
	CardPanel() {
		
		setLayout(new GridLayout(1,4));
		repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		try {
			
		BufferedImage cardImg = ImageIO.read(new File("Cards.png"));
		
		BufferedImage subImg = cardImg.getSubimage(0, 0, 73, 102);
		
		g.drawImage(subImg, 0, 0, null);
		
		} catch (IOException e) {} 
		
		
		
		
		
		
		//g.setColor(Color.RED);
		//g.drawRect(0, 0, 73, 102);
		//g.fillRect(0, 0, 73, 102);
		
		//g.setColor(Color.BLUE);
		//g.drawRect(36,0,73,102);
		//g.fillRect(36,0,73,102);
	}
}
