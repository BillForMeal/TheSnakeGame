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

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
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
    private BorderPane rootNode;
    private GameGrid grid;
    private Button backBtn;
    private Label lbl;
    private Label currentScore;
    private Label scoreShown;
    private Label btmapSize;

    private Label btsnakeSpeed;
    private ChoiceBox<String> mapsize;
    private ChoiceBox<String> speed;
    private Button set;

    private Label leaderboard;

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
        rootNode = new BorderPane();
        makeMainMenu();

        //show scores
        currentScore = new Label("Score:");
        scoreShown = new Label("");
        scoreShown.setMinWidth(75);
        scoreShown.setMinHeight(25);
        scoreShown.setBorder(new Border(new BorderStroke(null,
                                                         BorderStrokeStyle.SOLID,
                                                         new CornerRadii(4),
                                                         BorderWidths.DEFAULT)));

        //option menu
        makeOptionsMenu();

        leaderboard = new Label("");
    }

    //Grunt work for setting up Options Menu
    public void makeOptionsMenu() {
        btmapSize = new Label("Map Size:");
        mapsize = new ChoiceBox<>();
        mapsize.getItems().add("20");
        mapsize.getItems().add("30");
        mapsize.getItems().add("40");
        mapsize.getItems().add("50");
        mapsize.setValue("40");
        btsnakeSpeed = new Label("Snake Speed:");
        speed = new ChoiceBox<>();
        speed.getItems().add("slow");
        speed.getItems().add("medium");
        speed.getItems().add("fast");
        speed.setValue("medium");
        set = new Button("All set!");
    }

    public void makeMainMenu() {

        HBox titleBox = new HBox();
        titleBox.getChildren().add(gameTitle);

        //rootNode.setPrefSize(800, 900);
        //btnBox will hold the three buttons
        VBox btnBox = new VBox();
        btnBox.getChildren().addAll(playBtn, optionsBtn, ldrBoardBtn);
        btnBox.setSpacing(20);

        HBox howToBox = new HBox();
        howToBox.getChildren().add(howTo);

        rootNode.setTop(titleBox);
        //rootNode.setMargin(titleBox, new Insets(5, 200, 5, 200));
        rootNode.setLeft(optionsBtn);
        rootNode.setMargin(optionsBtn, new Insets(200, 0, 200, 0));
        //rootNode.setAlignment(optionsBtn, Pos.CENTER_LEFT);
        rootNode.setRight(ldrBoardBtn);
        rootNode.setMargin(ldrBoardBtn, new Insets(200, 0, 200, 0));

        //rootNode.setAlignment(ldrBoardBtn, Pos.CENTER_RIGHT);
        rootNode.setCenter(playBtn);

        //rootNode.setCenter(btnBox);
        //rootNode.setAlignment(btnBox, Pos.CENTER);
        rootNode.setBottom(howToBox);
        rootNode.setMargin(howToBox, new Insets(5, 100, 5, 100));
        //rootNode.setAlignment(howToBox, Pos.BOTTOM_CENTER);

        rootNode.setPrefSize(400, 400);
        /*
        rootNode.getChildren().addAll(titleBox, btnBox, howToBox);
        rootNode.setAlignment(titleBox, Pos.TOP_CENTER);
        rootNode.setAlignment(btnBox, Pos.CENTER);
        rootNode.setAlignment(howToBox, Pos.BOTTOM_CENTER);
         */
    }

    public Label getLeaderboard() {
        return leaderboard;
    }

    public Label getSnakeSpeed() {
        return btsnakeSpeed;
    }

    public Label getBtmapSize() {
        return btmapSize;
    }

    public ChoiceBox<String> getSpeed() {
        return speed;
    }

    public Button getSet() {
        return set;
    }

    public Label getBtsnakeSpeed() {
        return btsnakeSpeed;
    }

    public ChoiceBox<String> getMapsize() {
        return mapsize;
    }

    public BorderPane getRootNode() {
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

    public Label getCurrentScore() {
        return currentScore;
    }

    public Label getScoreShown() {
        return scoreShown;
    }

}
