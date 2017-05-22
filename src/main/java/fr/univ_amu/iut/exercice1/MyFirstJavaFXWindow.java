package fr.univ_amu.iut.exercice1;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyFirstJavaFXWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("A Useless JavaFX Window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
