package fr.univ_amu.iut.exercice7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setWidth(250);
        primaryStage.setHeight(100);
        Button but = new Button("Hello !");
        but.setId("buttonHello");
        Scene scene = new Scene(new BorderPane(but));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
