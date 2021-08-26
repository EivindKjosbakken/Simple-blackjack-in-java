package app;

import java.io.FileNotFoundException;

public interface SaveData {
	
	public void saveToFile(Game game) throws FileNotFoundException;
	public void loadFromFile();

}
