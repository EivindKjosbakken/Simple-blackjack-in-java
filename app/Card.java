package app;

public class Card {

		
		private char kortFarge;
		private int tallVerdi;
		

		
	public Card(char kortFarge, int tallVerdi) {
	if ( !(kortFarge== 'S' || kortFarge== 'H' || kortFarge== 'D' || kortFarge== 'C')) {
				throw new IllegalArgumentException("Ugyldig kortfarge.");
				
			}
			if (tallVerdi < 1 || tallVerdi > 13){
				throw new IllegalArgumentException("Ugyldig kortfarge.");

			
			}	
				this.kortFarge = kortFarge;
				this.tallVerdi = tallVerdi;	
				
		}
		
		
		public char getSuit() {
			return kortFarge;
		}
		
		public int getFace() {
			return tallVerdi;
		}
		
		public String toString() {
			return ""+kortFarge+tallVerdi;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static void main(String[] args) {

		}

	}

