
import finalproject.LeaderBoard;
import finalproject.Player;
import finalproject.Snake;
import gui.GameGrid;
import gui.GameModel;
import gui.GameView;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;

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
public class GameController implements EventHandler<ActionEvent> {

    private GameView theView;
    private GameModel theModel;
    private SnakeTask theTask;
    private GameGrid grid;
    private Thread th;
    private boolean gamemode;

    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    public GameController(GameView theView, GameModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        grid = new GameGrid(40, 15);
        gamemode = false;

        BorderPane rootNode = theView.getRootNode();
        this.theView.getPlayBtn().setOnAction(this);
        this.theView.getOptionsBtn().setOnAction(this);
        this.theView.getLdrBoardBtn().setOnAction(this);
        this.theView.getBackBtn().setOnAction(this);
        this.theView.getGameBackBtn().setOnAction(this);

        rootNode.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.W) && theModel.getSnake().getDirection() != "up") {
                    theModel.getSnake().setDirection("down");
                }
                if (ke.getCode().equals(KeyCode.A) && theModel.getSnake().getDirection() != "right") {
                    theModel.getSnake().setDirection("left");
                }
                if (ke.getCode().equals(KeyCode.S) && theModel.getSnake().getDirection() != "down") {
                    theModel.getSnake().setDirection("up");
                }
                if (ke.getCode().equals(KeyCode.D) && theModel.getSnake().getDirection() != "left") {
                    theModel.getSnake().setDirection("right");
                }
                if (theModel.getSnake().getDie() == true) {
                    JOptionPane.showMessageDialog(null,
                                                  "Please press the Back to Main Menu button");
                }

            }
        });

    }

    //Yuxuan's all-in-one event handler
    public void handle(ActionEvent event) {
        try {
            int x = 1;//

            Object source = event.getSource();
            if (source == theView.getPlayBtn()) {
                gameWindow();
            }
            if (source == theView.getOptionsBtn()) {
                /*
                gamemode = false;
                theView.makeOptionsMenu();
                 */
                options();
            }
            if (source == theView.getLdrBoardBtn()) {
                leaderBoard();
            }
            if (source == theView.getBackBtn()) {
                backToMain();
            }

            if (theView.getGameBackBtn() == source) {
                Date date = new Date();
                int score = theTask.getScore();
                int lowScore = theTask.getLowScore();
                theTask.cancel();
                if (score > lowScore) {
                    String name = JOptionPane.showInputDialog(null,
                                                              "What's your name?");
                    Player newHighScore = new Player(name, score,
                                                     empDateFormat.format(
                                                             date));
                    theModel.getLeaderboard().addNewPlayer(newHighScore);

                }
                backToMain();
            }
        } catch (Exception ex) {
        }

    }

    private void leaderBoard() {
        gamemode = false;
        Label ldrBoardTxt = new Label("Leaderboard goes here!");
        theView.getRootNode().getChildren().clear();
        theView.getRootNode().getChildren().add(theView.getBackBtn());
        theView.getBackBtn().setAlignment(Pos.TOP_LEFT);
        theView.getRootNode().getChildren().add(ldrBoardTxt);
        LeaderBoard a = theModel.getLeaderboard();
        theView.getLeaderboard().setText(a.toString());
        theView.getRootNode().getChildren().add(theView.getLeaderboard());
    }

    private void options() {
        gamemode = false;
        Label optionsTxt = new Label("Options go here!");
        theView.getRootNode().getChildren().clear();
        theView.getRootNode().getChildren().add(theView.getBackBtn());
        theView.getRootNode().getChildren().add(theView.getBtmapSize());
        theView.getRootNode().getChildren().add(theView.getMapsize());
        theView.getRootNode().getChildren().add(theView.getBtsnakeSpeed());
        theView.getRootNode().getChildren().add(theView.getSpeed());
        theView.getRootNode().getChildren().add(theView.getSet());
        theView.getRootNode().setAlignment(theView.getBackBtn(), Pos.TOP_LEFT);
        theView.getSet().setOnAction(e -> setEverything(theView.getMapsize(),
                                                        theView.getSpeed()));

    }

    private void setEverything(ChoiceBox<String> size, ChoiceBox<String> speed) {
        String Mapsize = size.getValue();
        grid = new GameGrid(Integer.valueOf(Mapsize), 15);
        String SnakeSpeed = speed.getValue();
        if (SnakeSpeed.equals("slow")) {
            theModel.getSnake().setSPEED(150);
        }
        else if (SnakeSpeed.equals("medium")) {
            theModel.getSnake().setSPEED(100);
        }
        else {
            theModel.getSnake().setSPEED(50);
        }
        System.out.println(theModel.getSnake().getSpeed());
    }

    private void gameWindow() {
        theView.getRootNode().getChildren().clear();
        theView.getRootNode().setTop(theView.getGameBackBtn());
        theView.getRootNode().setAlignment(theView.getGameBackBtn(),
                                           Pos.TOP_LEFT);
        theView.getRootNode().getChildren().add(grid.getPane());

        theModel.refreshModel();
        grid.setIsFood(false);
        theTask = new SnakeTask(theView, theModel);
        th = new Thread((Runnable) theTask);
        th.setDaemon(true);
        th.start();
        gamemode = true;
    }

    private void backToMain() {
        theView.getRootNode().getChildren().clear();
        theView.makeMainMenu();
    }

    private void UpdateGui(int score, Snake theSnake) {
        grid.clearGrid();
        grid.addSnake(theSnake);
        grid.paintSnake();
        grid.generateFood();
        grid.paintFood();

        theView.getRootNode().getChildren().clear();
        theView.getRootNode().getChildren().add(theView.getGameBackBtn());
        theView.getRootNode().getChildren().add(theView.getCurrentScore());
        theView.getRootNode().getChildren().add(theView.getScoreShown());
        this.theView.getScoreShown().setText(Integer.toString(score));
        theView.getGameBackBtn().setAlignment(Pos.TOP_LEFT);
        theView.getRootNode().getChildren().add(grid.getPane());
    }

    //on the game map, set up keyboard event handler
    //out of map, use removeEventHandler()
    class SnakeTask extends Task<Integer> {

        private int score;
        private GameView theView;
        private GameModel theModel;
        private Snake theSnake;
        private int lowScore;

        public SnakeTask(GameView theView, GameModel theModel) {
            this.theView = theView;
            this.theModel = theModel;
            this.score = 0;
            this.theSnake = theModel.getSnake();
            theSnake.setMapSize(grid.getsize());
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
            JOptionPane.showMessageDialog(null,
                                          "You Died!\nPlease press the Back to Main Menu button");
            return score;
        }

        public void changeDirection(String direction) {
            theSnake.setDirection(direction);
        }

        public int getScore() {
            return score;
        }

        public int getLowScore() {
            return lowScore;
        }

    }

}
