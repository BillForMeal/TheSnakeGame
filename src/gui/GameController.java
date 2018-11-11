package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/* *****************************************
 * * CSCI205 - Software Engineering and Design
 * * Fall 2018
 * *
 * * Name: Matt McLaughlin
 * * Date: Nov 9, 2018
 * * Time: 6:09:13 PM
 * *
 * * Project: csci205
 * * Package:
 * * File: GameController
 * * Description:
 * *
 * * ****************************************
 *  */
/**
 *  *
 *   * @author mpm022
 *
 */
public class GameController {//implements EventHandler<ActionEvent>{

    private GameView theView;
    private GameModel theModel;

    public GameController(GameView theView, GameModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        VBox rootNode = theView.getRootNode();
        Label keyPressed = theView.getLbl();
        rootNode.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                keyPressed.setText("Key Pressed: " + ke.getCode());
            }
        });
    }

    //on the game map, set up keyboard event handler
    //out of map, use removeEventHandler()
}
