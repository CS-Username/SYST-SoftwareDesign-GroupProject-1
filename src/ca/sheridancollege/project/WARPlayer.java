package ca.sheridancollege.project;

/**
 * This class models a player of WarGame.
 * @author Cory Salmon
 * @modified by Nawaphan Chayopathum(Jan)
 * @modified by Samuel Sousa
 */
public class WARPlayer extends Player{


    private GroupOfCards playerHand; //Player's hand of cards
    private GroupOfCards playedHand; //Cards played

    
   /**
    * Constructs a player's playerHand and playedHand for the player and intializes them.
    * 
    * @param name name of player.
    */
    public WARPlayer(String name) {
        super(name);
        playerHand = new GroupOfCards();
        playerPile = new GroupOfCards();
    }

   /**
    * Plays the most recent card from the players hand If there are no cards it
    * add more cards to the playerHand, then returns the most recent card. Returns null if no conditions are met.
    * 
    * @return the most recent card from the players hand.
    * 

    */
    public Card playCard() {
        if (playerHand.getSize() > 0) {
            return playerHand.getMostRecentCard();
        }
        return null;
    }
    
   /**
    * Adds a card to the playedHand.
    * 
    * @param card card to be added to the playerHand.
    */
    public void collectCard(Card card){
        playerPile.addCard(card);
    }
    
   /**
    * Adds an entire group of cards to playedHand.
    * 
    * @param groupOfCard group of cards which will be added.
    */
    public void collectCards(GroupOfCards groupOfCard){
        playerPile.addCards(groupOfCard);
    }
    
    /**
     * Adds the pile of of cards played to the player's playerHand.
     */
    public void changeGroupOfCards(){
        //change pile
        playerHand.addCards(playerPile); 
        //clear the pile that already change
        playerPile.clear();
    }
    
    /**
     * Checks the number of cards in a player's playerHand and playedHand.
     * 
     * @return the sum of the size of playerHand and playedHand.
     */
    public int numberOfCards(){
        return playerHand.getSize() + playerPile.getSize();
    }

    /**
     * Retrieves this WARplayer's player id, playedHand and playerPile in one string.
     * 
     * @return player id, playedHand and playerPile
     */
    @Override
    public String toString() {
        return getPlayerID() + "'s Current Hand:\n\u001B[34m" + playerHand + "\u001B[0m\n" + getPlayerID() + "'s Current Pile:\n\u001B[35m"+playerPile+"\u001B[0m";
    }
    
}
