
public class Card {

	String suit;
	String face;
	int value;
	private int x;
	private int y;
	private final int width = 75;
	private final int height = 104;
	
	Card(String s, String f, int v, int xVal, int yVal) {
		
		suit = s;
		face = f;
		value = v;
		x = xVal;
		y = yVal;
	}
	
	//Kyle
	public int getX(){
		return x;
	} 
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public String getSuit(){
		
		return suit;
	}
	
	public String getFace() {
		
		return face;
	}
	
	public int getValue(){
		
		return value;
	}
}
