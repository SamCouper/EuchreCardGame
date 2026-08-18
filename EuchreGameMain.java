package euchreGame;

//Project Name: Euchre Game
//Name: Sam Couper
//Date: 08-17-2026
//Description: Main driver class. Initializes game, asks for the winning score, and loops until a team reaches that score.

import java.util.Scanner;

public class EuchreGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Sam's Java Euchre!");
        
        //Players
        Player p1 = new Player("Human (You)", true);
        Player p2 = new Player("AI Partner", false);
        Player p3 = new Player("AI Opponent 1", false);
        Player p4 = new Player("AI Opponent 2", false);
        
        //Turn Order: You, Opponent 1, Partner, Opponent 2
        Player [] players = {p1, p3, p2, p4};
        Team team1 = new Team("Team You", p1, p2);
        Team team2 = new Team("Team Opponents", p3, p4);
        
        //Sets up interface to choose how many rounds you would like to play.
        int rounds = 1;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Select how many rounds to play:");
            System.out.println("[0] Play One Round [1] Play Three Rounds [2] Play Five Rounds");
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                if (choice == 0) {
                    rounds = 1;
                    validChoice = true;
                } else if (choice == 1) {
                    rounds = 3;
                    validChoice = true;
                } else if (choice == 2) {
                    rounds = 5;
                    validChoice = true;
                } else {
                    System.out.println("Invalid Choice. Please enter 0, 1, or 2.");
                }
            } else {
                System.out.println("Invalid Input. Please enter a number.");
                scan.next();
            }
        }
        
        boolean playing = true;
        
        //Main Game Loop
        while (playing) {
            for ( int r = 1; r <= rounds; r++) {
                System.out.println("Round " + r + " of " + rounds + ".");
                System.out.println("SCORE - " + team1.getTeamName() + " (" + team1.getGameScore() + ") vs " + team2.getTeamName() + " (" + team2.getGameScore() + ")");
                Round round = new Round(players, team1, team2, scan);
                round.playRound();
            }
            
            //Post-Game
            boolean postGame = false;
            while (!postGame) {
                System.out.println("Current Score: " + team1.getTeamName() + ": " + team1.getGameScore() + " | " + team2.getTeamName() + ": " + team2.getGameScore());
                System.out.println("[0] Play 1 more round [1] End Game");
                if (scan.hasNextInt()) {
                    int post = scan.nextInt();
                    if (post == 0) {
                        rounds = 1;
                        postGame = true;
                    } else if (post == 1) {
                        playing = false;
                        postGame = true;
                    } else {
                        System.out.println("Invalid Choice. Please enter 0 or 1.");
                    }
                } else {
                    System.out.println("Invalid Input. Please enter a number.");
                    scan.next();
                }
            }
        }
        
        //Final Game Summary
        System.out.println("Final Score: ");
        System.out.println(team1.getTeamName() + ": " + team1.getGameScore() + " points.");
        System.out.println(team2.getTeamName() + ": " + team2.getGameScore() + " points.");
        scan.close();
    }
}
