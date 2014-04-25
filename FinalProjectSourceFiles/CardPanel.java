import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel{

	CardPanel() {
		
		setLayout(new GridLayout(1,4));
		repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawRect(0, 0, 73, 102);
	}
}