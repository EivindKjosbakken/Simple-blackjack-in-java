package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;



public class Game {
	
	private ArrayList<Card> player;
	private ArrayList<Card> dealer;
	private int playerCount = 0;
	private int dealerCount = 0;           
	CardDeck spillKort = new CardDeck();
	Penger konto = new Penger(100);
	public int betSize = 0;

	public String winner;
	
	public Game() {
		this.player = new ArrayList<>();
		this.dealer = new ArrayList<>();
		
		
	}
	
	public void setPengerPåKonto(int penger) {    // ny
		konto.loose(konto.getPenger());
		konto.win(penger);
	}
	
	public String antPenger() {
		return ""+konto.getPengerString();
	}
	

	
	public void setBet(int betSize) {
		this.betSize = betSize;
		
	} 
	
	public int getBet() {
		return betSize;
	}
	
	
	
	
	
private void endrePlayer() {    //endret
		
		if (spillKort.getCard(0).getFace() == 11 || spillKort.getCard(0).getFace() == 12 || spillKort.getCard(0).getFace() == 13) {
			playerCount+= 10;
		}
		else if (spillKort.getCard(0).getFace() == 1) {       
			playerCount+=11;
		}
		else {
			playerCount += spillKort.getCard(0).getFace();
		}
	}
	
	private void endreDealer() {  //endret
		
		if (spillKort.getCard(0).getFace() == 11 || spillKort.getCard(0).getFace() == 12 || spillKort.getCard(0).getFace() == 13) {
			dealerCount+= 10;
		}
		else if (spillKort.getCard(0).getFace() == 1) {       
			dealerCount+=11;
		}
	
		else {
			dealerCount += spillKort.getCard(0).getFace();
		}
	}
	
	

	
	public void deal() {      
		playerCount = 0;
		dealerCount = 0;
		player.clear();
		dealer.clear();
		
		player.add(spillKort.getCard(0));
		endrePlayer();
		spillKort.fjerneKort();
		
		dealer.add(spillKort.getCard(0));
		endreDealer();
		spillKort.fjerneKort();
		
		player.add(spillKort.getCard(0));
		endrePlayer();
		spillKort.fjerneKort();
		
		dealer.add(spillKort.getCard(0));
		endreDealer();
		spillKort.fjerneKort();
	}
	
	public void hit() {
		if (playerCount >20) {
			throw new IllegalArgumentException("Kan ikke få flere kort når du har 21 eller mere i verdi");
		}
		player.add(spillKort.getCard(0));
		endrePlayer();
		spillKort.fjerneKort();
	}

	public void stand() {
		//vis det andre dealer kortet
		if (dealerCount < 17) {
			 while (dealerCount < 17) {
					dealer.add(spillKort.getCard(0));
					endreDealer();
					spillKort.fjerneKort();
			}
		}
		whoWins();
		
		}
	
	
	public boolean isGameOver() {
		if (playerCount >21 || dealerCount > 21) {
			return true;
		}
		return false;
		
	}
	
	
	public void whoWins() {    
		if (playerCount>21) {
			System.out.println("Dealer wins!");
			winner = "Dealer";
			
			//fjerne/legge til penger hos player (dealer har evig med penger)
		}
		if (playerCount<21 && dealerCount >21) {
			System.out.println("Player wins");
			winner = "Player";
			
			

			
		}
		if (dealerCount>playerCount && (dealerCount < 22 && playerCount < 22)) {
			System.out.println("Dealer wins!");
			winner = "Dealer";
			
			

		}
		if (dealerCount<playerCount &&  (dealerCount < 22 && playerCount < 22)) {
			System.out.println("Player wins!");
			winner = "Player";
			
		}
		if (dealerCount==playerCount) {
			System.out.println("It's a push. You get your money back player");
			winner = "Draw";
			
		}
		

		
	}
	
	public String getDealerKort() {
		String dealerKort = "";
		for (Card kort: dealer) {
			dealerKort+= kort+" ";
		}
		return dealerKort;
	}
	

	public String getPlayerKort() {
		String playerKort = "";
		for (Card kort: player) {
			playerKort+= kort+" ";
		}
		return playerKort;
	}
	
	public String getWinner() {
		whoWins();
		if (winner.equals("Dealer") ) {
			return "Dealer";
		}
		if (winner.equals("Player")) {
			return "Player";
		}
		else {
			return "";
		}
	}
	
	public String getDealerCount() {
		return ""+dealerCount;
	}
	
	
	public String getOneDealerCard() {   
		return ""+dealer.get(0);
	}
	
	public String getOneDealerCount() {
		return ""+dealer.get(0).getFace();    
	}
	
	public String getPlayerCount() {
		return ""+playerCount;    //her returnerer jeg counten som strings -> husk å endre det til ints hvis du skal regne med det
	}
	
	
	public static void main(String[] args) {
//		System.out.println("hei");
//		Game spill = new Game();
//		Penger konto2 = new Penger(100);
//		System.out.println(konto2.getPenger());
//		konto2.win(50);
//		System.out.println(konto2.getPenger());
//		spill.deal();

		
		

		//System.out.println(spill.antPenger());
		
	}
	

}


//	@Override
//	public String toString() {
//		return "Game [antKortstokker=" + antKortstokker + ", spillDekk=" + spillDekk + "]";
//	}


