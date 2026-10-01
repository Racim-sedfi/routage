# routage — Générateur de tables de routage

Application Java Swing qui charge un réseau décrit sous forme de graphe pondéré (format
GraphStream `.dgs`), l'affiche et calcule la **table de routage** d'un nœud choisi à l'aide
de l'algorithme de **Dijkstra**.

## Technologies

- Java (compilation en version 14)
- Maven
- Swing (interface graphique)
- GraphStream 1.3 (`gs-core`, `gs-ui`, `gs-algo`) : modélisation, affichage et algorithme de Dijkstra
- GitHub Actions (build Maven)

## Fonctionnalités principales

- Chargement d'un graphe depuis un fichier `.dgs` ou `.txt` (syntaxe GraphStream), avec
  message d'erreur si le fichier est invalide.
- Affichage graphique du réseau, avec le nom des nœuds et le poids des liens.
- Choix d'un nœud source dans une liste déroulante et affichage de sa table de routage :
  pour chaque destination, les voisins du nœud source sont classés selon le coût total
  (poids du lien vers le voisin + plus court chemin du voisin vers la destination).

## Structure du projet

```
├── pom.xml
├── .github/workflows/maven.yml          # Intégration continue (build Maven)
└── src
    ├── main/java
    │   ├── dataroutage/graohTD.dgs      # Exemple de réseau (6 nœuds, 9 liens pondérés)
    │   └── routage
    │       ├── Main.java                # Point d'entrée
    │       ├── fenetre/InterfaceGUI.java  # Fenêtre principale
    │       ├── fenetre/Table.java       # Calcul et affichage de la table de routage
    │       ├── action/                  # Actions des boutons (charger, afficher graphe / table)
    │       └── css/style.css            # Feuille de style GraphStream
    └── test/java/routage/AppTest.java
```

## Compilation et exécution

Prérequis : JDK 14 ou plus récent et Maven.

```bash
mvn compile
mvn exec:java -Dexec.mainClass=routage.Main
```

Dans l'application : **Charger** → sélectionner `src/main/java/dataroutage/graohTD.dgs`,
puis choisir un nœud et afficher sa table ou le graphe.

## Auteur

Racim Sedfi
