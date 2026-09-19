# FoodOnlineShop

A Spring Boot backend for an online food-ordering and delivery platform, built as a project for a university **Object-Oriented Design** course. It models the core domain of a food-delivery service — customers, restaurants, menus, delivery couriers, orders and reviews — and persists it to a MySQL database through Spring Data JPA.

## Overview

The backend exposes a REST API (currently centered on user registration) on top of a layered domain model covering the full food-ordering workflow: customers browsing restaurant menus, placing orders, restaurants managing their menus, delivery couriers being assigned to orders, and customers reviewing restaurants/couriers afterwards. The entity and repository layers for this whole domain are implemented; the sign-up flow is fully wired end-to-end (controller → validation chain → persistence), while some higher-level business services (ordering, delivery allocation, reviews) are scaffolded and still under active development, which fits the project's purpose as a design-patterns exercise.

## Features

- **User registration (sign-up)** for three user types — `CUSTOMER`, `RESTAURANT`, `DELIVERY` — with server-side validation of username uniqueness, password strength, password confirmation match, email format/uniqueness and phone number format/uniqueness.
- **Password hashing** via Spring Security's `PasswordEncoder` before a user is persisted.
- **JWT-based session tokens** (HS384-signed) for encoding/decoding login credentials and validating an existing session against the database.
- **Domain model for the full ordering workflow**, modeled as JPA entities and Spring Data repositories: `User`, `Customer`, `Restaurant`, `DeliveryGuy`, `Menu`, `MenuItem`, `Order`, `OrderItem`, `Review`.
- **Order status lifecycle** defined via an `OrderStatus` enum (`Waiting_To_Confirm` → `Preparing_The_Order` → `Waiting_For_Accepting_Delivery_Guy` → `Delivering_To_Customer` → `Finished`).
- **Admin confirmation flag** on user accounts (`IS_CONFIRMED_BY_ADMIN`), used to gate sign-in until an account is approved.

## Tech Stack

- **Language / runtime:** Java 22
- **Framework:** Spring Boot 3.3.1 (Spring Web, Spring Data JPA, Spring Security)
- **Database:** MySQL (via `mysql-connector-java`, Hibernate `MySQL8Dialect`)
- **Auth:** JSON Web Tokens (`io.jsonwebtoken` / JJWT 0.11.5)
- **Build tool:** Maven (Maven Wrapper included — no local Maven install required)
- **Testing:** JUnit 5 / Spring Boot Test

## Design Patterns

As an Object-Oriented Design coursework project, the backend deliberately applies classic design patterns to its architecture:

- **Chain of Responsibility** — sign-up and sign-in requests pass through a configurable chain of validation handlers (`UserExistenceSignUpHandler` → `PasswordValidationHandler` → `PasswordConfirmationHandler` → `EmailValidationHandler` → `PhoneNumberValidationHandler` for sign-up; a parallel chain for sign-in), assembled in `SignUpHandlerConfig` / `SignInHandlerConfig`.
- **Facade** — `DatabaseFacade` exposes a single, unified interface over all the JPA repositories (users, customers, restaurants, menus, orders, reviews, delivery), so the service layer never talks to repositories directly.

## Project Structure

```
OnlineFoodBackend/
├── src/main/java/com/sut/ood/onlinefoodbackend/
│   ├── Contoller/
│   │   ├── Auth/                # JwtHandler – JWT creation/validation
│   │   ├── Configiration/       # Security config + handler-chain wiring
│   │   ├── Handlers/            # Chain-of-Responsibility validation handlers
│   │   ├── UserController.java  # REST endpoint: POST /user/signup
│   │   └── TestController.java  # REST endpoint: POST /test (connectivity check)
│   ├── Model/
│   │   ├── Customer/             # Customer, Order, OrderItem, Review + repositories
│   │   ├── DeliveryGuy/          # DeliveryGuy, DeliveryManagement, LiveLocation + repository
│   │   ├── Restaurant/           # Restaurant, Menu, MenuItem + repositories
│   │   ├── User/                 # User, UserManagement, sign-up/sign-in credentials + repository
│   │   ├── Enum/                 # UserType, OrderStatus, Response (result/status codes)
│   │   └── DatabaseFacade.java   # Facade over all repositories
│   └── OnlineFoodBackendApplication.java
├── src/main/resources/
│   ├── application.properties    # Server + datasource configuration
│   ├── Scripts.sql               # MySQL schema (DDL) for the full domain
│   └── SampleInserts.sql         # Example seed data
└── src/test/java/...              # Spring Boot test context
```

## Prerequisites

- JDK 22
- MySQL server (5.7+/8.x)
- Maven is **not** required to be installed separately — the project ships the Maven Wrapper (`mvnw` / `mvnw.cmd`)

## Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/ParsaEnayatiCE/foodonlineshop.git
   cd foodonlineshop/OnlineFoodBackend
   ```

2. **Create the database and schema**

   Create a MySQL database (the schema script also creates it if missing) and run the provided DDL script:
   ```bash
   mysql -u <your-user> -p < src/main/resources/Scripts.sql
   ```
   Optionally load the sample data in `src/main/resources/SampleInserts.sql` for local testing (note it targets sequence-based inserts and may need light adjustment for MySQL's `AUTO_INCREMENT` columns).

3. **Configure the datasource**

   Update `src/main/resources/application.properties` with your own MySQL connection details — do **not** reuse the placeholder credentials committed in the repo:
   ```properties
   server.port=1234
   spring.datasource.url=jdbc:mysql://<host>:3306/FoodShopDB
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   ```
   `spring.jpa.hibernate.ddl-auto=update` means Hibernate will also auto-create/update tables to match the entities on startup.

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   or build and run the jar:
   ```bash
   ./mvnw clean package
   java -jar target/OnlineFoodBackend-0.0.1-SNAPSHOT.jar
   ```
   The API is served at `http://localhost:1234` by default (per `server.port` above).

## Usage

### Register a new user

```
POST /user/signup
Content-Type: application/json

{
  "username": "johndoe",
  "password": "Password1",
  "passwordConfirmation": "Password1",
  "email": "john@example.com",
  "phoneNumber": "+989123456789",
  "userType": "CUSTOMER"
}
```

Password must be at least 8 characters and include an uppercase letter, a lowercase letter and a digit. `userType` must be one of `CUSTOMER`, `RESTAURANT`, `DELIVERY`. A `200 OK` is returned on success; validation failures return `400 Bad Request` with the failing field messages, and persistence failures return `500`.

### Connectivity check

```
POST /test
Content-Type: text/plain

hello
```
Echoes back `"<body> was received"` — useful for verifying the server is reachable.

## Running Tests

```bash
./mvnw test
```

## Notable Implementation Details

- **Security configuration** (`SecurityConfig`) currently permits all requests and disables CSRF/frame options — this is the state the project is in for local development while a frontend is integrated; a commented-out CORS-enabled variant is included in the same file as the intended production configuration.
- **JWT tokens** encode the username, password and email as claims and are validated by re-checking those claims against the database (`DatabaseFacade.CheckJwtCredentials`), rather than relying purely on signature validation.
- Several domain services (`CustomerManagement`, `DeliveryManagement`, `RegistryAdminManagement`, `RegistryCatalog`) currently define the intended API surface for ordering, delivery allocation and restaurant/delivery-guy admin approval, with the entity/repository layer fully in place; the business logic in these services is a work in progress.
