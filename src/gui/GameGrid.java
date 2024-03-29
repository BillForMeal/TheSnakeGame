package gui;

import finalproject.Point;
import finalproject.Snake;
import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Matt McLaughlin
* Date: Nov 9, 2018
* Time: 12:29:44 PM
*
* Project: csci205
* Package:
* File: GameGrid
* Description:
*
* ****************************************
 */
/**
 *
 * @author mpm022
 */
public class GameGrid {

    private Pane p;
    private Rectangle[][] rec;
    private Snake theSnake;
    private int mapSize;
    private boolean isFood;
    private Point food;

    public GameGrid(int mapSize, int squareWidth) {
        this.mapSize = mapSize;
        this.p = new Pane();
        this.rec = new Rectangle[mapSize][mapSize];
        p = makeGrid(this.mapSize, p, rec, squareWidth);
        isFood = false;
    }

    public void addSnake(Snake snake) {
        this.theSnake = snake;
        Point head = theSnake.getHead();
        if (theSnake.getHead().equals(food)) {
            isFood = false;
            food = null;
        }
    }

    public Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(mapSize), random.nextInt(mapSize));
        } while (theSnake.getSnake().indexOf(point) != -1);
        return point;
    }

    public void generateFood() {
        if (isFood == false) {
            food = this.getRandomPoint();
            theSnake.setFood(food);
            isFood = true;
        }
    }

    /**
     * Make the grid
     *
     * @param n
     * @param pain
     * @param width
     * @return the Pane pain
     */
    public static Pane makeGrid(int n, Pane pain, Rectangle[][] rec, int width) {

        //double width = 10;//GridMaker.SCREEN_SIZE / n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rec[i][j] = new Rectangle();
                rec[i][j].setX(i * width);
                rec[i][j].setY(j * width);
                rec[i][j].setWidth(width);
                rec[i][j].setHeight(width);
                rec[i][j].setFill(null);
                //rec[i][j].setStroke(Paint.valueOf("BLACK"));
                pain.getChildren().add(rec[i][j]);

            }
        }
        return pain;
    }

    //This works, but we need to add exceptionOutOfBounds handling
    public void setColor(int i, int j, String color) {
        this.rec[i][j].setFill(Paint.valueOf(color));
    }

    public void paintSnake() {
        for (Point p : theSnake.getSnake()) {
            this.rec[p.getX()][p.getY()].setFill(Paint.valueOf("RED"));
        }

    }

    public void clearGrid() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                rec[i][j].setFill(Paint.valueOf("LIGHTBLUE"));
            }
        }
    }

    public void paintFood() {
        rec[food.getX()][food.getY()].setFill(Paint.valueOf("GREEN"));
    }

    public void setIsFood(boolean isFood) {
        this.isFood = isFood;
    }

    public Pane getPane() {
        return p;
    }

    public int getsize() {
        return mapSize;
    }

    public Snake getTheSnake() {
        return theSnake;
    }

    public boolean EasterEgg() {
        int x = 0;
        for (int i = 0; i <= mapSize - 1; i++) {
            Point testPoint = new Point(i, 0);
            if (theSnake.getSnake().indexOf(testPoint) != -1) {// the testpoint is on the sanke
                x += 1;
            }
        }
        for (int i = 0; i <= mapSize - 1; i++) {
            Point testPoint = new Point(i, mapSize - 1);
            if (theSnake.getSnake().indexOf(testPoint) != -1) {// the testpoint is on the sanke
                x += 1;
            }
        }
        for (int i = 0; i <= mapSize - 1; i++) {
            Point testPoint = new Point(0, i);
            if (theSnake.getSnake().indexOf(testPoint) != -1) {// the testpoint is on the sanke
                x += 1;
            }
        }
        for (int i = 0; i <= mapSize - 1; i++) {
            Point testPoint = new Point(mapSize - 1, i);
            if (theSnake.getSnake().indexOf(testPoint) != -1) {// the testpoint is on the sanke
                x += 1;
            }
        }
        return x == mapSize * 4;
    }

}
