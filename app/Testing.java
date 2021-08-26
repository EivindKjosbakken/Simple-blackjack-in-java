package app;
import java.util.ArrayList;

import encapsulation.Card;


public class Testing {

	
	private ArrayList<Card> liste;
	
	public Testing() {
		
		
	}
	public static void main(String[] args) {

		ArrayList<Card> liste = new ArrayList<Card>();
		
		liste.add(new Card('S', 1));
		System.out.println(liste);
		
		
	}

}
