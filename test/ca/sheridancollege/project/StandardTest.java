package ca.sheridancollege.project;

import static ca.sheridancollege.project.Standard.Suit.CLUBS;
import static ca.sheridancollege.project.Standard.Value.ACE;
import static ca.sheridancollege.project.Standard.Value.KING;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the methods in Standard
 * 
 * @author Nawaphan (Jan)
 */
public class StandardTest {
    
    public StandardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Standard.
     * This test gives a good input of Standard(CLUBS, ACE), which should
     * easily be used to pass as string.
     */
    @Test
    public void testToString_Good() {
        System.out.println("toString");
        Standard instance = new Standard(CLUBS, ACE);
        String expResult = "ACE of CLUBS";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Standard. 
     * This test gives a good input of Standard(CLUBS, ACE), which should 
     * be compared to Standard(CLUBS, KING).
     */
    @Test
    public void testCompareTo_Good_minus1() {
        System.out.println("compareTo");
        Card otherCard = new Standard(CLUBS, ACE);
        Standard instance = new Standard(CLUBS, KING);
        int expResult = -1;
        int result = instance.compareTo(otherCard);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Standard.
     * This test gives a good input of Standard(CLUBS, ACE), which should
     * be compared to Standard(CLUBS, ACE).
     */
    @Test
    public void testCompareTo_Good_0() {
        System.out.println("compareTo");
        Card otherCard = new Standard(CLUBS, ACE);
        Standard instance = new Standard(CLUBS, ACE);
        int expResult = 0;
        int result = instance.compareTo(otherCard);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Standard. 
     * This test gives a good input of Standard(CLUBS, KING), which should
     * be compared to Standard(CLUBS, ACE).
     */
    @Test
    public void testCompareTo_Good_1() {
        System.out.println("compareTo");
        Card otherCard = new Standard(CLUBS, KING);
        Standard instance = new Standard(CLUBS, ACE);
        int expResult = 1;
        int result = instance.compareTo(otherCard);
        assertEquals(expResult, result);
    }
}
