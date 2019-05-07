package fr.univ_amu.iut.exercice9;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class EcouteurSimple implements EventHandler<ActionEvent> {
    public void handle(ActionEvent Event){
        System.out.println("Bouton actionné");
        }
}
