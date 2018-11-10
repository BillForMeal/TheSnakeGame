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

    private Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(rows), random.nextInt(cols));
        } while (point.equals(snake.getHead()));
        return point;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getFood() {
        return food;
    }
}
