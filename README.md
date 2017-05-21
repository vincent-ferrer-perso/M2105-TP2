# <img src="https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png" alt="class logo" class="logo"/> Introduction aux IHM en Java 

### IUT d’Aix-Marseille – Département Informatique Aix-en-Provence

* **Cours:** [M2105](http://cache.media.enseignementsup-recherche.gouv.fr/file/25/09/7/PPN_INFORMATIQUE_256097.pdf)
* **Responsable:** [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr)
* **Enseignants:** [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr), [Cyril Pain-Barre](mailto:cyril.pain-barre@univ-amu.fr)
* **Besoin d'aide ?**
    * La page [Piazza de ce cours](https://piazza.com/univ-amu.fr/spring2017/m2105/home).
    * Consulter et/ou créér des [issues](https://github.com/IUTInfoAix-M2105/tp1/issues).
    * [Email](mailto:sebastien.nedjar@univ-amu.fr) pour une question d'ordre privée, ou pour convenir d'un rendez-vous physique.

## TP 2 : Premiers pas avec JavaFX 8.0 [![Build Status](https://travis-ci.com/IUTInfoAix-M2105/tp2.svg?token=zPXgu159amQhEb4ShTxW)](https://travis-ci.com/IUTInfoAix-M2105/tp2)

JavaFX 8.0 regroupe un ensemble d'API de Java 8 Standard Edition permettant le développement rapide d'applications graphiques modernes (aussi bien que des jeux 3D !).
JavaFX 8.0 est tellement riche que sa [documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm) se trouve à part de celle de 
[Java 8](https://docs.oracle.com/javase/8/docs/api/index.html?overview-summary.html) (qui inclut celle de ses prédécesseurs AWT et Swing), bien qu'il fasse partie intégrante de Java 8.

Ce TP est l'occasion d'un premier contact avec cet environnement.

#### Création de votre fork du TP

La première chose que vous allez faire est de créer un fork d'un dépôt. Pour ce faire, rendez-vous sur le lien suivant : 

[https://classroom.github.com/assignment-invitations/3caf02cc2527d1e1f8ea209cccbbe0ee](https://classroom.github.com/assignment-invitations/3caf02cc2527d1e1f8ea209cccbbe0ee) 

Comme pour le TP1, GitHub va vous créer un dépôt contenant un fork du dépôt 'IUTInfoAix-m2105/tp2' et s'appellant 'IUTInfoAix-m2105/tp2-votreUsername'. 
Vous apparaîtrez automatiquement comme contributeur de ce projet pour y pousser votre travail.

Une fois votre fork créé, il vous suffit de l'importer dans IntelliJ.


### Première application : les classes Application et Stage

Commençons par le plus simple programme permettant d'afficher une fenêtre JavaFX.

#### Exercice 1

Ouvrez le fichier `MyFirstJavaFXWindow.java` du paquet `exercice1` et exécutez-le. Une fenêtre devrait s'afficher avec 
le titre "*A Useless JavaFX Window*". Elle porte bien son nom car, en effet, cette fenêtre ne sert pas à grand chose...
Néanmoins, elle peut être minimisée, agrandie, déplacée, fermée etc. comme n'importe quelle fenêtre de votre bureau !

Le code de cette application graphique est le suivant :

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

Les deux premiers imports sont nécessaires pour utiliser les noms courts des deux classes indispensables à cet 
affichage : `javafx.application.Application` et `javafx.stage.Stage`.

Ainsi que la déclaration de notre classe `MyFirstJavaFXWindow` le montre, toute application JavaFX doit être une 
sous-classe de `Application`.

Dans un navigateur, ouvrez la documentation sur la classe `Application`. On observe que cette classe est **abstraite**, 
ce qui signifie que notre classe **concrête** `MyFirstJavaFXWindow` qui l'étend doit implémenter (redéfinir) les méthodes 
abstraites de sa classe parente `Application`.

Dans la partie *Method Summary* de la documentation, on remarque que la seule méthode abstraite d'`Application` est la 
méthode `start()`.  C'est la seule méthode que notre classe doit forcément implémenter pour devenir concrète (et donc 
être instanciable).

Avant de s'intéresser à son contenu, observons que la classe `MyFirstJavaFXWindow` est une classe 
exécutable car elle définit la méthode `main()`. Celle-ci se contente d'appeler la méthode `launch()` qui est une 
méthode **statique** de la classe `Application`. Le rôle de cette méthode est de créer une instance de notre 
`Application` et de la démarrer, en lui communiquant les arguments de la ligne de commande.

La méthode `start()` prend en paramètre une instance de la classe `Stage` qui est créée par JavaFX dans `launch()`, 
et qui représente la fenêtre principale de notre application (qui pourra en créer d'autres si besoin).
Dans notre application, cette fenêtre est vide. Nous nous sommes contentés d'en définir le titre avec la méthode 
`setTitle()` puis de demander son affichage avec la méthode `show()`.

Ouvrez la documentation sur la classe `Stage`.
 
Remarquez que cette classe étend la classe `Window` qui est plus générale. Elle définit les bases de toute fenêtre de 
premier niveau, ce qui comprend aussi les *popups*. La classe `Stage` dispose de nombreuses méthodes (ou redéfinitions) 
qui lui sont propres et indiquées dans la partie *Method Summary* de sa documentation, ainsi que des méthodes héritées 
(et non redéfinies) de sa super-classe `Window` (et, par transitivité, de la super-classe `Object`) indiquées dans 
les parties *Methods inherited from ...*.

Pour valider cet exercice, supprimez l'annotation @Ignore dans la classe `TestMyFirstJavaFXWindow` et lancez les tests 
pour vérifier que tout est correct.

#### Exercice 2
Pour commencer cet exercice, ouvrez la classe `MySecondJavaFxWindow` du paquetage `exercice2`. Dans la méthode `start()` 
de cette classe, modifiez le titre de la fenêtre en "*Second Useless JavaFX Window*" puis 
ajoutez les instructions pour  que votre fenêtre respecte les contraintes suivantes :
* Être toujours placée au premier plan et ne pas être redimensionnable (cherchez dans la documentation des méthodes de ``Stage``),
* Avoir une largeur fixée à 800 pixels et une hauteur fixée à 400 pixels (cherchez dans les méthodes de ``Window``).

Terminez par l'ajout d'un appel à la méthode `show()` pour afficher la fenêtre.

Exécutez l'application pour vérifier les conséquences de vos modifications. Comme pour l'exercice précédent, vous devez 
activer les tests les un après les autres et soumettre votre solution après chaque itération du cycle principal du workflow.

#### Exercice 3

Modifiez le code de l'application qui vous est donné de manière à changer le style de la fenêtre pour qu'elle ne soit 
pas décorée. Ajoutez les propriétés que les test vous imposent pour être totalement validées.

Puisqu'elle n'est plus décorée, la fenêtre qui s'affiche ne dispose plus du bouton permettant de terminer l'application !
Néanmoins, sur un bureau comme le vôtre qui dispose d'une barre de tâches, un simple clic droit sur l'icône 
correspondante nous donne accès à un menu contextuel permettant de la fermer. Un autre moyen est de cliquer sur le carré 
rouge de la partie *Run:* en bas à gauche de la fenêtre IntelliJ, aussi présent en haut à droite.

### Cycle de vie d'une application

Étudions rapidement le cycle de vie d'une application JavaFX (déjà présenté en cours magistral, et figurant dans la 
documentation de la classe `Application`).

Pour rappel, la méthode statique `launch()` effectue dans l'ordre les opérations suivantes :
  1. crée une instance de notre sous-classe d'`Application`,

  2. appelle sa méthode `init()` qui, comme son nom l'indique, permet de procéder à d'éventuelles initialisations,

  3. appelle sa méthode `start()` en lui fournissant une instance de `Stage`,

  4. attend que l'application se termine, soit parce que l'application a appelé la méthode statique `Platform.exit()`, 
  soit parce que sa dernière fenêtre a été fermée et que l'attribut `implicitExit` de ``Platform`` est fixé à `true` (qui 
  est sa valeur par défaut),

  5. puis appelle sa méthode `stop()`.

Seule la méthode `start()` nécessite d'être implémentée car elle est abstraite. Les méthodes `init()` et `stop()` sont 
déjà définies (vides) dans la classe `Application`, mais peuvent être redéfinies dans notre sous-classe d'`Application` 
si besoin. 

Afin d'étudier le cycle de vie d'une application, vous allez tracer les différents appels en affichant des messages sur 
la *console*. Pour cela, vous utiliserez la méthode ``System.out.println()`` qui prend en paramètre un ``String`` 
contenant le message à afficher. Pour les entrées-sorties sur un terminal (ou console), la classe ``System`` 
fournit 3 données membres statiques ``in``, ``out`` et ``err`` qui représentent respectivement les flux de l'entrée 
standard, de la sortie standard et de la sortie d'erreur (comme le font les flux ``cin``, ``cout`` et ``cerr`` du C++).
Sans (trop) rentrer dans les détails, ``System.out`` est une instance de la classe ``java.io.PrintStream`` qui fournit 
de nombreuses méthodes d'écriture dans un flux parmi lesquelles plusieurs déclinaisons de la méthode ``println()`` dont 
celle prenant un ``String`` en paramètre.

#### Exercice 4

Allez dans le paquetage `exercice4` et ouvrir la classe `ApplicationLifeCycle`, puis :
* ajoutez un constructeur sans paramètre à cette classe, se contentant d'afficher le message "*constructeur ApplicationLifeCycle()*"

* dans `start()` :
  - ajoutez l'affichage le message "*start()*"

* redéfinissez la méthode `init()` de la classe `Application`, en se contenant d'afficher le message "*init()*"

* redéfinissez la méthode `stop()` de la classe `Application`, en se contenant d'afficher le message "*stop()*" 

* dans `main()`, ajoutez l'affichage des messages "*main() : avant launch*" et "*main() : après launch*", respectivement 
avant et après l'appel de `launch()`

Puis exécutez (et testez) cette classe, sans en fermer la fenêtre.

Remarquez que l'affichage s'arrête à celui **après** le ``show()`` qui a rendu visible la fenêtre. À ce stade, la 
méthode ``start()`` est terminée. Java (FX) attend désormais que la fenêtre de l'application soit fermée.

Fermez la fenêtre et observez que la méthode ``stop()`` est alors appelée, ce qui met fin à notre application, 
puis que les instructions suivant le `launch()` de la méthode `main()` sont exécutées ensuite.


### Qui fait quoi ?

Pour terminer l'étude du cycle de vie, intéressons-nous aux "organes" de Java qui animent (exécutent) notre application.
Pour réaliser certaines tâches, la JVM utilise des *threads*, qui sont des fils d'exécution distincts d'un même processus.
En général, un *processus* (ou l'un de ses threads) crée des thread pour réaliser des tâches annexes tout en continuant 
ses propres tâches. Bien que réducteur, retenons simplement que les thread s'exécutent en parallèle, peuvent se 
synchroniser, et partagent ensemble la mémoire du processus et ont donc accès aux mêmes objets de l'application.

#### Exercice 5

Ouvrez la classe ``WhoIsWho``, puis :
1. ouvrez la documentation de la classe ``Thread`` de Java8, qui est la super classe des threads de la JVM, et recherchez-y :

* la méthode statique qui renvoie le Thread courant,

* la méthode d'instance qui renvoie un String contenant le nom du thread (oui, ils ont un petit nom)

2. Faite en sorte que chaque méthode du cycle de vie ait un affichage identique à celui de l'exercice 4. 

2. préfixez chaque affichage de l'application par la chaîne ``[``*nom*``]`` suivi d'un espace, où *nom* est le nom du 
thread courant (celui qui fait appel au ``println``).
  
Éxécutez ensuite l'application pour vérifier quels threads interviennent à quel étape du cycle de vie de cette si 
simple application.


### Première application graphique : composants et événements
Maintenant que nous comprenons le cycle de vie d'une application JavaFX, nous allons pouvoir commencer à écrire un 
premier programme graphique qui se contentera d'afficher un texte au centre de la fenêtre.
 

#### Exercice 6

Ouvrez la classe `HelloLabel` et modifier la methode `start()` pour que votre application affiche une fenêtre 
respectant les contraintes suivante : 

- Le titre de la fenêtre principale doit être "Hello !"

- La longueur et la largeur doivent être 250 et 100

- Le graphe de scène doit avoir pour racine un noeud du type `BorderPane`

- Au centre de ce `BorderPane`, placer un `Label` (voir la documentation de cette classe) ayant pour `text` la chaine `Hello !`

- Ce label doit avoir pour `Id` la valeur `"labelHello"`

- Rendre visible la fenêtre

Exécutez l'application pour vérifier le fonctionnement de cette fenêtre. Redimensionnez-là pour voir comment se comporte 
votre `Label`. Comme pour l'exercice précédent, vous devez activer les tests les un après les autres et soumettre votre 
solution après chaque itération du cycle principal du workflow.

#### Exercice 7
Les labels sont des composants pour afficher un texte. Ils sont souvent utiliser conjointement avec des composants comme 
les `TextField` (ou tout autre composant de saisie). Maintenant que nous avons vu ce composant passif, nous allons voir 
le premier avec lequel nous pouvons interagir le `Button`.

Ouvrez la classe `HelloButton` et modifier la methode `start()` pour que votre application affiche une fenêtre 
respectant les contraintes suivante : 

- Le titre de la fenêtre principale doit être "Hello !"

- La longueur et la largeur de la scène doivent être 250 et 100

- Le graphe de scène doit avoir pour racine un noeud du type `BorderPane`

- Au centre de ce `BorderPane`, placer un `Button` (voir la documentation de cette classe) ayant pour `text` la chaine `Hello !`

- Ce bouton doit avoir pour `Id` la valeur `"buttonHello"`

- Rendre visible la fenêtre

Exécutez l'application pour vérifier le fonctionnement de cette fenêtre. Comme pour l'exercice précédent, vous devez 
activer les tests les un après les autres et soumettre votre solution après chaque itération du cycle principal du workflow.

#### Exercice 8

Pour l'instant notre bouton parait bien triste. Ajoutons-lui quelques décorations pour qu'il soit plus esthétique.

Ouvrez la classe `HelloBeautifulButton` et modifier la methode `start()` pour que votre application affiche une fenêtre 
respectant les contraintes suivante :

- Respecter toutes les contraintes de l'exercice précédent

- Construire un objet du type `ImageView` ouvrant l'image située à l'URL suivante : https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png

- Positionner cet objet comme valeur de la propriété `Graphic` de notre bouton.
 
- Agrandir la hauteur de la scène à 250

- Rendre visible la fenêtre

Exécutez l'application pour vérifier le fonctionnement de cette fenêtre. Comme pour l'exercice précédent, vous devez 
activer les tests les un après les autres et soumettre votre solution après chaque itération du cycle principal du workflow.

