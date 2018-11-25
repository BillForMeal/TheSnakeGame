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

import finalproject.LeaderBoard;
import finalproject.Snake;

/**
 *
 * @author mpm022
 */
public class GameModel {

    private Snake theSnake;
    private LeaderBoard leaderboard;

    GameModel() {
        this.theSnake = new Snake(0, 0);
        this.leaderboard = new LeaderBoard();
    }

    public Snake getSnake() {
        return theSnake;
    }

    public LeaderBoard getLeaderboard() {
        return leaderboard;
    }

    public void refreshModel() {
        int speed = this.theSnake.getSpeed();
        this.theSnake = new Snake(0, 0);
        this.theSnake.setSPEED(speed);
    }
}
