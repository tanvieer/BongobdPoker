package PokerClasses;

import java.util.ArrayList;
import java.util.List;

class Card {
	public static enum cardNameEnum {
		ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
	}

	private String cardName;
	private String cardType;
	private int power;

	private Card(cardNameEnum cardName, String cardType, int power) {
		this.cardName = cardName.toString();
		this.cardType = cardType;
		this.power = power;
	}

	public Card() {
	}

	protected static List<Card> getDeck(String type) {
		List<Card> cards = new ArrayList<Card>();

		cards.add(new Card(cardNameEnum.ACE, type, 13));
		cards.add(new Card(cardNameEnum.KING, type, 12));
		cards.add(new Card(cardNameEnum.QUEEN, type, 11));
		cards.add(new Card(cardNameEnum.JACK, type, 10));
		cards.add(new Card(cardNameEnum.TEN, type, 9));
		cards.add(new Card(cardNameEnum.NINE, type, 8));
		cards.add(new Card(cardNameEnum.EIGHT, type, 7));
		cards.add(new Card(cardNameEnum.SEVEN, type, 6));
		cards.add(new Card(cardNameEnum.SIX, type, 5));
		cards.add(new Card(cardNameEnum.FIVE, type, 4));
		cards.add(new Card(cardNameEnum.FOUR, type, 3));
		cards.add(new Card(cardNameEnum.THREE, type, 2));
		cards.add(new Card(cardNameEnum.TWO, type, 1));

		return cards;
	}

	public int getPower() {
		return power;
	}

	public String getCardName() {
		return cardName;
	}

	public String getCardType() {
		return cardType;
	}
}
