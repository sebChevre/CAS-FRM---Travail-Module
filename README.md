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


### front
