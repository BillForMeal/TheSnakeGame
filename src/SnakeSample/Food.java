/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 8, 2018
* Time: 7:43:50 PM
*
* Project: csci205FinalProject
* Package: SnakeSample
* File: Food
* Description:
*
* ****************************************
 */
package SnakeSample;

import javafx.scene.paint.Color;

/**
 * A simple class to represent food that takes up only one square.
 *
 * @author Subhomoy Haldar
 * @version 2016.12.17
 */
public class Food {

    public static final Color COLOR = Color.ROSYBROWN;

    private Point point;

    Food(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
