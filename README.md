# CI_Project
Nathan DOLY - Lisa RAOUL - M2 Digital transformation - Cloud Integration Project

**Contexte :**
- Eshop (boutique en ligne de vêtements) avec des articles soldés et non soldés 

**Gestion des données :** 2 propositions
  - 1 fichier avec articles non soldés et 1 autre avec articles soldés
  - 1 fichier avec tous les articles soldés / non soldés, 1 fichier avec les articles non soldés et 1 autre avec articles soldés

**Fichiers de notre projet :**

sqlDatabase.xml
1. gateway
2. database (H2)
3. logger

But : aggréger les articles soldés par catégorie (par exemple, les articles életroménagers par consommation electrique; les vetements par couleurs etc)

filtering.xml
1. input file adapter
2. channel
3. message filter 
4. adding headers
5. logging channel

But : filtrer les vêtements en fonction d'une couleur en particulier


serviceActivator.xml
1. input file adapter
2. file to string transformer
3. channel
4. service activator (java program)
5. output file adapter

But : au bout d'un certain temps, 2 minutes, on passe tous les vêtements soldés en non soldés et inversement


routingAdvanced.xml
1. input file adapter
2. json to object transformer
3. channel
4. router:
  - service activator
	- channel
5. aggregator:
6. outbound file adapter
7. json conversion

But : on utilise un agregator pour rassembler dans un même fichier les vêtements soldés et non soldés