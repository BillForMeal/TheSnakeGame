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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

    public GameView(GameModel theModel) {

        this.theModel = theModel;

        //grid = new GameGrid(10);
        gameTitle = new Text("Jörmungandr");

        gameTitle.setFont(Font.font("", FontWeight.SEMI_BOLD, 75));

        playBtn = new Button();

        playBtn.setText("Play");
        playBtn.setMinSize(90, 65);
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VBox gameNode = new VBox();
                grid = new GameGrid(10, 50);
                grid.setColor(2, 2, "Black");

                Scene gameScene = new Scene(gameNode, 400, 400);

                Stage gameStage = new Stage();
                gameStage.setTitle("Jörmungandr");
                gameStage.setScene(gameScene);
                gameStage.sizeToScene();
                gameNode.getChildren().add(grid.getP());
                gameStage.show();

            }

        });

        optionsBtn = new Button();

        optionsBtn.setText("Options");
        optionsBtn.setOnAction(
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event
            ) {
                VBox optionsNode = new VBox();
                grid = new GameGrid(10, 50);
                grid.setColor(2, 2, "Black");

                Scene goptionsScene = new Scene(optionsNode, 400, 400);

                Stage optionsStage = new Stage();
                optionsStage.setTitle("Options Menu");
                optionsStage.setScene(gameScene);
                optionsStage.sizeToScene();
                optionsNode.getChildren().add(grid.getP());
                optionsStage.show();

            }
        });

        ldrBoardBtn = new Button();

        ldrBoardBtn.setText(
                "Leaderboard");
        ldrBoardBtn.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
            }
        }
        );

        rootNode = new VBox();

        rootNode.setAlignment(Pos.CENTER);

        rootNode.setSpacing(20);

        rootNode.getChildren().addAll(gameTitle, playBtn, optionsBtn,
                                      ldrBoardBtn);

        //if press start
        //then switch to grid
        //model starts game
        //rootNode.getChildren().add(grid.getP()); //this should not be in the final
    }

    public VBox getRootNode() {
        return rootNode;
    }

}
