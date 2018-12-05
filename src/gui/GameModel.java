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
import finalproject.SaveLeaderBoard;
import finalproject.Snake;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author mpm022
 */
public class GameModel {

    private Snake theSnake;
    private LeaderBoard leaderboard;

    GameModel() throws IOException, ClassNotFoundException {
        this.theSnake = new Snake(0, 0);
        try {
            leaderboard = SaveLeaderBoard.deserilazation("board.csv");
        } catch (FileNotFoundException f) {
            this.leaderboard = new LeaderBoard();
        }
    }

    public Snake getSnake() {
        return theSnake;
    }

    public LeaderBoard getLeaderboard() {
        return leaderboard;
    }

    /**
     * Refresh the game model
     */
    public void refreshModel() {
        int speed = this.theSnake.getSpeed();
        this.theSnake = new Snake(0, 0);
        this.theSnake.setSPEED(speed);
    }
}
