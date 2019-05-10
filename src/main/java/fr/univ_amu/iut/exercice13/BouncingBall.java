package fr.univ_amu.iut.exercice13;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

    EventHandler<ActionEvent> ecouteurStart = event -> {
        transition.playFromStart();
    };

    EventHandler<ActionEvent> ecouteurPause = event -> {
        transition.pause();
    };

    EventHandler<ActionEvent> ecouteurResume = event -> {
        transition.play();
    };

    EventHandler<ActionEvent> ecouteurStop = event -> {
        transition.stop();
    };



    @Override
    public void start(Stage stage) {
        startButton  = new Button("Start" );
        pauseButton  = new Button("Pause" );
        resumeButton = new Button("Resume");
        stopButton   = new Button("Stop"  );
        slider = new Slider();
        circle = new Circle(5);
        root = new VBox();
        commands = new HBox();
        pane = new Pane(circle);
        transition = new TranslateTransition();

        transition.setNode(circle);
        transition.setFromY(10);
        transition.setToY(400);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setDuration(Duration.seconds(1));

        pane.setPrefSize(400,450);

        slider.setMaxWidth(400);
        slider.setMin(0.1);
        slider.setMax(5);

        pane.widthProperty().addListener((obs,oldv,newv)->{
            circle.setCenterX(newv.intValue()/2);
        });


        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> transition.setRate(newValue.doubleValue())
        );

        commands.getChildren().addAll(startButton,pauseButton,resumeButton,stopButton);

        startButton.setOnAction(ecouteurStart);
        pauseButton.setOnAction(ecouteurPause);
        resumeButton.setOnAction(ecouteurResume);
        stopButton.setOnAction(ecouteurStop);

        commands.setAlignment(Pos.TOP_CENTER);
        commands.setPadding(new Insets(10));
        commands.setSpacing(20);
        commands.setPadding(new Insets(10));

        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(commands,slider,pane);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
