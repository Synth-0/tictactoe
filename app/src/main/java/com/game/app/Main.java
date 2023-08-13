package com.game.app;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    private InfoCenter infocenter;
    private TileBoard tileBoard;
    @Override
    public void start(Stage primaryStage) {

       try {
           BorderPane root = new BorderPane();
           Scene scene = new Scene(root, Globals.APP_WIDTH, Globals.APP_HEIGHT);
           primaryStage.setTitle("Tic Tac Toe");
           initLayout(root);
           primaryStage.setScene(scene);
           primaryStage.show();
       } catch(Exception e) {
            e.printStackTrace();
         }
    }
    private void initLayout (BorderPane root) {
        initInfoCenter(root);
        initTileBoard(root);
    }
    private EventHandler<ActionEvent> startNewGame() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                infocenter.hideStartButton();
                infocenter.updateMessage("Player X's Turn");
                tileBoard.startNewGame();

            }
        };
    }







        private void initInfoCenter(BorderPane root) {
        infocenter= new InfoCenter();
        infocenter.setStartButtonOnAction(startNewGame());
        root.getChildren().add(infocenter.getStackPane());
        }



    private void initTileBoard(BorderPane root) {
             tileBoard = new TileBoard(infocenter);

        root.getChildren().add(tileBoard.getStackPane());
    }



    public static void main(String[] args) {
        launch(args);
    }
}