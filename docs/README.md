# Projet Atelier Intégration des Données TRDE703
## Groupe M1 EISI
Léa Guechoum ,Axel Poidebard ,Michael Picard

## Lien gitlab

https://gitlab.com/guechoum-poidebard-picard/trde703-guechoum-poidebard-picard

## Description 

Mettre en place une solution ETL chargée de collecter les données depuis un Datalake ou
une source de données massives permettant de répondre à une problématique métier
exposée.

## Stack technique

* ETL : Apache Spark
* Java (sdk : 17)
* Database : 
    * MangoDB (8.2.1)
    * Postgres (17.4)

## Dataset

Nous allons utiliser le dataset de openfoodfacts

- https://world.openfoodfacts.org/data

## Livrables

- [ ] Repo Git
- [ ] Pipeline Spark
- [ ] Datamarts MySQL
- [ ] Scripts DDL/DML
- [ ] Jeu de requêtes analytiques
- [ ] Note d'architecture : choix techniques ,schémas, stratégie d'upsert


## Setup Mango & Postgres

Dans le dossier database/preprod/mango & database/preprod/postgres, lancer les docker-compose en modifiant les .env .

Voir les .env.example .

```docker-compose
docker compose up -d
```

## Pour l'Intellij 

Pour l'utilisation de spark il nous faut mettre en place un configuration pour build et éxécuter le projet.

Ajouter la variable d'environnement dans Intellij
```
--add-opens=java.base/sun.security.action=ALL-UNNAMED
```

## Glossaire

- Table de fait : Ce qu'on souhaite analyser
- Table de dimmensions : Ce qui permet d'expliquer la table de fait
- Datamart : Données destinées à un groupe
- DDL : Data Definition Language
- DML : Data Manipulation Language
