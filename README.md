# Projet Java avec Spring Boot

## Prérequis
**Spring Boot** : version `3.4.0`
**Java** : version `17`
**Maven**  : pour la gestion des dépendances et la compilation du projet
**IDE**  : Eclipse
**Postman** : pour le test de services

## Installation

1. Clonez ce dépôt sur votre machine locale :  
   git clone <URL_DU_DEPOT>
   cd <NOM_DU_PROJET>
2. Importer le projet (Import -> Existing maven project) dans Eclipse.
3.  Exécutez la commande suivante sur le projet pour télécharger les dépendances et construire
     mvn clean install
## Execution
1.  Dans l'Eclipse se positioner sur la class UnifiedIdTracerApplication et lancer l'application (Run As -> Java Application)
2.  Pour s'assurer de l'accessibilité des services, dans le navigateur lancer une requête :
    http://localhost:8080/api/idgeneration/help

   Si le service répond, la page affiche la description de deux services
## Test
Test effectuer avec Postman.

1. Test du service "configure"

   Paramètre d'appel :
   
   URL : http://localhost:8080/api/idgeneration/configure
   
   Methode : POST
   
   Headers : key=Content-Type , Value = application/json
     
   Body : choisir "raw" et  "JSON"
     
   Dans le body, ajouter un exemple JSON situé dans le fichier exemples_json.txt à la racine du projet.
   
   Lancer la requête. Le message "ID generation criteria configured successfully." doit apparaître.

3. Test du service "generate"

   Paramètre d'appel :
   
   URL : http://localhost:8080/api/idgeneration/generate
   
   Methode : POST
   
   Headers : key=Content-Type , Value = application/json
     
   Body : choisir "raw" et "JSON"
   
   Dans le body, ajouter un exemple JSON situé dans le fichier exemples_json.txt à la racine du projet.
   
   Lancer la requête. L'ID généré doit apparaître.


   
