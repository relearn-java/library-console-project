# Library Console

Application console de gestion de bibliothèque municipale.

## Contexte

Projet personnel de révision et de mise en pratique. L'objectif est de :

- Revoir les bases de la programmation Java (POO, collections, streams, exceptions)
- Travailler avec du Java moderne (Java 21 : records, pattern matching, sealed classes)
- Appliquer les bonnes pratiques de développement (architecture en couches, tests, Git)
- Construire un projet complet, étape par étape, jusqu'à une application fullstack

Ce projet n'est pas un tutoriel suivi ligne par ligne. C'est un terrain d'expérimentation
pour consolider des acquis et découvrir de nouveaux concepts.

## Roadmap

- [x] V1 - Modélisation de la base de données
- [x] V1 - Entités du domaine (records + enums)
- [x] V1 - Repositories en mémoire
- [ ] V1 - Couche service (logique métier)
- [ ] V1 - Interface console
- [ ] V1 - Tests unitaires
- [ ] V2 - Persistance PostgreSQL (JDBC puis JPA)
- [ ] V3 - API REST Spring Boot
- [ ] V4 - Frontend Angular
- [ ] V5 - Docker + CI/CD

## Stack

- Java 21 (LTS)
- Maven
- JUnit 5
- PostgreSQL (à partir de la V2)
- Spring Boot (à partir de la V3)
- Angular (à partir de la V4)

## Architecture

Le projet suit une architecture en couches :

\`\`\`
com.library
├── domain        ← Entités métier (records, enums)
├── repository    ← Interfaces d'accès aux données
│   └── inmemory  ← Implémentations en mémoire (V1)
├── service       ← Logique métier
├── ui            ← Interface utilisateur (console pour la V1)
└── Main.java     ← Point d'entrée
\`\`\`

Chaque couche ne dépend que de la couche inférieure, via des interfaces.
Cela permet de remplacer une implémentation (ex: mémoire → PostgreSQL)
sans toucher au reste du code.

## Comment lancer

\`\`\`bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.library.Main"
\`\`\`

## Comment tester

\`\`\`bash
mvn test
\`\`\`