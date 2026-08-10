package euchreGame;

// Project Name: Euchre Game
// Name: Sam Couper
// Date: 08-10-2026
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
    
    // Sets the suit of the card.
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
 // Retrieves the rank of the card.
    public String getRank() {
        return rank;
    }
    
    // Sets the rank of the card.
    public void setRank(String rank) {
        this.rank = rank;
    }
}
