package fr.univ_amu.iut.exercice12;

import javafx.application.Application;
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

    private Label label = new Label("");

    private Button vert = new Button("Vert");
    private Button rouge = new Button("Rouge");
    private Button bleu = new Button("Bleu");

    private BorderPane root = new BorderPane();
    private HBox haut = new HBox(10);
    private Pane panneau = new Pane();
    private HBox bas = new HBox();

    @Override
    public void start(Stage primaryStage) throws Exception {

        label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        vert.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: green");
            label.setText("Vert choisi " + (++nbVert) + " fois");
        });

        rouge.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: red");
            label.setText("Rouge choisi " + (++nbRouge) + " fois");
        });

        bleu.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: blue");
            label.setText("Bleu choisi " + (++nbBleu) + " fois");
        });

        panneau.setPrefSize(400, 200);

        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(10, 5, 10, 5));
        bas.getChildren().add(label);

        haut.setAlignment(Pos.CENTER);
        haut.setPadding(new Insets(10, 5, 10, 5));
        haut.getChildren().addAll(vert, rouge, bleu);

        root.setBottom(bas);
        root.setTop(haut);
        root.setCenter(panneau);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}