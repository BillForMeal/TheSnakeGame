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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public GameView(GameModel theModel) {

        this.theModel = theModel;
        gameTitle = new Text("Jörmungandr");
        gameTitle.setFont(Font.font("", FontWeight.SEMI_BOLD, 75));
        playBtn = new Button();
        playBtn.setText("Play");
        playBtn.setMinSize(90, 65);

        backBtn = new Button();
        backBtn.setText("Back to Main Menu");
        backBtn.setMinSize(80, 40);

        //
        // Play button and Handler
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                grid = new GameGrid(50, 15);
                grid.setColor(2, 2, "Black");

                rootNode.getChildren().clear();
                rootNode.getChildren().add(backBtn);
                backBtn.setAlignment(Pos.TOP_LEFT);
                rootNode.getChildren().add(grid.getPane());

            }

        });

        //
        // Options button and handler
        optionsBtn = new Button();
        optionsBtn.setText("Options");
        optionsBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event
            ) {

                Label optionsTxt = new Label("Options go here!");
                rootNode.getChildren().clear();
                rootNode.getChildren().add(backBtn);
                backBtn.setAlignment(Pos.TOP_LEFT);
                rootNode.getChildren().add(optionsTxt);

            }
        });

        //
        // Leaderboard button and handler
        ldrBoardBtn = new Button();
        ldrBoardBtn.setText(
                "Leaderboard");
        ldrBoardBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {

                Label ldrBoardTxt = new Label("Leaderboard goes here!");
                rootNode.getChildren().clear();
                rootNode.getChildren().add(backBtn);
                backBtn.setAlignment(Pos.TOP_LEFT);
                rootNode.getChildren().add(ldrBoardTxt);
            }
        }
        );

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                rootNode.getChildren().clear();
                rootNode.setAlignment(Pos.CENTER);
                rootNode.setSpacing(20);
                rootNode.getChildren().addAll(gameTitle, playBtn, optionsBtn,
                                              ldrBoardBtn);
            }
        }
        );

        //initial main menu set up
        rootNode = new VBox();
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setSpacing(20);
        rootNode.getChildren().addAll(gameTitle, playBtn, optionsBtn,
                                      ldrBoardBtn);

        //if press start
        //then switch to grid
        //model starts game
        //rootNode.getChildren().add(grid.getPane()); //this should not be in the final
    }

    public VBox getRootNode() {
        return rootNode;
    }

}
