package ca.sheridancollege.project;
/**
 * @author Cory Salmon
 * @modified by Nawaphan Chayopathum(Jan)
 * @modified by Samuel Sousa
 */
public class WARPlayer extends Player{

    private GroupOfCards playerHand; //Player's hand of cards
    private GroupOfCards playedHand; //Cards played
    
   /**
    * Construct a player's playerHand and playedHand 
    * 
    * @param name name of player
    */
    public WARPlayer(String name) {
        super(name);
        playerHand = new GroupOfCards();
        playedHand = new GroupOfCards();
    }

   /**
    * Playing a card
    * 
    * @return the most recent card, unless there is no cards then
    * add more cards to the playerHand, then return the most recent card
    * 
    * If no conditions are met return null
    */
    public Card playCard() {
        if (playerHand.getSize() > 0) {
            return playerHand.getMostRecentCard();
        } else if (playerHand.getSize() == 0) {
            changeGroupOfCards();
            return playerHand.getMostRecentCard();
        }
        return null;
    }
    
   /**
    * Add a card to the playedHand
    * 
    * @param card card to be added to the playerHand
    */
    public void collectCard(Card card){
        playedHand.addCard(card);
    }
    
   /**
    * Add an entire group of cards to playedHand
    * 
    * @param groupOfCard a group of cards which will be added
    */
    public void collectCards(GroupOfCards groupOfCard){
        playedHand.addCards(groupOfCard);
    }
    
    /**
     * Add the pile of of cards played to the player's playerHand
     */
    public void changeGroupOfCards(){
        //change pile
        playerHand.addCards(playedHand); 
        //clear the pile that already change
        playedHand.clear();
    }
    
    /**
     * Check the number of cards in a player's playerHand and playedHand
     * 
     * @return the sum of the size of playerHand and playedHand
     */
    public int numberOfCards(){
        return playerHand.getSize() + playedHand.getSize();
    }

    /**
     * Print a WARplayer's player id, playedHand and playerHand
     * 
     * @return playerID, playerHand & playedHand
     */
    @Override
    public String toString() {
        return getPlayerID() + " WarPlayer{" + "playerHand=" + playerHand + ", playedHand=" + playedHand + '}';
    }
    
}
