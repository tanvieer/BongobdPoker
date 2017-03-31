package UserPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import PokerClasses.GameFactory;

public class MainClass {

	public static void main(String[] args) throws IOException {

		GameFactory f = GameFactory.getInstance();
		f.StartGame();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Commands:  Shuffle , Exit\n");
			System.out.print("-------------------------\n\n");
			System.out.print("Enter Command(i.e Shuffle)\n");
			String command = br.readLine();
			command = command.trim().toLowerCase();

			if (command.equals("exit"))
				break;

			else if (command.equals("shuffle")) {

				f.Shuffle();
				System.out.print("Enter Number of Hands(2 to 5):");
				int hands = Integer.parseInt(br.readLine());

				f.Deal(hands);

				f.ResetDeck();
			}

		}

	}

}
