/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 25, 2018
* Time: 4:29:59 PM
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
        CreateEmptyBoard();
    }
    //need another method that reads a existing board, use Serializable
    //to deserilaze, use: LeaderBoard = CopyNSave.deserilazation(filename);

    private void CreateEmptyBoard() {
        for (int i = 0; i < TOP; i++) {
            String name = "Player " + Integer.toString(i);
            board.add(new Player(name, 0, "--"));
        }
    }

    public void sortBoard() {
        Collections.sort(board);
        for (Player p : board) {
            p.setRank(board.indexOf(p) + 1);
        }
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
        if (board.size() > TOP) {
            board.remove(TOP);
        }
    }

    /**
     * get the lowest score in the leader board
     *
     * @return int
     */
    public int getLastPlayer() {
        return board.get(TOP).getScore();
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
        this.sortBoard();
        String leaderboard = "";
        for (Player p : board) {
            leaderboard = leaderboard + p.toString() + "\n";
        }
        return leaderboard;
    }
}
