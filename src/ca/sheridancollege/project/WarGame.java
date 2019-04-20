package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * This class models the war game rule.
 *
 * @author Nawaphan Chayopathum(Jan)
 * @modified Cory Salmon
 */
public class WarGame extends Game {

    private WARPlayer player1;
    private WARPlayer player2;

    private final String line = "--------------------------------------------------";

    /**
     * This constructor instantiates an instance of WarGame
     */
    public WarGame() {
        super("War Game");
        //create new player
        player1 = new WARPlayer(usernameInput("Player 1"));
        player2 = new WARPlayer(usernameInput("Player 2"));
        System.out.println(line);
        //add player to player list in Game
        addPlayer(player1);
        addPlayer(player2);
    }

    /**
     * This method gets the names of players
     *
     * @return String name of Player
     */
    private String usernameInput(String genericPlayer) {
        Scanner scan = new Scanner(System.in);
        String name;
        do {
            System.out.println(genericPlayer + " Enter Your Name: ");
            try {
                name = scan.nextLine();
            } catch (Exception e) {
                name = "";
            }
        } while (name == null || name.trim().isEmpty());//checks that player has entered a name not counting whitespace

        return name;
    }

    /**
     * This method prepares the game by adding a deck, shuffling it, and
     * distributing it amongst players.
     */
    private void prepareWarGame() {
        //create the card deck
        GroupOfCards gameDeck = new GroupOfCards();
        //creates new unshuffled deck
        for (Standard.Suit suit : Standard.Suit.values()) {
            for (Standard.Value value : Standard.Value.values()) {
                gameDeck.addCard(new Standard(suit, value));
            }
        }
        //shuffles deck
        gameDeck.shuffle();
        //deal the card to both player
        while (gameDeck.getSize() >= 2) {
            player1.collectCard(gameDeck.getMostRecentCard());
            player2.collectCard(gameDeck.getMostRecentCard());
        }
        //fill the hands of each player
        player1.changeGroupOfCards();
        player2.changeGroupOfCards();
        printPlayerHands();
    }

    /**
     * This method provides the main game loop of the game. Both war (if the
     * players play cards with the same value) and normal modes are covered
     *
     */
    @Override
    public void play() {
        prepareWarGame();
        //loop as long as both players still have cards
        while (hasCard(1)) {
            //Players play their cards
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();
            System.out.println(line);
            System.out.println("Normal Turn:");
            System.out.println(line);
            System.out.println(player1.getPlayerID() + " has placed down " + card1);
            System.out.println(player2.getPlayerID() + " has placed down " + card2);
            //Compares the cards played, with the card of highest value winning
            if (card1.compareTo(card2) > 0) { // player1 wins
                winRound(player1, card1, card2);
            } else if (card1.compareTo(card2) < 0) { //player2 wins
                winRound(player2, card1, card2);
            } else { //war
                war(card1, card2);
            }
            //players put new cards at the buttom of their decks
            player1.changeGroupOfCards();
            player2.changeGroupOfCards();
        }
        //when 1 player has no more cards, a declaration i announced
        declareWinner();
    }

    /**
     * Winner collect all the cards in that round
     *
     * @param winner the player who has higher value
     * @param card1 the card from player1
     * @param card2 the card from player2
     */
    private void winRound(WARPlayer winner, Card card1, Card card2) {
        winner.collectCard(card1);
        winner.collectCard(card2);
        printPlayerHands();
    }

    /**
     * This method models the war mode of play. First, it checks to see if both
     * players have enough cards to play the game. If they do not, we have the
     * winner and end war mode and the game. Otherwise, war mode proceeds. The
     * player that has the higher value will win this war.
     *
     * @param player1MatchingCard card from player1 with the same rank as
     * player2
     * @param player2MatchingCard card from player2 with the same rank as
     * player1
     */
    private void war(Card player1MatchingCard, Card player2MatchingCard) {
        // group of cards for war
        GroupOfCards warCards = new GroupOfCards();
        // add the card with same rank from both player to warCards
        warCards.addCard(player1MatchingCard);
        warCards.addCard(player2MatchingCard);
        //continue war as long as war is not done
        while (true) {
            //if one of the player doesn't have enough cards
            if (!hasCard(3)) {
                // when player1 doesn't have enough cards to play war, all cards will be transfer to player2
                if (player1.numberOfCards() < 3) {
                    transferAllCards(player2, player1, warCards);
                } else { // when player2 doesn't have enough cards to play war, all cards will be transfer to player1
                    transferAllCards(player1, player2, warCards);
                }
                //found declaration as 1 player has no more card
                break;
            }
            //both players have enough cards, continue war
            System.out.println(line);
            System.out.println("War : Both players play 3 cards");
            System.out.println(line);
            //loop 3 times to allocate the cards for war
            for (int i = 1; i <= 3; i++) {
                System.out.println("War turn " + i + " : ");
                player1MatchingCard = player1.playCard();
                player2MatchingCard = player2.playCard();
                System.out.println(player1.getPlayerID() + " has placed down " + player1MatchingCard);
                System.out.println(player2.getPlayerID() + " has placed down " + player2MatchingCard);
                warCards.addCard(player1MatchingCard);
                warCards.addCard(player2MatchingCard);
            }
            //compare the card, the higher value win
            if (player1MatchingCard.compareTo(player2MatchingCard) > 0) { // player1 wins
                player1.collectCards(warCards);
                printPlayerHands();
                break;
            } else if (player1MatchingCard.compareTo(player2MatchingCard) < 0) { // player2 wins
                player2.collectCards(warCards);
                printPlayerHands();
                break;
            }
        }
    }

    /**
     * Transfer the remaining cards to declaration.
     *
     * @param winner the player who has enough cards to continue war
     * @param loser the player who doesn't have enough cards to continue war
     * @param warCards the group of card for war game
     */
    private void transferAllCards(WARPlayer winner, WARPlayer loser, GroupOfCards warCards) {
        winner.collectCards(warCards);
        while (loser.numberOfCards() != 0) {
            winner.collectCard(loser.playCard());
        }
    }

    /**
     * Check if the players have enough cards to continue the game.
     *
     * @param minimumNumberOfCards minimum number of cards the players need to
     * have
     * @return true if both players have enough cards; otherwise false
     */
    private boolean hasCard(int minimumNumberOfCards) {
        return player1.numberOfCards() >= minimumNumberOfCards && player2.numberOfCards() >= minimumNumberOfCards;
    }

    /**
     * Declares the winner when the game ends. The winner is the one who has all
     * 52 cards in their hand.
     */
    @Override
    public void declareWinner() {
        String declaration;
        if (player2.numberOfCards() == 0) {
            declaration = "\n\u001B[31m" + player2.getPlayerID() + "\u001B[0m has lost, which means \u001B[32m" + player1.getPlayerID() + "\u001B[0m is the winner!";
        } else {
            declaration = "\n\u001B[31m" + player1.getPlayerID() + "\u001B[0m has lost, which means \u001B[32m" + player2.getPlayerID() + "\u001B[0m is the winner!";
        }
        System.out.println(declaration);
    }

    /**
     * Check the cards that each player has.
     */
    private void printPlayerHands() {
        System.out.println(line);
        System.out.println("Player Hands:");
        System.out.println(line);
        System.out.println(player1);
        System.out.println(player2);
    }
}
