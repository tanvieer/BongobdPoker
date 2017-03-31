package PokerClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameFactory extends Card implements ICards {

	private static List<Card> fullDeck = new ArrayList<Card>();

	private static GameFactory GF = null;

	private GameFactory() {

	}

	public static GameFactory getInstance() {
		if (GF == null)
			GF = new GameFactory();
		return GF;
	}

	public void StartGame() {
		if (fullDeck.isEmpty()) {
			fullDeck.addAll(getDeck("Clubs"));
			fullDeck.addAll(getDeck("Diamonds"));
			fullDeck.addAll(getDeck("Hearts"));
			fullDeck.addAll(getDeck("Spades"));
		}
	}

	public void ResetDeck() {
		fullDeck.clear();
		StartGame();
	}

	public void printDeck() {
		for (Card c : fullDeck) {
			System.out.println(c.getCardName() + " " + c.getCardType());
		}
	}

	@Override
	public void Shuffle() {
		long seed = System.nanoTime();
		Collections.shuffle(fullDeck, new Random(seed));
	}

	@Override
	public void Deal(int hands) {
		if (hands < 2 || hands > 5) {
			System.out.println("Hands range 2 to 5");
			return;
		}
		Player.setPlayer(hands);
		for (int i = 0; i < 5; i++) {
			for (Player p : Player.players) {
				// System.out.println(fullDeck.get(0));
				Card c = fullDeck.get(0);

				// System.out.println("Check = "+c.getCardName());
				p.addCards(c);
				fullDeck.remove(0);
			}
		}
		printPlayersDeck();
		System.out
				.println("\n--------------------------------------------------");
		FindWinner();
	}

	private void printPlayersDeck() {
		for (Player p : Player.players) {
			p.DisplayCards();
		}
	}

	// =====================================================================================================

	public static void FindWinner() {
		Winner winner = new Winner();
		for (Player p : Player.players) {

			if (winner.Check_Royalflush(p)) {
				System.out.println(p.getName() + " Is Winner AND Win Type is "
						+ p.getWinType());
				return;
			} else if (winner.Check_Straightflush(p)) {
				// System.out.println(p.getName()+" Is Winner AND Win Type is "+p.getWinType());

			} else if (winner.Check_Pairs(p)) {
				// System.out.println(p.getName()+" Is Winner AND Win Type is "+p.getWinType());

			} else if (winner.Check_Flush(p)) {
				// System.out.println(p.getName()+" Is Winner AND Win Type is "+p.getWinType());

			} else if (winner.Check_Straight(p)) {
				// System.out.println(p.getName()+" Is Winner AND Win Type is "+p.getWinType());

			}

			winner.Check_High_Card(p);

			// System.out.println(p.getName()+"   :::   "+p.getScore()+
			// "  type = "+ p.getWinType());

		}

		String winnerName = "";
		String winType = "";
		int winnerScore = 0;
		for (Player p : Player.players) {
			if (winnerScore < p.getScore()) {
				winnerScore = p.getScore();
				winnerName = p.getName();
				winType = p.getWinType();
			}
		}
		if (winType.equals("LOOSER"))
			winType = "High Cards";
		System.out.println();
		System.out.println(winnerName + " is Winner AND win by " + winType
				+ "\n\n");

	}

}
