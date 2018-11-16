/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 16, 2018
* Time: 12:06:37 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: Player
* Description:
*
* ****************************************
 */
package finalproject;

/**
 *
 * @author yz010
 */
public class Player {

    private String name;
    private int score;
    private int rank;
    private String date;

    public Player(String name, int score, String date) {
        this.name = name;
        this.score = score;
        this.date = date;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        String player = Integer.toString(rank) + " " + name + " " + "score: " + Integer.toString(
                score) + " " + date;
        return player;
    }

}
