package fr.univ_amu.iut.exercice4;

import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationLifeCycle extends Application {

    public ApplicationLifeCycle() {
        super();
        System.out.println("constructeur ApplicationLifeCycle()");
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init()");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop()");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Application's Life Cycle");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        System.out.println("start() : avant show stage");
        primaryStage.show();
        System.out.println("start() : après show stage");    }

    public static void main(String[] args) {
        System.out.println("main() : avant launch");
        launch(args);
        System.out.println("main() : après launch");
    }
}
