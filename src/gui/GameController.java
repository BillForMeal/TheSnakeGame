package gui;

import finalproject.Snake;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
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
    private Snake theSnake;
    private SnakeTask theTask;

    public GameController(GameView theView, GameModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theSnake = theModel.getSnake();

        VBox rootNode = theView.getRootNode();
        Label keyPressed = theView.getLbl();
        rootNode.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.W)) {
                    theSnake.setDirection("up");
                }
                if (ke.getCode().equals(KeyCode.A)) {
                    theSnake.setDirection("left");
                }
                if (ke.getCode().equals(KeyCode.S)) {
                    theSnake.setDirection("down");
                }
                if (ke.getCode().equals(KeyCode.D)) {
                    theSnake.setDirection("right");
                }

                //keyPressed.setText("Key Pressed: " + ke.getCode());
            }
        });
    }

    private void UpdateGui(int score, Snake theSnake) {
        this.theView.getGrid().clearGrid();
        this.theView.getGrid().addSnake(theSnake);
        this.theView.getGrid().paintSnake();
    }

    //on the game map, set up keyboard event handler
    //out of map, use removeEventHandler()
    class SnakeTask extends Task<Integer> {

        private int score;
        private GameView theView;
        private GameModel theModel;
        private Snake theSnake;

        public SnakeTask(GameView theView, GameModel theModel) {
            this.theView = theView;
            this.theModel = theModel;
            this.score = 0;
            this.theSnake = theModel.getSnake();
        }

        @Override
        protected Integer call() throws Exception {
            while (this.theSnake.getDie() != true) {
                theSnake.move();
                score = theSnake.getSnake().size();
                Thread.sleep(theSnake.getSpeed());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        GameController.this.UpdateGui(score, theSnake);
                    }
                });
            }
            return score;
        }

        public void changeDirection(String direction) {
            theSnake.setDirection(direction);
        }

    }

}
