package fr.univ_amu.iut.exercice14;

import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;

public class SlowPongTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        new SlowPong().start(stage);
    }
}