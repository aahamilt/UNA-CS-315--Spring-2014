
public class Card {

	String suit;
	String face;
	int value;
	
	Card(String s, String f, int v) {
		
		suit = s;
		face = f;
		value = v;
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
