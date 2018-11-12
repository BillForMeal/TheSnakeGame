/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 8, 2018
* Time: 7:39:16 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: Snake
* Description:
*
* ****************************************
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author yz010
 */
public class Snake {

    private Point head;
    private ArrayList<Point> snake;
    private String direction;
    private int length;
    private boolean isDead;
    private Point food;

    public static final int SPEED = 100;

    public Snake(int x, int y) {
        this.head = new Point(x, y);
        this.snake = new ArrayList<>();
        snake.add(head);
        this.direction = "up";
        this.length = snake.size();
        this.isDead = false;
    }

    /**
     * the snake eats the food or not
     *
     * @return eat
     */
    public boolean eat() {
        boolean eaten = false;
        eaten = head.equals(food);
        if (eaten == true) {
            food = null;
        }
        return eaten;
    }

    /**
     * move the snake according to the current direction.
     */
    public void move() {
        if ("up".equals(direction)) {
            this.moveUp();
        }
        if ("down".equals(direction)) {
            this.moveDown();
        }
        if ("left".equals(direction)) {
            this.moveLeft();
        }
        if ("right".equals(direction)) {
            this.moveRight();
        }
    }

    /**
     * move the snake up, add 1 to y coordinate.
     */
    public void moveUp() {
        Point newHead = new Point(head.getX(), head.getY() + 1);
        this.head = newHead;
        snake.add(0, newHead);
        if (this.eat() == false) {
            snake.remove(length);
        }
        this.length = this.snake.size();
        this.direction = "up";
        this.die();
    }

    /**
     * move the snake up, minus 1 to y coordinate.
     */
    public void moveDown() {
        Point newHead = new Point(head.getX(), head.getY() - 1);
        this.head = newHead;
        snake.add(0, newHead);
        if (this.eat() == false) {
            snake.remove(length);
        }
        this.length = this.snake.size();
        this.direction = "down";
        this.die();
    }

    /**
     * move the snake up, minus 1 to x coordinate.
     */
    public void moveLeft() {
        Point newHead = new Point(head.getX() - 1, head.getY());
        this.head = newHead;
        snake.add(0, newHead);
        if (this.eat() == false) {
            snake.remove(length);
        }
        this.length = this.snake.size();
        this.direction = "left";
        this.die();
    }

    /**
     * move the snake up, add 1 to x coordinate.
     */
    public void moveRight() {
        Point newHead = new Point(head.getX() + 1, head.getY());
        this.head = newHead;
        snake.add(0, newHead);
        if (this.eat() == false) {
            snake.remove(length);
        }
        this.length = this.snake.size();
        this.direction = "right";
        this.die();
    }

    /**
     * set the food at the given point
     *
     * @param food
     */
    public void setFood(Point food) {
        this.food = food;
    }

    /**
     * set the direction of the snake
     *
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * kill the snake if it touches itself.
     */
    public void die() {
        ArrayList<Point> body = new ArrayList<>();
        for (int i = 1; i < snake.size(); i++) {
            body.add(snake.get(i));
        }
        if (body.indexOf(head) != -1) {
            this.isDead = true;
        }
    }

    /**
     * get the ArrayList of points represent the snake
     *
     * @return snake
     */
    public ArrayList<Point> getSnake() {
        return snake;
    }

    /**
     * get the direction of the snake
     *
     * @return direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * get the snake is die or not
     *
     * @return isDead
     */
    public boolean getDie() {
        return isDead;
    }

    /**
     * get the position of the head of the snake
     *
     * @return head
     */
    public Point getHead() {
        return head;
    }

    /**
     * get the speed of the snake(time of move one unit in milliseconds)
     *
     * @return speed
     */
    public int getSpeed() {
        return SPEED;
    }

    /**
     * get the length of the snake
     *
     * @return isDead
     */
    public int getLength() {
        return length;
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
