/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @version 2019-04-19
 * @author dancye
 * @modified by Nawaphan Chayopathum(Jan)
 * @modified by Cory Salmon
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    /**
     * Creates new card Grouping instance
     */
    public GroupOfCards() {
        cards = new ArrayList<>();
    }

//    /**
//     * A method that will get the group of cards as an ArrayList
//     * @return the group of cards.
//     */
//    public ArrayList<Card> showCards()
//    {
//        return cards;
//    }
    /**
     * This is for game comparisons that require cards from the top of a deck
     *
     * @return Most recent card
     */
    public Card getMostRecentCard() {
        Card card = cards.remove(cards.size() - 1);
        updateSize();
        return card;
    }

    /**
     * Adds card to group of cards
     *
     * @param addedCard Card added
     */
    public void addCard(Card addedCard) {
        cards.add(addedCard);
        updateSize();
    }

    /**
     * Adds GroupsOfCards type cards to the currentGroupOfCards
     *
     * @param groupOfCards the group of cards to be added
     */
    public void addCards(GroupOfCards groupOfCards) {
        while (groupOfCards.getSize() > 0) {
            addCard(groupOfCards.getMostRecentCard());
        }
    }

    //Updates size to accurate amount
    private void updateSize() {
        this.size = cards.size();
    }

    //Makes a printable string of all cards
    private String retrievePrintableString() {
        String printable = "";
        if (cards.isEmpty()) {
            printable = "Empty";
        } else {
            for (Card card : cards) {
                printable += card + ", ";
            }
        }
        return printable;
    }

    /**
     * Shuffles the cards inside the group of cards
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Retrieves the size of the deck
     *
     * @return the size of the group of cards
     */
    public int getSize() {
        updateSize();
        return size;
    }

    /**
     * Clears the deck (GroupOfCards)
     */
    public void clear() {
        cards.clear();
        updateSize();
    }

    /**
     * Returns information about the current deck (GroupOfCards)
     *
     * @return information about the current deck (GroupOfCards)
     */
    @Override
    public String toString() {
        updateSize();
        String toStringOutput = size + " Cards:\n" + retrievePrintableString();
        return toStringOutput;
    }

}//end class
