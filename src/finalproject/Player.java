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
public class Player implements Comparable<Player> {

    private String name;
    private int score;
    private int rank;
    private String date;

    public Player(String name, int score, String date) {
        this.name = name;
        this.score = score;
        this.date = date;
    }

    /**
     * set the rank of the player
     *
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * get the name of the player
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * get the score of the player
     *
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * get the rank of the player
     *
     * @return int
     */
    public int getRank() {
        return rank;
    }

    /**
     * get the date of finish the game
     *
     * @return string
     */
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        String player = Integer.toString(rank) + " " + name + " " + "score: " + Integer.toString(
                score) + " " + date;
        return player;
    }

    @Override
    public int compareTo(Player other) {
        if (this.score > other.getScore()) {
            return 1;
        }
        if (this.score < other.getScore()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
