/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import static ca.sheridancollege.project.Standard.Suit.*;
import static ca.sheridancollege.project.Standard.Value.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the methods of the GroupsOfCards Class
 * @author Cory Salmon (991526849)
 */
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
    }

    /**
     * Test of getMostRecentCard method, of class GroupOfCards.
     * This test makes a Good request from a GroupofCards with more than enough cards
     */
    @Test
    public void testGetMostRecentCard_Good() {
        System.out.println("getMostRecentCard");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new Standard(CLUBS, JACK));
        instance.addCard(new Standard(DIAMONDS, ACE));
        instance.addCard(new Standard(SPADES, TEN));
        instance.addCard(new Standard(HEARTS, QUEEN));
        Card card1 = new Standard(CLUBS, JACK);
        int result = (instance.getMostRecentCard()).compareTo(card1);
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getMostRecentCard method, of class GroupOfCards.
     * This test makes a Bad request from a GroupofCards with no cards
     */
    @Test (expected = NullPointerException.class)
    public void testGetMostRecentCard_Bad() {
        System.out.println("getMostRecentCard");
        GroupOfCards instance = new GroupOfCards();
        Card card1 = null;
        int result = (instance.getMostRecentCard()).compareTo(card1);
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getMostRecentCard method, of class GroupOfCards.
     * This test makes a Boundary request from a GroupofCards with one card which is just enough
     */
    @Test
    public void testGetMostRecentCard_Boundary() {
        System.out.println("getMostRecentCard");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new Standard(HEARTS, QUEEN));
        Card card1 = new Standard(HEARTS, QUEEN);
        int result = (instance.getMostRecentCard()).compareTo(card1);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of addCard method, of class GroupOfCards.
     * This test gives a Good input of a new Standard(HEARTS, QUEEN) card
     */
    @Test
    public void testAddCard_Good() {
        System.out.println("addCard");
        Card addedCard = new Standard(HEARTS, QUEEN);
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(addedCard);
        int result = instance.getSize();
        int expResult = 1;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addCard method, of class GroupOfCards.
     * This test gives a Bad input of null for card
     */
    @Test
    public void testAddCard_Bad() {
        System.out.println("addCard");
        Card addedCard = null;
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(addedCard);
        int result = instance.getSize();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class GroupOfCards.
     * This is a Good test with many cards in this group of cards
     */
    @Test
    public void testGetSize_Good() {
        System.out.println("getSize");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new Standard(CLUBS, JACK));
        instance.addCard(new Standard(DIAMONDS, ACE));
        instance.addCard(new Standard(SPADES, TEN));
        instance.addCard(new Standard(HEARTS, QUEEN));
        int expResult = 4;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSize method, of class GroupOfCards.
     * This is a Boundary test with 0 cards in the deck
     */
    @Test
    public void testGetSize_Boundary() {
        System.out.println("getSize");
        GroupOfCards instance = new GroupOfCards();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }
    
    //another boundary test could be the limit of ints

    /**
     * Test of clear method, of class GroupOfCards.
     * This is a Good test where there are many cards to be cleared
     */
    @Test
    public void testClear_Good() {
        System.out.println("clear");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new Standard(CLUBS, JACK));
        instance.addCard(new Standard(DIAMONDS, ACE));
        instance.addCard(new Standard(SPADES, TEN));
        instance.addCard(new Standard(HEARTS, QUEEN));
        instance.clear();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of clear method, of class GroupOfCards.
     * This is a Boundary test where there are no cards to be cleared
     */
    @Test
    public void testClear_Boundary() {
        System.out.println("clear");
        GroupOfCards instance = new GroupOfCards();
        instance.clear();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class GroupOfCards.
     * This is a Good test for toString where the group of cards has many cards
     */
    @Test
    public void testToString_Good() {
        System.out.println("toString");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new Standard(CLUBS, JACK));
        instance.addCard(new Standard(DIAMONDS, ACE));
        instance.addCard(new Standard(SPADES, TEN));
        instance.addCard(new Standard(HEARTS, QUEEN));
        boolean expResult = true;
        boolean result = instance.toString().equals("4 Cards:\nQUEEN of HEARTS, TEN of SPADES, ACE of DIAMONDS, JACK of CLUBS, ");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class GroupOfCards.
     * This is a Boundary test for toString where the group of cards is empty
     */
    @Test
    public void testToString_Boundary() {
        System.out.println("toString");
        GroupOfCards instance = new GroupOfCards();
        boolean expResult = true;
        boolean result = instance.toString().equals("0 Cards:\nEmpty");
        assertEquals(expResult, result);
    }
    
}
