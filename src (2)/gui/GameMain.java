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
* File: GameMain
* Description:
*
* ****************************************
 */
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dll022
 */
public class GameMain extends Application {

    private GameController theCtrl;
    private GameView theView;
    private GameModel theModel;

    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new GameModel();
        this.theView = new GameView(theModel);
        this.theCtrl = new GameController(theView, theModel);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(this.theView.getRootNode(), 800, 900);

        //Key press event handler, later move to controller
        /*
        Label keyPressed = new Label();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                keyPressed.setText("Key Pressed: " + ke.getCode());
            }
        });
         */
        primaryStage.setTitle("Jörmungandr");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
