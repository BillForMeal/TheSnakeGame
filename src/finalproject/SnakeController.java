/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: NAMES of team members
* Date: Nov 10, 2018
* Time: 2:49:20 PM
*
* Project: csci205FinalProject
* Package: finalproject
* File: SnakeController
* Description:
*
* ****************************************
 */
package finalproject;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author yz010
 */
public class SnakeController implements EventHandler<ActionEvent> {

    private SnakeView theView;
    private SnakeModel theModel;
    private SnakeTask Player1Snake;

    public SnakeController(SnakeView theView, SnakeModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

    }

    private void UpdateGui(int score, Snake theSnake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class SnakeTask extends Task<Integer> {

        private int score;
        private SnakeView theView;
        private SnakeModel theModel;
        private Snake theSnake;

        public SnakeTask(SnakeView theView, SnakeModel theModel) {
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
                        SnakeController.this.UpdateGui(score, theSnake);
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
