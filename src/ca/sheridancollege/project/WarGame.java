package ca.sheridancollege.project;

/**
 *
 * @author Nawaphan Chayopathum(Jan)
 * @modified Cory Salmon
 */
public class WarGame extends Game{

    public WarGame() {
        super("War Game");
    }
    
    public void prepareWarGame(){
        //create the card deck and shuffle
        GroupOfCards gameDeck = new GroupOfCards();
        //Creates new unshuffled deck
        for (int i = 0; i < Standard.Suit.values().length; i++) {
            for (int j = 0; j < Standard.Value.values().length; j++) {
                gameDeck.addCard(new Standard(Standard.Suit.values()[i],Standard.Value.values()[j])); break;
            }
        }
        //shuffles deck
        gameDeck.shuffle();
        //create new player
        //deal the card to both player
        //create the pile for each player
    }

    @Override
    public void play() { 
        //prepareWarGame()
        //loop as long as there are still card present in both player
//        while(){}
        //the player play the card
            //compare the card, the highher value win
            //otherwise, it is a war --> call war()
    }
    
    public void war(){
        boolean isDone = false;
        //check if player has 3 cards
            //yes, continue
                // last card the same value, continue the war
                // diff. value, exit the war and continue normal game
            //no, has winner --> declareWinner()
    }
    
    public boolean hasCard(int n){
        //return (player has left) ? true : false;
        return false; //will be deleted after complete implementation
    }

    @Override
    public void declareWinner() {
        String winner = "The Winner is : ";
        //System.out.println(winner + (p1 has more card)? p1.getPlayerID() : p2.getPlayerID() );
    }

}
