package euchreGame;

// Project Name: Euchre Game
// Name: Sam Couper
// Date: 08-17-2026
// Description: This class represents a single playing card in the Euchre Game. It stores the suit & rank of the card 
// and provides methods to access & modify them.
public class Card {
    private String suit;
    private String rank;
    
    // Default constructor that initializes an empty card.
    public Card() {
        this.suit = "Unknown";
        this.rank = "Unknown";
    }
    
    // Constructor with parameter to create specific card.
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    // Retrieves the suit of the card.
    public String getSuit() {
        return suit;
    }
 
    // Retrieves the rank of the card.
    public String getRank() {
        return rank;
    }
    
    //Determines if card is the Left Bower
    public boolean isLeftBower(String trumpSuit) {
        if (!rank.equals("Jack"))
            return false;
        if (trumpSuit.equals("Hearts") && suit.equals("Diamonds"))
            return true;
        if (trumpSuit.equals("Diamonds") && suit.equals("Hearts"))
            return true;
        if (trumpSuit.equals("Spades") && suit.equals("Clubs"))
            return true;
        if (trumpSuit.equals("Clubs") && suit.equals("Spades"))
            return true;
        return false;
    }
    
    // Determines the effective suit (So Left Bower acts as trump)
    public String effectiveSuit(String trumpSuit) {
        return isLeftBower(trumpSuit) ? trumpSuit : suit;
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
