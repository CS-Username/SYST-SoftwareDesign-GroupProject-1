/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
 * @modified by Nawaphan Chayopathum(Jan)
 * @modified by Cory Salmon (Commenting)
 */
public abstract class Game {

    private final String gameName;//the title of the game
    private ArrayList<Player> players;// the players of the game

    /**
     * Constructor for all games with the name of the game
     *
     * @param givenName The name of the game
     */
    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * Retrieves the name of the game
     *
     * @return The name of the game
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Retrieves the players of the game
     *
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;//todo: encapsulate
    }

    /**
     * Sets the players of the game
     *
     * @param players the players of the game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Adds player to the list of players
     *
     * @param player the player added
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * This abstract method is where the game logic will be
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare the winner
     */
    public abstract void declareWinner();

    @Override
    public String toString() {
        return "Game{" + "gameName=" + gameName + ", players=" + players + '}';
    }

}//end class
