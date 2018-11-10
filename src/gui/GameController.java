package gui;

/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: Matt McLaughlin
* Date: Nov 9, 2018
* Time: 6:09:13 PM
*
* Project: csci205
* Package:
* File: GameController
* Description:
*
* ****************************************
 */
/**
 *
 * @author mpm022
 */
public class GameController {//implements EventHandler<ActionEvent>{

    private GameView theView;
    private GameModel theModel;

    public GameController(GameView theView, GameModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
    }

}
