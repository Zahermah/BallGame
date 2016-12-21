package Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Denna klass läser till highscoren från filen
 * 
 * @author Zaher
 * 
 */
public class ReadHighScore {
	private TreeMap<Integer, String> playerList;

	public TreeMap<Integer, String> reading() {

		playerList = new TreeMap<>(Collections.reverseOrder());
		String textToRead = null;

		try (BufferedReader bufferReader = new BufferedReader(new FileReader("Player.txt"))) {
			while ((textToRead = bufferReader.readLine()) != null) {

				String[] list = textToRead.split(",");
				playerList.put(Integer.parseInt(list[1]), list[0]);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return playerList;
	}

}
