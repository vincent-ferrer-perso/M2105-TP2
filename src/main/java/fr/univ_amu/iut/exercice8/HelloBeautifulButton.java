package fr.univ_amu.iut.exercice8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloBeautifulButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");

        BorderPane root = new BorderPane();

        Button button = new Button("Hello !");
        button.setId("buttonHello");

        button.setGraphic(new ImageView("https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png"));

        root.setCenter(button);

        Scene scene = new Scene(root, 250, 250);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("DarkTheme.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
