package ca.sheridancollege.project;

/**
 * This class models a player of WarGame.
 * @author Cory Salmon
 * @modified by Nawaphan Chayopathum(Jan)
 */
public class WARPlayer extends Player{

    private GroupOfCards playerHand;
    private GroupOfCards playerPile;
    
    public WARPlayer(String name) {
        super(name);
        playerHand = new GroupOfCards();
        playerPile = new GroupOfCards();
    }

//    @Override
//    public void play() {
//    }

    public Card playCard() {
        if (playerHand.getSize() > 0) {
            return playerHand.getMostRecentCard();
        }
        return null;
    }
    
    public void collectCard(Card card){
        playerPile.addCard(card);
    }
    
    public void collectCards(GroupOfCards groupOfCard){
        playerPile.addCards(groupOfCard);
    }
    
    public void changeGroupOfCards(){
        //change pile
        playerHand.addCards(playerPile); 
        //clear the pile that already change
        playerPile.clear();
    }
    
    public int numberOfCards(){
        return playerHand.getSize() + playerPile.getSize();
    }

    @Override
    public String toString() {
        return getPlayerID() + "'s Current Hand:\n\u001B[34m" + playerHand + "\u001B[0m\n" + getPlayerID() + "'s Current Pile:\n\u001B[35m"+playerPile+"\u001B[0m";
    }
    
}
