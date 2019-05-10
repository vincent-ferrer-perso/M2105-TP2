package fr.univ_amu.iut.exercice12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label label;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private HBox haut;
    private Pane panneau;
    private HBox bas;

    EventHandler<ActionEvent> ecouteurVert = event -> {
        nbVert += 1;
        panneau.setStyle("-fx-background-color: green");
        label.setText("Vert choisi " + nbVert + " fois");
    };

    EventHandler<ActionEvent> ecouteurRouge = event -> {
        nbRouge += 1;
        panneau.setStyle("-fx-background-color: red");
        label.setText("Rouge choisi " + nbRouge + " fois");
    };

    EventHandler<ActionEvent> ecouteurBleu = event -> {
        nbBleu += 1;
        panneau.setStyle("-fx-background-color: blue");
        label.setText("Bleu choisi " + nbBleu + " fois");
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        label = new Label();

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        root = new BorderPane();
        haut = new HBox();
        panneau = new Pane();
        bas = new HBox();


        panneau.setPrefSize(400,200);
        haut.setAlignment(Pos.CENTER);
        bas.setAlignment(Pos.CENTER);

        vert.setOnAction(ecouteurVert);
        rouge.setOnAction(ecouteurRouge);
        bleu.setOnAction(ecouteurBleu);

        haut.getChildren().addAll(vert,rouge,bleu);
        bas.getChildren().addAll(label);

        haut.setPadding(new Insets(10));
        haut.setSpacing(20);
        bas.setPadding(new Insets(10));

        root.setCenter(panneau);
        root.setBottom(bas);
        root.setTop(haut);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
