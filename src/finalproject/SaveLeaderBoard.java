/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 28, 2018
* Time: 12:33:14 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: SaveLeaderBoard
* Description:
*
* ****************************************
 */
package finalproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author yz010
 */
public class SaveLeaderBoard {

    public static void serilazation(LeaderBoard board, String fileName) throws IOException {

        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        // Method for serialization of object
        out.writeObject(board);

        out.close();
        file.close();
    }

    /**
     * read the leaderboard stored in a csv file
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static LeaderBoard deserilazation(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        LeaderBoard board = new LeaderBoard();
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);

        board = (LeaderBoard) in.readObject();

        in.close();
        file.close();

        return board;
    }
}
