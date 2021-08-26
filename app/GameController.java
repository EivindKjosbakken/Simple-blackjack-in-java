package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GameController implements SaveData{

	Game game = new Game();
	
	
//		@FXML Button bet;
	@FXML Button deal;
	@FXML Button hit;
	@FXML Button stand;
		@FXML TextField betSize;                    // husk Â fjerne her hvis du skal fÂ appen til Â funke
	@FXML Label playerKort;
	@FXML Label dealerKort;
	@FXML Label playerCount;
	@FXML Label dealerCount;
	@FXML Label whoWins;
		@FXML Label pengerPÂKonto;
		
	@FXML Button saveToFile;
	@FXML Button loadFromFile; 
	@FXML Label lagreInfo;
		
		
		//legge til feilmeldinger i kontrolleren
	

	
	
	@FXML void handleDeal() {
		// legge inn sÂnn at hvis betten er tom sÂ setter den en automatisk bet

//		if (Integer.parseInt(betSize.getText()) > Integer.parseInt(game.antPenger())) {
//			throw new IllegalArgumentException("Kan ikke bette mer penger enn du har");
//		}
//		
//		game.setBet(Integer.parseInt(betSize.getText()));     
//		game.konto.loose(Integer.parseInt(betSize.getText()));
//		pengerPÂKonto.setText(game.antPenger());  
//		
//		game.deal();
//		pengerPÂKonto.setText(game.antPenger());   
//		
//		dealerKort.setText(game.getOneDealerCard().toString());
//		playerKort.setText(game.getPlayerKort().toString());
//																//printer counten til dealer og player, beholder integer koden i tilfelle
//		playerCount.setText(game.getPlayerCount().toString());
//		dealerCount.setText(game.getOneDealerCount().toString());
		if (!(Integer.parseInt(betSize.getText()) > Integer.parseInt(game.antPenger()))) {
			game.setBet(Integer.parseInt(betSize.getText()));     
			game.konto.loose(Integer.parseInt(betSize.getText()));
			pengerPÂKonto.setText(game.antPenger());  
			
			game.deal();
			pengerPÂKonto.setText(game.antPenger());   
			
			dealerKort.setText(game.getOneDealerCard().toString());
			playerKort.setText(game.getPlayerKort().toString());
																	//printer counten til dealer og player, beholder integer koden i tilfelle
			playerCount.setText(game.getPlayerCount().toString());
			dealerCount.setText(game.getOneDealerCount().toString());
		}
		else {
			whoWins.setText("Kan ikke bette mer penger enn du har");
		}
		
		

	}
	
	
	@FXML void handleHit() {
		game.hit();
		playerKort.setText(game.getPlayerKort());
		playerCount.setText(game.getPlayerCount().toString()); 
		if (game.isGameOver()) {
			game.whoWins();
			whoWins.setText(game.winner);
		}
		
	}
	
	
	@FXML void handleStand() {
		game.stand();
		dealerKort.setText(game.getDealerKort());
		dealerCount.setText(game.getDealerCount());
		whoWins.setText(game.winner);
		
		if (game.getWinner().equals("Player")) {   
			game.konto.win(Integer.parseInt(betSize.getText())*2);    //er dette den beste mÂten Â bruke penger klassen pÂ?
		}
		if (game.getWinner().equals("Draw")) {
			game.konto.win(Integer.parseInt(betSize.getText()));
		}
		pengerPÂKonto.setText(game.antPenger());               

	}
	

	
	public void saveToFile(Game game) throws FileNotFoundException {
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter("blackjack.txt");
			outFile.println(game.antPenger());
			outFile.println(game.antPenger());

		}
//		catch (FileNotFoundException e) {
//			System.err.println("Error: file 'blackjack.txt' could not be opened for writing.");
//			System.exit(1);
//		}
		finally {
			if (outFile!= null) {
				outFile.close();
			}
		}
	}
	
	public void loadFromFile() {
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("blackjack.txt"));
			game.setPengerPÂKonto(Integer.parseInt(in.nextLine()));
			pengerPÂKonto.setText(in.nextLine());
			
//			game.setPengerPÂKonto(Integer.parseInt(scanner.nextInt()));
		}
		 catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'blackjack.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
		finally {
			
			if (in != null) {
				in.close();
			}
			
		}
		
	}
	
	


	
	
	@FXML private void saveCurrentFiles() throws FileNotFoundException {
		saveToFile(this.game);
		lagreInfo.setText("Saved current moneycount");
		
	}
	
	
	@FXML private void loadCurrentFiles() {
		loadFromFile();
		lagreInfo.setText("Loaded current moneycount");
		
		
	}


	
	


//	@Override
//	public String loadFromFile() {
//		return null;
//	}
	
//	@FXML void handleBet() {
//
//		
//	}

	
	

}

	
	
	
	
	

	

