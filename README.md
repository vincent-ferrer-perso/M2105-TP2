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

Ouvrez le fichier MyFirstJavaFXWindow.java du paquet exercice1 et exécutez-le.
Une fenêtre devrait s'afficher avec le titre "A Useless JavaFX Window".
Elle porte bien son nom car, en effet, cette fenêtre ne sert pas à grand chose.
Néanmoins, elle peut être minimisée, agrandie, déplacée, fermée etc. comme n'importe quelle fenêtre de votre bureau.

Le code de cette application graphique devrait contenir : (include ??)

Les deux premiers imports sont nécessaires pour utiliser les noms courts 
des deux classes indispensables à cet affichage : javafx.application.Application et javafx.stage.Stage.

Ainsi que la déclaration de notre classe MyFirstJavaFXWindow le montre, toute application JavaFX doit être une sous-classe de Application.
Dans un navigateur, ouvrir la documentation sur cette classe Application. 
On observe que cette classe est abstraite, ce qui signifie que notre classe concrête MyFirstJavaFXWindow qui l'étend doit implémenter les méthodes abstraites de sa classe parente Application.

Dans la partie Method Summary, on remarque que la seule méthode abstraite d'Application est la méthode start(). 
C'est donc la seule méthode que notre classe doit forcément implémenter (redéfinir).

Avant de s'intéresser à son contenu, nous pouvons observer que notre classe MyFirstJavaFXWindow est une classe exécutable car elle définit la méthode main().
Celle-ci se contente d'appeler la méthode launch() qui est une méthode statique de la classe Application dont le rôle est de créer une instance de notre Application et de la démarrer.






Premier contact avec JavaFx (Stage, scène, événements... )
