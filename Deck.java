package euchreGame;

//Project Name: Euchre Game
//Name: Sam Couper
//Date: 08-17-2026
//Description: Manages a 24-card Euchre deck, including shuffling and dealing.

import java.util.ArrayList;

public class Deck {
    
    //Sets what deck looks like, with 4 suits, and 6 cards of each suit.
    private ArrayList<Card> cards;
    private String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String [] ranks = {"9", "10", "Jack", "Queen", "King", "Ace"};
    
    //Creates the deck
    public Deck() {
        cards = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    
    //Shuffles the cards
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex,  temp);
        }
    }
    
    //Deals the cards
    public Card dealCard() {
        if (cards.size() > 0) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }
}
