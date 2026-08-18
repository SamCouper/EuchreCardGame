package euchreGame;

//Project Name: Euchre Game
//Name: Sam Couper
//Date: 08-17-2026
//Description: Represents a single hand of play and determines the winner.

import java.util.ArrayList;

public class Trick {
    private String trumpSuit;
    private String leadSuit;
    private ArrayList<Card> playedCards;
    private ArrayList<Player> playedBy;
    
    //Initializes trick
    public Trick(String trumpSuit) {
        this.trumpSuit = trumpSuit;
        this.playedCards = new ArrayList<>();
        this.playedBy = new ArrayList<>();
    }
    
    //Records a card played by specific player during trick
    public void addCard(Card c, Player p) {
        if (playedCards.isEmpty()) {
            leadSuit = c.effectiveSuit(trumpSuit);
        }
        playedCards.add(c);
        playedBy.add(p);
    }
    
    //Determines what player plays the highest card
    public Player determineWinner() {
        int highestValue = -1;
        Player winner = null;
        for (int i = 0; i < playedCards.size(); i++) {
            Card c = playedCards.get(i);
            int value = getCardValue(c);
            if (value > highestValue) {
                highestValue = value;
                winner = playedBy.get(i);
            }
        }
        return winner;
    }
    
    //Assigns point values based on Euchre rules
    private int getCardValue(Card c) {
        String effSuit = c.effectiveSuit(trumpSuit);
        int baseValue = getRankValue(c.getRank());
        if (effSuit.equals(trumpSuit) && c.getRank().equals("Jack") && c.getSuit().equals(trumpSuit))
            return 100;
        if (c.isLeftBower(trumpSuit))
            return 95;
        if (effSuit.equals(trumpSuit))
            return 50 + baseValue;
        if (effSuit.equals(leadSuit))
            return baseValue;
        return 0;
    }
    
    //Allows for comparison of value between cards
    private int getRankValue(String rank) {
        switch (rank) {
        case "9":
            return 9;
        case "10":
            return 10;
        case "Jack":
            return 11;
        case "Queen":
            return 12;
        case "King":
            return 13;
        case "Ace":
            return 14;
        default:
            return 0;
        }
    }
}
