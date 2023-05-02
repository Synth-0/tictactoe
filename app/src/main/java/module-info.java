module com.game.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.app to javafx.fxml;
    exports com.game.app;
}