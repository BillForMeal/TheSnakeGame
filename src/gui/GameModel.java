/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 9, 2018
* Time: 6:13:15 PM
*
* Project: csci205FinalProject
* Package: gui
* File: GameModel
* Description:
*
* ****************************************
 */
package gui;

import finalproject.Snake;

/**
 *
 * @author mpm022
 */
public class GameModel {

    private Snake theSnake;

    GameModel() {
        this.theSnake = new Snake(0, 0);
    }

    public Snake getSnake() {
        return theSnake;
    }
}
