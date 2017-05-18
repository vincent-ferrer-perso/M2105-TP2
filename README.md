# <img src="https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png" alt="class logo" class="logo"/> Introduction aux IHM en Java 

### IUT d’Aix-Marseille – Département Informatique Aix-en-Provence

* **Cours:** [M2105](http://cache.media.enseignementsup-recherche.gouv.fr/file/25/09/7/PPN_INFORMATIQUE_256097.pdf)
* **Responsable:** [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr)
* **Enseignants:** [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr), [Cyril Pain-Barre](mailto:cyril.pain-barre@univ-amu.fr)
* **Besoin d'aide ?**
    * La page [Piazza de ce cours](https://piazza.com/univ-amu.fr/spring2017/m2105/home).
    * Consulter et/ou créér des [issues](https://github.com/IUTInfoAix-M2105/tp1/issues).
    * [Email](mailto:sebastien.nedjar@univ-amu.fr) pour une question d'ordre privée, ou pour convenir d'un rendez-vous physique.

## TP 2 : Premiers pas avec JavaFX 8.0 [![Build Status](https://travis-ci.org/IUTInfoAix-M2105/tp2.svg?branch=master)](https://travis-ci.org/IUTInfoAix-M2105/tp2-bashelier)

JavaFX 8.0 regroupe un ensemble d'API de Java 8 Standard Edition permettant le développement rapide d'applications graphiques modernes (aussi bien que des jeux 3D !).
JavaFX 8.0 est tellement riche que sa [documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm) se trouve à part de celle de 
[Java 8](https://docs.oracle.com/javase/8/docs/api/index.html?overview-summary.html) (qui inclut celle de ses prédécesseurs AWT et Swing), bien qu'il fasse partie intégrante de Java 8.

Ce TP est l'occasion d'un premier contact avec cet environnement.
Commençons par le plus simple programme permettant d'afficher une fenêtre JavaFX.

### Première application : les classes Application et Stage

Ouvrez le fichier `MyFirstJavaFXWindow.java` du paquet `exercice1` et exécutez-le.
Une fenêtre devrait s'afficher avec le titre "*A Useless JavaFX Window*".
Elle porte bien son nom car, en effet, cette fenêtre ne sert pas à grand chose...
Néanmoins, elle peut être minimisée, agrandie, déplacée, fermée etc. comme n'importe quelle fenêtre de votre bureau !

Le code de cette application graphique devrait contenir :

```java
package fr.univ_amu.iut.exercice1;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyFirstJavaFXWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("A Useless JavaFX Window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Les deux premiers imports sont nécessaires pour utiliser les noms courts 
des deux classes indispensables à cet affichage : `javafx.application.Application` et `javafx.stage.Stage`.

Ainsi que la déclaration de notre classe `MyFirstJavaFXWindow` le montre, toute application JavaFX doit être une sous-classe de `Application`.
Dans un navigateur, ouvrez la documentation sur la classe ``Application``. 
On observe que cette classe est **abstraite**, ce qui signifie que notre classe concrête ``MyFirstJavaFXWindow`` qui l'étend doit implémenter 
les méthodes abstraites de sa classe parente ``Application``.

Dans la partie *Method Summary* de la documentation, on remarque que la seule méthode abstraite d'``Application`` est la méthode ``start()``. 
C'est donc la seule méthode que notre classe doit forcément implémenter (redéfinir).

Avant de s'intéresser à son contenu, nous pouvons observer que notre classe ``MyFirstJavaFXWindow`` est une classe exécutable car elle définit la méthode ``main()``.
Celle-ci se contente d'appeler la méthode ``launch()`` qui est une méthode **statique** de la classe ``Application``, dont le rôle est de créer une instance de notre ``Application`` et de la démarrer, 
en lui communiquant les arguments de la ligne de commande.
Nous étudierons plus en détail les étapes de démarrage d'une telle application dans l'exercice suivant.

Revenons à notre méthode ``start()`` qui prend en paramètre une instance de la classe ``Stage``, créée par JavaFX dans ``launch()``, 
et qui représente la fenêtre principale de notre application (qui pourra en créer d'autres si besoin).
Dans notre application, cette fenêtre est vide.
Nous nous sommes contentés d'en définir le titre avec la méthode ``setTitle()`` puis de demander son affichage avec la méthode ``show()``.

Ouvrez la documentation sur la classe ``Stage``. 
Remarquez que cette classe étend la classe ``Window`` qui est un peu plus générale car définit les bases de toute fenêtre de premier niveau, ce qui comprend aussi les *popups*.
La classe ``Stage`` dispose de nombreuses méthodes (ou redéfinitions) qui lui sont propres et indiquées dans la partie *Method Summary* de la documentation, 
ainsi que des méthodes héritées (et non redéfinies) de sa super-classe ``Window`` (et par transitivité de la super-classe ``Object``) indiquées dans les parties *Methods inherited from ...*.

#### Exercice

Modifiez le code de l'application précédente de manière à ce que la fenêtre :
* soit toujours placée au premier plan et ne soit pas redimensionnable (cherchez dans les méthodes de Stage) ;
* ait une largeur de 800 pixels et une hauteur de 400 pixels (cherchez dans les méthodes de Window).

Exécutez l'application pour vérifier vos modifications, sans oublier d'exécuter les tests correspondants.

#### Exercice

Modifiez à nouveau le code de l'application de manière à changer le style de la fenêtre pour qu'elle ne soit pas décorée.
Exécutez l'application ainsi que le test correspondant pour vérifier.


### Cycle de vie d'une application

Puisqu'elle n'est plus décorée, la fenêtre précédente ne dispose plus du bouton permettant de terminer l'application.
Le seul moyen à votre disposition est de cliquer sur le carré rouge de la partie *Run:* en bas à gauche de la fenêtre IntelliJ.

Il est temps d'aborder le cycle de vie d'une application JavaFX, déjà présenté en cours magistral, et figurant dans la 
documentation de la classe ``Application``.
Pour rappel, la méthode statique ``launch()`` :
  1. crée une instance de notre sous-classe d'``Application``,
  2. appelle sa méthode ``init()`` qui, comme son nom l'indique, permet de procéder à d'éventuelles initialisations,
  3. appelle sa méthode ``start()`` en lui fournissant une instance de ``Stage``,
  4. attend que l'application se termine, soit parce que l'application a appelé la méthode statique ``Platform.exit()``, soit parce que la dernière fenêtre a été fermée et que l'attribut ``implicitExit`` de ``Platform`` est fixé à ``true`` (qui est sa valeur par défaut),
  5. puis appelle sa méthode ``stop()``.








Premier contact avec JavaFx (Stage, scène, événements... )
