package fr.univ_amu.iut.exercice9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloBeautifulUsefulButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setWidth(250);
        primaryStage.setHeight(250);
        Button but = new Button("Hello !");
        but.setId("buttonHello");
        Scene scene = new Scene(new BorderPane(but));
        scene.getStylesheets().add(getClass().getClassLoader().getResource("DarkTheme.css").toExternalForm());
        primaryStage.setScene(scene);
        but.setOnAction(new EcouteurSimple());
        primaryStage.show();
        ImageView ImgURL = new ImageView("https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png");
        but.setGraphic(ImgURL);

    }
}
