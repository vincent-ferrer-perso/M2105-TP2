package fr.univ_amu.iut.exercice11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloBeautifulUsefulButton extends Application {
    private int nbAction = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");

        BorderPane root = new BorderPane();

        Button button = new Button("Hello !");
        button.setId("buttonHello");

        button.setGraphic(new ImageView("https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png"));

        EventHandler<ActionEvent> ecouteur = event -> System.out.println("Bouton actionné " + ++nbAction + " fois");
        button.setOnAction(ecouteur);

        root.setCenter(button);

        Scene scene = new Scene(root, 250, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
