package fr.univ_amu.iut.exercice12;

import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;

public class TestPalette extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new Palette().start(stage);
    }
}