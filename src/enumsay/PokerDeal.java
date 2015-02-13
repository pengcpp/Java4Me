package enumsay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Poker Demo
 *
 */
public class PokerDeal {

	public static void main(String[] args) {

		int numHands = Integer.parseInt("4"); // the number of hands 
        int cardsPerHand = Integer.parseInt("5"); // the number of cards per hand
        
        List<PokerCard> deck  = PokerCard.newDeck();
        Collections.shuffle(deck);
        for (int i=0; i < numHands; i++)
            System.out.println(deal(deck, cardsPerHand));
	}
	
	public static ArrayList<PokerCard> deal(List<PokerCard> deck, int n) {
		
        int deckSize = deck.size();
        List<PokerCard> handView = deck.subList(deckSize-n, deckSize);
        ArrayList<PokerCard> hand = new ArrayList<PokerCard>(handView);
        handView.clear();
        return hand;
    }

}
