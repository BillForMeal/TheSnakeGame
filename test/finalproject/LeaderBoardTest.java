/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 29, 2018
* Time: 5:23:08 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: LeaderBoardTest
* Description:
*
* ****************************************
 */
package finalproject;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yc013
 */
public class LeaderBoardTest {

    public LeaderBoardTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sortBoard method, of class LeaderBoard.
     */
    @Test
    public void testSortBoard() {
        System.out.println("sortBoard");
        LeaderBoard instance = new LeaderBoard();
        instance.sortBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewPlayer method, of class LeaderBoard.
     */
    @Test
    public void testAddNewPlayer() {
        System.out.println("addNewPlayer");
        Player player = null;
        LeaderBoard instance = new LeaderBoard();
        instance.addNewPlayer(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastPlayer method, of class LeaderBoard.
     */
    @Test
    public void testGetLastPlayer() {
        System.out.println("getLastPlayer");
        LeaderBoard instance = new LeaderBoard();
        int expResult = 0;
        int result = instance.getLastPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class LeaderBoard.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        LeaderBoard instance = new LeaderBoard();
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LeaderBoard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LeaderBoard instance = new LeaderBoard();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
