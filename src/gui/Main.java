/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 5, 2018
* Time: 12:09:45 PM
*
* Project: csci205FinalProject
* Package: gui
* File: Main
* Description:
*
* ****************************************
 */
package gui;

import javafx.application.Application;
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
 * @author dll022
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Text gameTitle = new Text("Jörmungandr");
        gameTitle.setFont(Font.font("", FontWeight.SEMI_BOLD, 75));

        Button play = new Button();
        play.setText("Play");
        play.setMinSize(90, 65);
        play.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button options = new Button();
        options.setText("Options");
        options.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button ldrBoard = new Button();
        ldrBoard.setText("Leaderboard");
        ldrBoard.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(gameTitle, play, options, ldrBoard);

        Scene scene = new Scene(root, 600, 550);

        primaryStage.setTitle("Jörmungandr");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
