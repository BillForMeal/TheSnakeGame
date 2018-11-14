/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 9, 2018
* Time: 6:13:02 PM
*
* Project: csci205FinalProject
* Package: gui
* File: GameView
* Description:
*
* ****************************************
 */
package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author mpm022
 */
public class GameView {

    private GameModel theModel;
    private Text gameTitle;
    private Button playBtn;
    private Button optionsBtn;
    private Button ldrBoardBtn;
    private VBox rootNode;
    private GameGrid grid;
    private Button backBtn;
    private Label lbl;

    private Text howTo;

    public GameView(GameModel theModel) {

        this.theModel = theModel;
        gameTitle = new Text("Jörmungandr");
        gameTitle.setFont(Font.font("", FontWeight.SEMI_BOLD, 75));

        howTo = new Text("Welcome to Jormungandr!\n"
                         + "Press Play to begin your game.\n"
                         + "Use the w-a-s-d keys to move the snake up-left-down-right.\n"
                         + "You can return to the Main Menu at any time, but that will end your game as if the snake had died.\n"
                         + "Press Options to view the Options Menu. You are offered a variety of choices that will effect your gameplay.\n"
                         + "Press Leaderboard to see the all-time high scorers list on your system.\n"
                         + "We hope you enjoy your game!\n"
                         + "- Team Jormungandr");

        playBtn = new Button();
        playBtn.setText("Play");
        playBtn.setMinSize(90, 65);

        backBtn = new Button();
        backBtn.setText("Back to Main Menu");
        backBtn.setMinSize(80, 40);

        // Options button
        optionsBtn = new Button();
        optionsBtn.setText("Options");

        // Leaderboard button
        ldrBoardBtn = new Button();
        ldrBoardBtn.setText("Leaderboard");

        //initial main menu set up
        rootNode = new VBox();
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setSpacing(20);
        rootNode.getChildren().addAll(gameTitle, howTo, playBtn, optionsBtn,
                                      ldrBoardBtn);

    }

    public VBox getRootNode() {
        return rootNode;
    }

    public Label getLbl() {
        return lbl;
    }

    public GameGrid getGrid() {
        return grid;
    }

    public Button getPlayBtn() {
        return playBtn;
    }

    public GameModel getTheModel() {
        return theModel;
    }

    public Text getGameTitle() {
        return gameTitle;
    }

    public Button getOptionsBtn() {
        return optionsBtn;
    }

    public Button getLdrBoardBtn() {
        return ldrBoardBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public Text getHowTo() {
        return howTo;
    }

}
