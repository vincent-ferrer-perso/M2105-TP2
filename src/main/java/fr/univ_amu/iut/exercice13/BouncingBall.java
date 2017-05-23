package fr.univ_amu.iut.exercice13;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application {

    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button stopButton;
    private Slider slider;
    private Circle circle;
    private VBox root;
    private HBox commands;
    private Pane pane;
    private TranslateTransition transition;

    @Override
    public void start(Stage stage) {

        circle = new Circle(200, 10, 10, Color.BLUE);

        transition = new TranslateTransition(new Duration(1000.0), circle);
        transition.setFromY(10);
        transition.setToY(400);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setInterpolator(Interpolator.EASE_BOTH);

        startButton = new Button("Start");
        startButton.setOnAction(e -> transition.playFromStart());

        pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> transition.pause());

        resumeButton = new Button("Resume");
        resumeButton.setOnAction(e -> transition.play());

        stopButton = new Button("Stop");
        stopButton.setOnAction(e -> transition.stop());

        commands = new HBox(10,
                startButton,
                pauseButton,
                resumeButton,
                stopButton);
        commands.setAlignment(Pos.CENTER);

        slider = new Slider(0.1, 5, 1);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> transition.setRate(newValue.doubleValue()));

        pane = new Pane(circle);

        root = new VBox(commands, slider, pane);
        root.setSpacing(20);
        root.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(root, 400, 500);

        stage.setScene(scene);
        stage.setTitle("BouncingBall");
        stage.show();
    }
}