package app;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;

public class LagreKlasse {
	
	
	public void save(Game game) {
		try {
			PrintWriter outFile = new PrintWriter("blackjack.txt");
			outFile.println(game.antPenger());
			outFile.println(game.getDealerKort());
			outFile.println(game.getPlayerKort());

			
			outFile.close();
			

		}
		catch (FileNotFoundException e) {
			System.err.println("Error: file 'test.txt' could not be opened for writing.");
			System.exit(1);
		}
	}
	
	
	public void load(Game game) {
		Scanner in;
		try {
			in = new Scanner(new FileReader("blackjack.txt"));
			game.setPengerPÂKonto(Integer.parseInt(in.nextLine()));
		
		}
		 catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
		
		
	}
		
	

}
