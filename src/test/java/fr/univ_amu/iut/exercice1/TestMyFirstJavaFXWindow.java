package fr.univ_amu.iut.exercice1;


import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class TestMyFirstJavaFXWindow extends ApplicationTest {

    @Test
    public void should_initialize_stage_with_height_200() {
        try {
            assertThat(FxToolkit.registerPrimaryStage().getHeight()).isEqualTo(200);
        } catch (TimeoutException e) {
            fail();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        new MyFirstJavaFXWindow().start(stage);
    }
}
