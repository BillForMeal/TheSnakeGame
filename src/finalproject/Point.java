/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 9, 2018
* Time: 12:19:58 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: Coordinates
* Description:
*
* ****************************************
 */
package finalproject;

/**
 *
 * @author yz010
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point)) {
            return false;
        }
        Point point = (Point) other;
        return x == point.getX() && y == point.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
