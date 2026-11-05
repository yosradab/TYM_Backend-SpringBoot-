# TYM — Train Your Mind · Backend Spring Boot

API REST de la plateforme **Train Your Mind (TYM)** : mise en relation entre **clients** et **spécialistes** (coachs, formateurs), réservation de séances, ateliers, contrats et messagerie en temps réel.

Projet de fin d'études (PFE, 2023). Le frontend Angular est ici : [TYM_Fontend-Angular-](https://github.com/yosradab/TYM_Fontend-Angular-).

## Fonctionnalités

- **Authentification JWT** : inscription, connexion, rôles (admin, client, spécialiste), mot de passe oublié
- **Gestion des utilisateurs** : clients, spécialistes, bannissement (`/ban-user`)
- **Réservations** (`/bookings`) et **agenda** des spécialistes (`/api`, calendrier)
- **Ateliers** (`/workshop`) : création et consultation
- **Contrats** (`/contracts`) entre clients et spécialistes
- **Candidatures** : dépôt de CV des spécialistes (`/DemandeCv`) avec upload de fichiers
- **Chat temps réel** : WebSocket + STOMP/SockJS (`/notification/message`)
- **E-mails** : envoi de mails, boîte de réception interne (`/mail`, `/mailbox`), **newsletter planifiée** (`@Scheduled`)
- Génération de **QR codes** (ZXing, `/user/qrcode`)
- Documentation de l'API avec **Swagger / OpenAPI**

## Stack technique

| Élément | Technologie |
|---|---|
| Langage | Java 8 |
| Framework | Spring Boot 2.7 (Web, Data JPA, Security, Mail, WebSocket, Validation) |
| Sécurité | Spring Security + JWT (jjwt) |
| Base de données | MySQL (H2 disponible pour les tests) |
| Temps réel | WebSocket, STOMP, SockJS |
| Documentation | springdoc-openapi, Swagger UI |
| Autres | Lombok, ZXing, Velocity, Thymeleaf |

## Architecture

```
src/main/java/tn/tym/esprit/
├── authentication/   # Inscription, connexion, mot de passe oublié
├── configuration/    # Sécurité, JWT, CORS, WebSocket, OpenAPI
├── controllers/      # Endpoints REST
├── entities/         # Entités JPA (User, Client, Specialist, Booking, Workshop, Contract…)
├── interfaces/       # Contrats des services
├── repositories/     # Spring Data JPA
├── services/         # Logique métier
└── utils/            # Pagination, newsletter planifiée, listeners WebSocket
```

## Lancer le projet

Prérequis : JDK 8+, Maven (ou le wrapper `mvnw`), MySQL.

1. Créer `src/main/resources/application.properties` (non versionné), par exemple :
   ```properties
   server.port=8075
   spring.datasource.url=jdbc:mysql://localhost:3306/tym?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.mail.host=smtp.gmail.com
   spring.mail.port=587
   spring.mail.username=<votre-email>
   spring.mail.password=<mot-de-passe-application>
   ```
   Le port `8075` est celui qu'attend le frontend Angular.
2. Lancer l'application :
   ```bash
   ./mvnw spring-boot:run
   ```
3. Swagger UI : http://localhost:8075/swagger-ui/index.html

## Auteur

**Yosra Dab** — Ingénieure logiciel Full Stack · [Portfolio](https://yosradab.vercel.app) · [GitHub](https://github.com/yosradab) · [LinkedIn](https://linkedin.com/in/yosradab)
