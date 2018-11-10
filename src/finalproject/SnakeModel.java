/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 9, 2018
* Time: 12:20:46 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: SnakeModel
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
public class SnakeModel {

    private Point head;
    private ArrayList<Point> snake;
    private String direction;
    private int length;
    private boolean isDead;
    private Point food;

    SnakeModel(int x, int y) {
        this.head = new Point(x, y);
        this.snake = new ArrayList<>();
        snake.add(head);
        this.direction = "up";
        this.length = snake.size();
        this.isDead = false;
    }

    public boolean eat() {
        return head == food;
    }

    /**
     * move the snake up, add 1 to y coordinate
     */
    public void moveUp() {
        Point newHead = new Point(head.getX(), head.getY() + 1);
        this.head = newHead;
        snake.add(0, newHead);
        if (!this.eat()) {
            snake.remove(length);
        }
        this.direction = "up";
        this.die();
    }

    public void moveDown() {
        Point newHead = new Point(head.getX(), head.getY() - 1);
        this.head = newHead;
        snake.add(0, newHead);
        if (!this.eat()) {
            snake.remove(length);
        }
        this.direction = "down";
        this.die();
    }

    public void moveLeft() {
        Point newHead = new Point(head.getX() - 1, head.getY());
        this.head = newHead;
        snake.add(0, newHead);
        if (!this.eat()) {
            snake.remove(length);
        }
        this.direction = "left";
        this.die();
    }

    public void moveRight() {
        Point newHead = new Point(head.getX() + 1, head.getY());
        this.head = newHead;
        snake.add(0, newHead);
        if (!this.eat()) {
            snake.remove(length);
        }
        this.direction = "right";
        this.die();
    }

    public void setFood(Point food) {
        this.food = food;
    }

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
     * @return
     */
    public ArrayList<Point> getSnake() {
        return snake;
    }

    public String getDirection() {
        return direction;
    }

    public boolean getDie() {
        return isDead;
    }

    public Point getHead() {
        return head;
    }
}
