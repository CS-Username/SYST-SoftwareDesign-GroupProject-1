/*
   
*/

package ca.sheridancollege.project;
/**
 * 
 * @author Cory
 * @modified Asher
 */
public class WARPlayer extends Player{

    GroupOfCards playerHand = new GroupOfCards(52);
    GroupOfCards WarHand = new GroupOfCards(52);
    
    public WARPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        
    }
    
    //Need to add group of cards for cards and for war deck
    
}
