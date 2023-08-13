package com.game.app;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx. geometry. Pos;
import javafx. scene. control.Button;
import javafx. scene. control.Label;
import javafx. scene. layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InfoCenter {
        private StackPane pane;
        private Label message;
        public Button startGameButton;
        public InfoCenter() {
            // pane = new StackPane();
            // pane. setMinSize (Globals.APP_WIDTH, Globals.INFO_CENTER_HEIGHT);
            // pane. setTranslateX (Globals.APP_WIDTH / 2);
            // pane. setTranslateY (Globals.INFO_CENTER_HEIGHT / 2);
            // message = new Label("Tic-Tac-Toe");
            // message. setMinSize (Globals.APP_WIDTH, Globals.INFO_CENTER_HEIGHT);
            // message. setFont (Font. font (24));
            // message. setAlignment(Pos.CENTER);
            // message. setTranslateY(-20);
            // pane.getChildren().add(message);
            // startGameButton = new Button ("Start New Game");
            // startGameButton. setMinSize(135, 30);
            // startGameButton. setTranslateY(20);
            // pane.getChildren().add(startGameButton);
            // Create a new StackPane
 pane = new StackPane();
pane.setMinSize(Globals.APP_WIDTH, Globals.INFO_CENTER_HEIGHT);
pane.setTranslateX(Globals.APP_WIDTH / 2);
pane.setTranslateY(Globals.INFO_CENTER_HEIGHT / 2);

// Add a message label to the pane
 message = new Label("Tic-Tac-Toe");
message.setMinSize(Globals.APP_WIDTH, Globals.INFO_CENTER_HEIGHT);
message.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // Make the font larger and bolder
message.setTextFill(Color.web("#333333")); // Use a darker text color
message.setPadding(new Insets(10)); // Add some padding around the text
message.setStyle("-fx-background-radius: 10px;"); // Add a white background with rounded corners
message.setAlignment(Pos.CENTER);
message.setTranslateY(-30); // Move the message label up a bit
pane.getChildren().add(message);

// Add a button to start a new game
startGameButton = new Button("Start New Game");
startGameButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-background-radius: 10px;"); // Add a green background with white text and rounded corners
startGameButton.setMinSize(150, 40); // Make the button a bit larger
startGameButton.setTranslateY(30); // Move the button down a bit
pane.getChildren().add(startGameButton);
    



        }
    public StackPane getStackPane(){
     return pane;
}
    public void updateMessage(String message) {
        this.message.setText(message);

    }
    public void showStartButton(){
    startGameButton.setVisible(true);
}
    public void hideStartButton() {
        startGameButton.setVisible(false);

    }
    public void setStartButtonOnAction (EventHandler<ActionEvent> onAction) {
        startGameButton.setOnAction(onAction);
    }

    }