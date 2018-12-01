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
* File: PointTest
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
public class PointTest {

    public PointTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of outOfMap method, of class Point.
     */
    @Test
    public void testOutOfMap() {
        System.out.println("outOfMap");
        int mapSize = 200;
        Point instance = new Point(0, 0);
        boolean expResult = false;
        boolean result = instance.outOfMap(mapSize);
        assertEquals(expResult, result);
    }

}
