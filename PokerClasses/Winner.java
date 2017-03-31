package PokerClasses;

import java.util.Arrays;
import java.util.List;

public class Winner implements IWinner {

	/*
	 * private String diamonds = "Diamonds"; private String hearts = "Hearts";
	 * private String clubs = "Clubs"; private String spades = "Spades";
	 */

	@Override
	public boolean Check_Royalflush(Player p) {
		List<Card> crd = p.getCards();
		int counter = 0;

		String cardTyp = crd.get(0).getCardType();

		// System.out.println(cardTyp);

		for (Card c : crd) {
			if (c.getCardType().equals(cardTyp)) {
				if (c.getCardName().equals(Card.cardNameEnum.TEN.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.JACK.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.QUEEN.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.ACE.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.KING.toString()))
					counter++;
			}
		}
		// System.out.println(counter);
		if (counter == 5) {
			p.setScore(1000000);
			// System.out.println("ROYAL FLUSH 100");
			p.setWinType("ROYAL FLUSH");
			return true;
		} else
			return false;
	}

	@Override
	public boolean Check_Straightflush(Player p) {
		List<Card> crd = p.getCards();
		int counter = 0;
		String cardTyp = crd.get(0).getCardType();
		// System.out.println(cardTyp);

		for (Card c : crd) {
			if (c.getCardType().equals(cardTyp)) {
				if (c.getCardName().equals(Card.cardNameEnum.THREE.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.FOUR.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.FIVE.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.SIX.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.SEVEN.toString()))
					counter++;
			}
		}
		// System.out.println(counter);
		if (counter == 5) {
			p.setScore(99000);
			// System.out.println("STRAIGHT FLUSH 99");
			p.setWinType("STRAIGHT FLUSH");
			return true;
		} else
			return false;
	}

	@Override
	public boolean Check_Flush(Player p) {
		List<Card> crd = p.getCards();
		int counter = 0;
		String cardTyp = crd.get(0).getCardType();

		for (Card c : crd) {
			if (c.getCardType().equals(cardTyp)) {
				if (c.getCardName().equals(Card.cardNameEnum.THREE.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.SIX.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.NINE.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.QUEEN.toString()))
					counter++;
				else if (c.getCardName().equals(
						Card.cardNameEnum.KING.toString()))
					counter++;
			}
		}
		// System.out.println(counter);
		if (counter == 5) {
			p.setScore(9600);
			// System.out.println("FLUSH 96");
			p.setWinType("FLUSH");
			return true;
		} else
			return false;
	}

	@Override
	public boolean Check_Pairs(Player p) {
		List<Card> crd = p.getCards();
		int counter = 0;

		for (int i = 0; i < 4; i++) {
			String s1 = crd.get(i).getCardName();
			for (int j = i + 1; j < 5; j++) {
				String s2 = crd.get(j).getCardName();
				if (s1.equals(s2)) {
					counter++;
				}
			}
		}

		// System.out.println("Kind checker = " + counter);
		if (counter == 4) {
			p.setScore(9700);
			// System.out.println("FULL HOUSE 97");
			p.setWinType("FULL HOUSE");
			return true;
		} else if (counter == 6) {
			p.setScore(9800);
			// System.out.println("FOUR OF A KIND 98");
			p.setWinType("FOUR OF A KIND");
			return true;
		} else if (counter == 2) {
			p.setScore(9300);
			// System.out.println("TWO PAIRS 93");
			p.setWinType("TWO PAIRS");
			return true;
		} else if (counter == 1) {
			p.setScore(920);
			// System.out.println("PAIR 92");
			p.setWinType("PAIR");
			return true;
		} else
			return false;
	}

	@Override
	public boolean Check_High_Card(Player p) {
		List<Card> crd = p.getCards();
		int score = p.getScore();
		for (Card c : crd) {
			score += c.getPower();
		}
		// System.out.println("\nHigh Card Score: " + score);
		p.setScore(score);
		return true;
	}

	@Override
	public boolean Check_Straight(Player p) {
		List<Card> crd = p.getCards();
		int a[] = new int[5];
		int i = 0;
		for (Card c : crd) {
			a[i] = c.getPower();
			i++;
		}
		Arrays.sort(a);

		if (a[4] - a[0] == 4) {
			p.setScore(9500);
			// System.out.println("\nStraigth Card Score: 95");
			p.setWinType("Straigth");
			return true;
		} else
			return false;
	}

}
