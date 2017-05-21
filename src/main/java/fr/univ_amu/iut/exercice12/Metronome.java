package fr.univ_amu.iut.exercice12;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Metronome extends Application {

    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button stopButton;
    private Circle circle;


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        circle = new Circle(100, 10, 10, Color.BLUE);

        TranslateTransition anim = new TranslateTransition(new Duration(1000.0), circle);
        anim.setFromY(10);
        anim.setToY(400);
        anim.setAutoReverse(true);
        anim.setCycleCount(Animation.INDEFINITE);
        anim.setInterpolator(Interpolator.LINEAR);

        startButton = new Button("Start");
        startButton.setOnAction(e -> anim.playFromStart());

        pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> anim.pause());

        resumeButton = new Button("Resume");
        resumeButton.setOnAction(e -> anim.play());

        stopButton = new Button("Stop");
        stopButton.setOnAction(e -> anim.stop());

        HBox commands = new HBox(10,
                startButton,
                pauseButton,
                resumeButton,
                stopButton);

        VBox group = new VBox(commands, circle);
        Scene scene = new Scene(group, 400, 500);

        stage.setScene(scene);
        stage.setTitle("Metronome");
        stage.show();
    }
}