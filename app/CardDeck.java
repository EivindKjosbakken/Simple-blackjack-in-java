package app;

import java.util.ArrayList;
import java.util.Collections;


public class CardDeck {
	
	private ArrayList<Card> spillDekk;
	
	public CardDeck() {
	this.spillDekk = new ArrayList<>();
		
	
	
		
		for (int i = 1; i<14; i++) {
			this.spillDekk.add(new Card('S',i));
	  }
		for (int i = 1; i<14; i++) {
			this.spillDekk.add(new Card('H',i));
	
		}
		for (int i = 1; i<14; i++) {
			this.spillDekk.add(new Card('D',i));
	
		}
		for (int i = 1; i<14; i++) {
			this.spillDekk.add(new Card('C',i));
			
		Collections.shuffle(spillDekk);
		}    
		
		
	}
	
	public void fjerneKort() {
		spillDekk.remove(0);
	}
	
	public int getCardCount() {
		return spillDekk.size();
	}
	
	public Card getCard(int n) {
		if (n<0 || n> (getCardCount()-1)) {
			throw new IllegalArgumentException("Ugyldig.");
		}
		else {
			return spillDekk.get(n);
		}
	}
	
	
	
	
	
	@Override
	public String toString() {
		return ""+spillDekk;
	}

	public static void main(String[] args) {
		CardDeck kort = new CardDeck();
		System.out.println(kort);
		System.out.println(kort.getCard(0));
	}
	

}
