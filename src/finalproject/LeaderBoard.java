/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 16, 2018
* Time: 12:06:26 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: LeaderBoard
* Description:
*
* ****************************************
 */
package finalproject;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author yz010
 */
public class LeaderBoard implements java.io.Serializable {

    private ArrayList<Player> board;
    public final static int TOP = 10;

    public LeaderBoard() {
        this.board = new ArrayList<Player>();
    }
    //need another method that reads a existing board, use Serializable
    //to deserilaze, use: LeaderBoard = CopyNSave.deserilazation(filename);

    public void sortBoard() {
        for (Player p : board) {
            p.setRank(board.indexOf(p) + 1);
        }
        Collections.sort(board);
    }

    /**
     * add a new player to the board, remove the players that has a rank more
     * than TOP value
     *
     * @param player
     */
    public void addNewPlayer(Player player) {
        board.add(player);
        this.sortBoard();
        while (board.size() > TOP) {
            board.remove(board.size());
        }
    }

    /**
     * get the list of all players
     *
     * @return ArrayList
     */
    public ArrayList<Player> getBoard() {
        return board;
    }

    /**
     * change the ArrayList of players to a string, each player is a line
     *
     * @return String
     */
    @Override
    public String toString() {
        String leaderboard = "";
        for (Player p : board) {
            leaderboard = leaderboard + p.toString() + "\n";
        }
        return leaderboard;
    }

}
