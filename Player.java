package euchreGame;

//Project Name: Euchre Game
//Name: Sam Couper
//Date: 08-17-2026
//Description: Represents a player, either Human or AI, managing their hand and moves.

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    //Sets player names
    private String name;
    private boolean isHuman;
    private ArrayList<Card> hand;
    
    //Creates Players
    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
        this.hand = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    //Adds card to hand
    public void addCard(Card c) {
        hand.add(c);
    }
    //Clears the player's hands, namely for after each round
    public void clearHand() {
        hand.clear();
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    //Logic to play a card
    public Card playCard(String leadSuit, String trumpSuit, Scanner scan) {
        System.out.println(name + "'s turn.");
        if (isHuman) {
            //Human Logic
            System.out.println("Your hand: ");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println("[" + i + "]" + hand.get(i));
            }
            System.out.println("Enter index of card to play: ");
            int index = scan.nextInt();
            return hand.remove(index);
        } else {
            //AI Logic: Plays first legal card
            for (int i = 0; i < hand.size(); i++) {
                if (leadSuit == null || hand.get(i).effectiveSuit(trumpSuit).equals(leadSuit)) {
                    System.out.println(name + " plays " + hand.get(i));
                    return hand.remove(i);
                }
            }
            System.out.println(name + " plays " + hand.get(0));
            return hand.remove(0);
        }
    }
    
    //Bidding logic
    public boolean makeBid(Card turnedUp, Scanner scan) {
        if (isHuman) {
            //Human Logic
            System.out.println("Turned up card is: " + turnedUp);
            System.out.println("Your hand: " + hand);
            System.out.println("Do you want to order up " + turnedUp.getSuit() + " as trump? (true/false): ");
            return scan.nextBoolean();
        } else {
            //AI Logic: Bids if they have Jack of that suit
            for (Card c : hand) {
                if (c.getSuit().equals(turnedUp.getSuit()) && c.getRank().equals("Jack")) {
                    System.out.println(name + " orders it up.");
                    return true;
                }
            }
            System.out.println(name + " passes.");
            return false;
        }
    }
}
