package fr.univ_amu.iut.exercice4;

import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestApplicationLifeCycle {

    private ApplicationLifeCycle applicationLifeCycle = new ApplicationLifeCycle();

    @Ignore
    @Test
    public void constructor() throws Exception {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        new ApplicationLifeCycle();
        verify(out).println("constructeur ApplicationLifeCycle()");
    }

    @Ignore
    @Test
    public void init() throws Exception {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        applicationLifeCycle.init();
        verify(out).println("init()");
    }

    @Ignore
    @Test
    public void stop() throws Exception {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        applicationLifeCycle.stop();
        verify(out).println("stop()");
    }

    @Ignore
    @Test
    public void start() throws Exception {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        applicationLifeCycle.start(null);
        verify(out).println("start()");
    }
}