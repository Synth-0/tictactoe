package com.game.app;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx. scene. layout. StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class TileBoard  {
    private StackPane pane;
    private InfoCenter infoCenter;
    private Tile[][] tiles = new Tile [3][3];
    private boolean isEndOfGame = false;
    private char playerTurn = 'X';

    public TileBoard(InfoCenter infoCenter) {
        this.infoCenter = infoCenter;
        pane = new StackPane();
        pane.setMinSize(Globals.APP_WIDTH, Globals.TILE_BOARD_HEIGHT);
        pane.setTranslateX(Globals.APP_WIDTH / 2);
        pane.setTranslateY((Globals.TILE_BOARD_HEIGHT / 2) + Globals.INFO_CENTER_HEIGHT);
        addAllTiles();
        pane.setVisible(false);// only works if everything is filled
        infoCenter.startGameButton.setOnMouseClicked(event -> {
            pane.setVisible(true);
            if(isEndOfGame){
                pane.setVisible(true);
            }
        });
    }
    private void addAllTiles() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Tile tile = new Tile();
                tile.getStackPane().setTranslateX((col * 130)-130);
                tile. getStackPane().setTranslateY((row * 130) - 130);
                pane. getChildren().add(tile.getStackPane());
                tiles [row] [col] = tile;
            }
        }
    }

    public void startNewGame () {
        isEndOfGame = false;
        playerTurn = 'X';
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles [row] [col]. setValue("");
            }
        }
    }

                public void changePlayerTurn() {
        if (playerTurn == 'X') {
            playerTurn = 'O';
        } else {
            playerTurn = 'X';
        }
        infoCenter.updateMessage("Player " + playerTurn + "'s turn");
    }



    public StackPane getStackPane() {
        return pane;
    }
    public String getPlayerTurn(){
        return String.valueOf(playerTurn);
    }
    public void checkForWinner() throws NullPointerException {
        checkRowsForWinner();
        checkColsForWinner();
        checkTopLeftToBottomRightForWinner();
        checkTopRightToBottomLeftForWinner();
        checkForStalemate();
    }

    private void checkForStalemate() throws NullPointerException{
        if (!isEndOfGame) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (tiles [row][col].getValue().isEmpty()) {
                        return;
                    }
                }
            }
                    isEndOfGame = true;
                    infoCenter.updateMessage("Stalemate...");
                    infoCenter.showStartButton();
                }
            }

                    private void checkTopRightToBottomLeftForWinner() {
        if(!isEndOfGame){
            if(tiles[0][2].getValue().equals(tiles[1][1].getValue())&&
                    tiles[0][2].getValue().equals(tiles[2][0].getValue())&&
                    !tiles[0][2].getValue().isEmpty()){
                String winner = tiles[0][2].getValue();
                endGame(winner);

            }


        }
    }


    private void checkTopLeftToBottomRightForWinner() throws NullPointerException {
      if(!isEndOfGame){
          if(tiles[0][0].getValue().equals(tiles[1][1].getValue())&&
                  tiles[0][0].getValue().equals(tiles[2][2].getValue())&&
                  !tiles[0][0].getValue().isEmpty()){
              String winner = tiles[0][0].getValue();
              endGame(winner);

          }


      }
    }
      

            private void checkColsForWinner() throws NullPointerException {
        for (int col = 0; col < 3; col++) {
            if (tiles [0] [col].getValue().equals(tiles [1] [col].getValue()) &&
                    tiles [0] [col].getValue().equals (tiles [2] [col].getValue()) &&
                    !tiles [0] [col].getValue().isEmpty()){
                String winner = tiles[0][col].getValue();
                endGame(winner);
                return;
            }
        }
    }

    private void checkRowsForWinner()  {
       for (int row = 0; row < 3; row++) {
            if (tiles [row] [0].getValue().equals(tiles [row] [1].getValue()) &&
                    tiles [row] [0].getValue().equals (tiles [row] [2].getValue()) &&
                    !tiles [row] [0].getValue().isEmpty()){
                String winner = tiles[row][0].getValue();
                endGame(winner);
                return;
            }
        }
    }

    private void endGame(String winner) {
        isEndOfGame = true;
        infoCenter.updateMessage("the winner is "+winner);
        infoCenter.showStartButton();
    }

    private class Tile {
        private StackPane pane;
        private Label label;

        public Tile() {

//            pane = new StackPane();
//            pane.setMinSize(100, 100);
//            Rectangle border = new Rectangle();
//            border.setWidth(100);
//            border.setHeight(100);
//            border.setFill(Color.TRANSPARENT);
//            border.setStroke(Color.BLACK);
//            pane.getChildren().add(border);
//             label = new Label("");
//            label.setAlignment(Pos.CENTER);
//            label.setFont(Font.font(24));
//            pane.getChildren().add(label);
            pane = new StackPane();
            pane.setMinSize(125, 125); //100,100
            Rectangle border = new Rectangle();
            border.setWidth(125); //100
            border.setHeight(125);//100
            border.setFill(Color.LIGHTBLUE);
            border.setStroke(Color.BLACK);
            border.setEffect(new DropShadow());
            pane.getChildren().add(border);
            label = new Label("");
            label.setAlignment(Pos.CENTER);
            label.setFont(Font.font("Verdana", 24));
            label.setTextFill(Color.WHITE);
            pane.getChildren().add(label);

// Add a hover effect
            border.setOnMouseEntered(event -> {
                border.setFill(Color.DARKBLUE);
            });
            border.setOnMouseExited(event -> {
                border.setFill(Color.LIGHTBLUE);
            });

            pane.setOnMouseClicked(event -> {
                if (label.getText().isEmpty() && !isEndOfGame) {
                    label.setText(getPlayerTurn());
                    changePlayerTurn();
                    try {checkForWinner();} catch (NullPointerException e ){
                        e.printStackTrace();
                    }
                }

            });


        }

        public StackPane getStackPane() {
            return pane;
        }

        public String getValue() {
           return this.label.getText();

        }


        public void setValue(String value) {
            this.label.setText(value);

        }
    }
}
