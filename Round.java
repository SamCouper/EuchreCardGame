package euchreGame;

//Project Name: Euchre Game
//Name: Sam Couper
//Date: 08-17-2026
//Description: Manages the flow of a single round (dealing, bidding, and all 5 tricks).

import java.util.Scanner;

public class Round {
    private Player [] players;
    private Team team1;
    private Team team2;
    private String trumpSuit;
    private Scanner scan;
    
    //Initializes round play
    public Round(Player [] players, Team team1, Team team2, Scanner scan) {
        this.players = players;
        this.team1 = team1;
        this.team2 = team2;
        this.scan = scan;
    }
    
    //Sets up how a round is played
    public void playRound() {
        team1.resetTricks();
        team2.resetTricks();
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            for (Player p : players)
                p.addCard(deck.dealCard());
        }
        Card turnedUp = deck.dealCard();
        boolean bidWon = false;
        for (Player p : players) {
            if (p.makeBid(turnedUp, scan)) {
                trumpSuit = turnedUp.getSuit();
                System.out.println(p.getName() + " ordered up " + trumpSuit);
                bidWon = true;
                break;
            }
        }
        if (!bidWon) {
            trumpSuit = "Spades";
            System.out.println("Everyone passed. Defaulting trump to Spades.");
        }
        int leadIndex = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("--- Trick " + (i + 1) + " (Trump: " + trumpSuit + ") ---");
            Trick trick = new Trick(trumpSuit);
            for (int j = 0; j < 4; j++) {
                int currentPlayerIndex = (leadIndex + j) % 4;
                Player current = players[currentPlayerIndex];
                Card played = current.playCard(trick.determineWinner() == null ? null : "dummy", trumpSuit, scan);
                trick.addCard(played,  current);
            }
            Player winner = trick.determineWinner();
            System.out.println(winner.getName() + " wins the trick!");
            if (team1.hasPlayer(winner))
                team1.winTrick();
            else
                team2.winTrick();
            for (int k = 0; k < 4; k++) {
                if (players[k] == winner)
                    leadIndex = k;
            }
        }
        
        //Calculates Score
        if (team1.getTricksWon() >= 3) {
            team1.addGamePoints((team1.getTricksWon() == 5) ? 2 : 1);
            System.out.println(team1.getTeamName() + " wins the round!");
        } else {
            team2.addGamePoints((team2.getTricksWon() == 5) ? 2 : 1);
            System.out.println(team2.getTeamName() + " wins the round!");
        }
    }
}
