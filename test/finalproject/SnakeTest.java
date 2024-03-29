/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 11, 2018
* Time: 4:21:26 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: SnakeTest
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
public class SnakeTest {

    Snake theSnake;
    Point move;

    public SnakeTest() {
    }

    @Before
    public void setUp() {
        theSnake = new Snake(0, 0);
        theSnake.setMapSize(20);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of eat method, of class Snake.
     */
    @Test
    public void testEat() {
        System.out.println("eat");
        theSnake.moveDown();
        Point food = new Point(0, -1);
        theSnake.setFood(food);
        boolean expResult = false;
        boolean result = theSnake.eat();
        assertEquals(expResult, result);

    }

    /**
     * Test of moveDown method, of class Snake.
     */
    @Test
    public void testMoveUp() {
        System.out.println("moveUp");
        theSnake.moveUp();
        move = new Point(0, 1);
        assertEquals(move, theSnake.getHead());
    }

    /**
     * Test of setFood method, of class Snake.
     */
    @Test
    public void testSetFood() {
        System.out.println("setFood");
        Point food = new Point(0, 4);
        theSnake.setFood(food);
        assertEquals(food, theSnake.getFood());

    }

    /**
     * Test of die method, of class Snake.
     */
    @Test
    public void testDie() {
        System.out.println("die");

        Point food = new Point(0, 1);
        theSnake.setFood(food);
        theSnake.moveUp();
        Point food1 = new Point(1, 1);
        theSnake.setFood(food1);
        theSnake.moveRight();
        Point food2 = new Point(1, 0);
        theSnake.setFood(food2);
        theSnake.moveDown();
        Point food3 = new Point(0, 0);
        theSnake.setFood(food3);
        theSnake.moveLeft();

        assertEquals(theSnake.getDie(), true);
    }

    /**
     * Test of snake growth
     */
    @Test
    public void testGrow() {
        System.out.println("grow");
        Point food = new Point(0, 1);
        theSnake.setFood(food);
        theSnake.moveUp();
        assertEquals(theSnake.getLength(), 2);
    }

    /**
     * Test of killSnake method, of class Snake.
     */
    @Test
    public void testKillSnake() {
        System.out.println("killSnake");
        Snake instance = null;
        theSnake.killSnake();
        assertEquals(theSnake.getDie(), true);
    }

}
