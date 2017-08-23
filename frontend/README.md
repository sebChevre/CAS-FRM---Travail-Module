# starter-angular2-webpack
Ce repository est un projet bootstrap strater angular2 basé sur webpack.
Il est inspiré de cette documentation : https://angular.io/docs/ts/latest/guide/webpack.html

## Description
Ce projet est basé sur node (webpack). Il utilise webpack pour gérer les modules et les phases de construction.
En outre il incorpore les librairies suivantes:
* ```polyfills.js```, pour la gestion cross-browser
* ```karma.js```, pour les tests unitaires
* ```jasmine```, pour les tests coportementaux

## Profiles
Trois profils ont été définis:
 
### DEV
* webpack.dev.js

### TEST
* webpack.test.js

### PROD
* webpack.prod.js

## Commandes
### Installation du projet
Une fois les repository récupéré lancé la commande 
>```npm install```
 
qui aura pour effet de récupérer les modules 
nodes spécifié dans le fichier ```package.json```.
 
###  Lancement en mode dev
Le lancement en mode DEV aura pour effet de lancer un serveur node qui va servir le projet:
>```npm start```

### Test
Lancement des tests.
> ```npm run test```

### Construction
Le projet sera construit dans le répertoire ```/dist``` (configuration définie dans le fichier webpack.prod.js)
> ```npm run build```




