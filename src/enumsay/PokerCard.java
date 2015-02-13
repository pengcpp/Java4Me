package enumsay;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * PokerCard
 */
public class PokerCard {

	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	private final Rank rank;
	private final Suit suit;

	private PokerCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return rank;
	}

	public Suit suit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	/**
	 * Singleton property
	 */
	private static final List<PokerCard> protoDeck = new ArrayList<PokerCard>();

	// Initialize prototype deck
	static {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				protoDeck.add(new PokerCard(rank, suit));
	}

	public static ArrayList<PokerCard> newDeck() {
		// Return copy of prototype deck
		return new ArrayList<PokerCard>(protoDeck);
	}

	/**
	 * using a nested EnumMap to preserve the singleton property
	 * 
	 * it is imperative that the initialization of EnumMap be placed above the
	 * initialization of protoDeck...
	 */
	private static Map<Suit, Map<Rank, PokerCard>> table = new EnumMap<Suit, Map<Rank, PokerCard>>(
			Suit.class);
	
	static {
		for (Suit suit : Suit.values()) {
			Map<Rank, PokerCard> suitTable = new EnumMap<Rank, PokerCard>(
					Rank.class);
			for (Rank rank : Rank.values())
				suitTable.put(rank, new PokerCard(rank, suit));
			table.put(suit, suitTable);
		}
	}

	public static PokerCard valueOf(Rank rank, Suit suit) {
		return table.get(suit).get(rank);
	}
	
	/**
	 * if you wanna use table, initialize prototype deck like this...
	 * 
	 * static {
	 * 	 for (Suit suit : Suit.values())
	 * 		for (Rank rank : Rank.values())
	 * 			protoDeck.add(PokerCard.valueOf(rank, suit));
	 * }
	 */

}
