package fr.univ_amu.iut.exercice5;

import javafx.application.Application;
import javafx.stage.Stage;

public class WhoIsWho extends Application {

    public WhoIsWho() {
        super();
        System.out.println("[" + Thread.currentThread().getName() + "] " + "constructeur ApplicationLifeCycle()");
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("[" + Thread.currentThread().getName() + "] " + "init()");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("[" + Thread.currentThread().getName() + "] " + "stop()");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("WhoIsWho");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        System.out.println("[" + Thread.currentThread().getName() + "] " + "start() : avant show stage");
        primaryStage.show();
        System.out.println("[" + Thread.currentThread().getName() + "] " + "start() : après show stage");    }

    public static void main(String[] args) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + "main() : avant launch");
        launch(args);
        System.out.println("[" + Thread.currentThread().getName() + "] " + "main() : après launch");
    }
}
