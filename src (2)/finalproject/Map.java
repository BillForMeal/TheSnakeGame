/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 10, 2018
* Time: 2:30:40 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: Map
* Description:
*
* ****************************************
 */
package finalproject;

import java.util.Random;

/**
 *
 * @author yz010
 */
public class Map {

    private Snake snake;
    private Point food;

    private int rows;
    private int cols;

    public static final int SIZE = 10;

    public Map(final double width, final double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;

        // initialize the snake at the centre of the screen
        snake = new Snake(rows / 2, cols / 2);

        // put the food at a random location
        food = this.getRandomPoint();
    }

    /**
     * get a random point
     *
     * @return point
     */
    public Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(rows), random.nextInt(cols));
        } while (point.equals(snake.getHead()));
        return point;
    }

    /**
     * get the # of columns of the map
     *
     * @return cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * get the # of rows of the map
     *
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * get the width of the map
     *
     * @return width
     */
    public double getWidth() {
        return rows * SIZE;
    }

    /**
     * get the height of the map
     *
     * @return height
     */
    public double getHeight() {
        return cols * SIZE;
    }

    /**
     * get the snake
     *
     * @return snake
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * get the food position
     *
     * @return food
     */
    public Point getFood() {
        return food;
    }
}
