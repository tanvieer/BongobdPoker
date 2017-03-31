package PokerClasses;

import java.util.ArrayList;
import java.util.List;

class Player {
	private String name;
	private List<Card> cards = new ArrayList<Card>();
	public static List<Player> players = new ArrayList<Player>();
	private int score;
	private String winType;

	// private int totalScore;
	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.winType = "LOOSER";
	}

	public static void setPlayer(int hands) {
		players.clear();
		for (int i = 1; i <= hands; i++) {
			players.add(new Player("Player" + i));
		}
	}

	public String getWinType() {
		return winType;
	}

	public void setWinType(String winType) {
		this.winType = winType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCards(Card cards) {

		this.cards.add(cards);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void DisplayCards() {
		System.out.print("\n-------------------------------------------------------------------------------\n" + getName() + ": ");
		for (Card c : cards) {
			System.out.print(c.getCardType() + ": " + c.getCardName() + "\t\t");
		}
	}

}
