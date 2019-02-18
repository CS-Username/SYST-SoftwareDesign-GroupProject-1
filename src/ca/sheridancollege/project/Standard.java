/*
    Name: Cory Salmon
    Assignment:
    Program: PROG24178/Object Oriented Programming 2: Java
    Date:
    Description:
*/

package ca.sheridancollege.project;

public class Standard extends Card{

    /**
     * enum for suit of standard deck card
     */
    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    /**
     * enum for value of standard deck card
     */
    public enum Value {
        ACE (12),
        TWO(0),
        THREE(1),
        FOUR(2),
        FIVE(3),
        SIX(4),
        SEVEN(5),
        EIGHT(6),
        NINE(7),
        TEN(8),
        JACK(9),
        QUEEN(10),
        KING(11);
        
        private final int numericalValue;

        private Value(int numericalValue) {
            this.numericalValue = numericalValue;
        }

        protected int getNumericalValue() {
            return numericalValue;
        }
    }
    
    private final Suit suit;
    private final Value value;

    /** Creation of card using enums Value and Suit
     * 
     * @param suit Suit of card
     * @param value Value of card
     */
    public Standard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    /**
     * Returns the Suit and Value of the card in sentence form [Value] of [Suits]
     * 
     * @return String suit and value of card
     */
    @Override
    public String toString(){
        return this.suit.name() + " of " + this.value.name();
    }
    /**
     * Overrides comparedTo to compare Standard card to parameter Standard card
     * @param otherCard Standard card to be compared
     * @return Comparison
     */
    @Override
    public int compareTo(Card otherCard) {
        if (this.value.getNumericalValue() == ((Standard)otherCard).value.getNumericalValue()) {
            return 0;
        }
        else if (this.value.getNumericalValue() > ((Standard)otherCard).value.getNumericalValue()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}