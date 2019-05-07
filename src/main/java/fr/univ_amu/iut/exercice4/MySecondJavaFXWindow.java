package fr.univ_amu.iut.exercice4;

import javafx.application.Application;
import javafx.stage.Stage;

public class MySecondJavaFXWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Second Useless JavaFX Window");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.minWidthProperty().setValue(800.0);
        primaryStage.minHeightProperty().setValue(400.0);
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();

    }
}
