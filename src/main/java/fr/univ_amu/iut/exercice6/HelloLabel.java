package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.stage.Stage;

public class HelloLabel extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        Label labelHello = new Label("Hello !");
        labelHello.setId("labelHello");
        Scene scene = new Scene(new BorderPane(labelHello),250,100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
