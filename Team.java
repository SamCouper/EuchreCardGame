package euchreGame;

//Project Name: Euchre Game
//Name: Sam Couper
//Date: 08-17-2026
//Description: Represents a team of two players, and tracks the scores.

public class Team {
    private String teamName;
    private Player player1;
    private Player player2;
    private int gameScore;
    private int tricksWon;
    
    //Creates Teams and starting values
    public Team(String teamName, Player player1, Player player2) {
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
        this.gameScore = 0;
        this.tricksWon = 0;
    }
    
    public String getTeamName() {
        return teamName;
    }
    //Adds points to teams score
    public void addGamePoints(int points) {
        gameScore += points;
    }
    //Allows to see game score
    public int getGameScore() {
        return gameScore;
    }
    //Shows when a team won a trick
    public void winTrick() {
        tricksWon++;
    }
    public int getTricksWon() {
        return tricksWon;
    }
    //Resets tricks after each round
    public void resetTricks() {
        tricksWon = 0;
    }
    //Checks if specific player is member of certain team
    public boolean hasPlayer(Player p) {
        return player1 == p || player2 == p;
    }
}
