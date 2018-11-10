package gui;

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

    public GameGrid(int numSquares, int width) {
        this.p = new Pane();
        this.rec = new Rectangle[numSquares][numSquares];
        p = makeGrid(numSquares, p, rec, width);
    }

    /**
     *
     * @param n
     * @param pain
     * @param n
     * @return
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
                rec[i][j].setStroke(Paint.valueOf("BLACK"));
                pain.getChildren().add(rec[i][j]);

            }
        }
        return pain;
        /*
        pain.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me
            ) {
                double posX = me.getX();
                double posY = me.getY();

                int colX = (int) (posX / width);
                int colY = (int) (posY / width);

                rec[colX][colY].setFill(Color.RED);
            }
        }
        );
    }
         */

    }

    //This works, but we need to add exceptionOutOfBounds handling
    public void setColor(int i, int j, String color) {
        this.rec[i][j].setFill(Paint.valueOf(color));
    }

    public Pane getP() {
        return p;
    }

}
