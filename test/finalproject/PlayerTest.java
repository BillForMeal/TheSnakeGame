/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 29, 2018
* Time: 5:23:07 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: PlayerTest
* Description:
*
* ****************************************
 */
package finalproject;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yc013
 */
public class PlayerTest {

    public PlayerTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class Player.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Player other = new Player("was", 100, "--");
        Player better = new Player("is", 1000, "--");
        int expResult = -1;
        int result = better.compareTo(other);
        assertEquals(expResult, result);

    }

}
