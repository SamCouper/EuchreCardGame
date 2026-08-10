# EuchreCardGame
Plan is to create the card game titled Euchre.
## Class Structure
To implement the game of Euchre, this project uses the following:
*   **Card**: Represents a single playing card. It holds attributes for the suit (Hearts, Diamonds, Clubs, Spades) and rank (9, 10, Jack, Queen, King, and Ace).
*   **Deck**: Represents a standard Euchre deck of 24 'Card' objects. Manages the collection of cards and handles shuffling and dealing.
*   **Player**: Represents a single player (Human or AI). It contains a list of up to 5 'Card' objects representing the player's hand and handles logic for choosing a card to play or bidding on trump.
*   **Team**: Represents a partnership of two 'Player' objects. It tracks the team's overall game score and the number of tricks won in current round.
*   **Trick**: Represents a single hand of play (4 cards played in sequence). It compares the played 'Card' objects against the lead suit and the trump suit to determine which 'Player' wins the trick.
*   **Round**: Manages the flow of a single round of Euchre: dealing cards, the bidding phase, playing 5 tricks, and calculating points to assign to the winning 'Team'.
*   **EuchreGame (Main)**: The main driver class of the application. Will initialize the teams and players, run a loop of 'Round' instances, and track the overall game until one 'Team' reaches 10 points.
