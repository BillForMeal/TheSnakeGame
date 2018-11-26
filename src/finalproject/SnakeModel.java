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

/**
 *
 * @author yz010
 */
public class SnakeModel {

    private Snake theSnake;

    SnakeModel(int x, int y) {
        this.theSnake = new Snake(x, y);
    }

    public Snake getSnake() {
        return theSnake;
    }

    /*public boolean eat() {
        return head == food;
    }

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
    }*/
}
