package PokerClasses;

public interface IWinner {
	boolean Check_Royalflush(Player p); // 1000

	boolean Check_Straightflush(Player p); // 990

	boolean Check_Pairs(Player p); // 980 6

	// boolean Check_Full_House(Player p); // 970 4

	boolean Check_Flush(Player p); // 960

	boolean Check_Straight(Player p); // 950

	// boolean Check_Three_Of_A_Kind(Player p); // 940 3

	// boolean Check_Two_Pairs(Player p); // 930 2

	// boolean Check_Pair(Player p); // 920 1

	boolean Check_High_Card(Player p); // max 91
}
