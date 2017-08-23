# CAS-FRM---Travail-Module


### Répertoires

## backend
Sources java8 du projet back (api REST) basé sur le framework Spark

Pour builder le projet:
```mvn clean compile assembly:single```
Et récupérer le jar compilé dans le répertoire 'target'
## frontend
Source angular4 du projet frontend. Utilise npm, webpack et angular version 4.2.2

Pour builder le projet:
```npm run build```
Et récupérer le projet compilé dans le répertoire 'dist'

## Livrable

### back
Répertoire content le livrable jar compilé. A exécuter avec la commande suivante:
```java -jar frm-back.jar```
Le serveur tourne sur le port 9090 (http://localhost:9090)


### front
Répertoire du prjet angular 4 compilé.Il n'y a qu'a lancer le fichier index.html dans le navigateur. Il faut au préalable que le serveur (projet back) soit exécuté.

