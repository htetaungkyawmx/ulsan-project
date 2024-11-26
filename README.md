
# BusanProject - User Management System

## Overview
The BusanProject is a Spring Boot-based application designed to provide:
- **User Registration** with Role Assignment
- **JWT-based Authentication**
- **Role-Based Access Control** for endpoints

It demonstrates a simple and secure way to manage users, roles, and permissions using Spring Security 6.

---

## Features
- **User Registration**: Register users with encrypted passwords.
- **Login Authentication**: Authenticate users and return a JWT token.
- **Role-Based Authorization**: Restrict access to specific endpoints based on user roles.
- **JWT Token Integration**: Secure API endpoints using JWT.

---

## Technologies Used
- **Spring Boot 3**: Backend framework for rapid development.
- **Spring Security 6**: Secure the application with authentication and authorization.
- **JWT (JSON Web Token)**: Stateless token-based authentication.
- **H2 Database**: Lightweight in-memory database for testing.
- **Hibernate**: ORM framework for database interactions.

---

## Endpoints Overview

| **Endpoint**                | **HTTP Method** | **Description**                              | **Authorization**     |
|-----------------------------|-----------------|----------------------------------------------|-----------------------|
| `/api/users/register`       | `POST`          | Register a new user                          | Public (No auth)      |
| `/auth/login`               | `POST`          | Authenticate user and return a JWT token     | Public (No auth)      |
| `/api/users/{username}/roles` | `GET`         | Retrieve roles of a specific user            | Requires `ROLE_ADMIN` |

---

## Setup and Installation

### Clone the Repository
```bash
git clone https://github.com/htetaungkyawmx/busanproject.git
cd busanproject
```

### Build the Project
Make sure you have **Java 17+** and **Maven** installed:
```bash
mvn clean install
```

### Run the Application
Start the application with:
```bash
mvn spring-boot:run
```

### Access the Application
- Base URL: `http://localhost:8080`
- **H2 Console** (if enabled): `http://localhost:8080/h2-console`

---

## Using Postman to Test

### Register a New User
- **URL**: `POST http://localhost:8080/api/users/register`
- **Body**:
  ```json
  {
      "username": "testuser",
      "password": "password123"
  }
  ```

### Login to Get JWT Token
- **URL**: `POST http://localhost:8080/auth/login`
- **Body**:
  ```json
  {
      "username": "testuser",
      "password": "password123"
  }
  ```

### Fetch User Roles
- **URL**: `GET http://localhost:8080/api/users/testuser/roles`
- **Headers**:
  ```
  Authorization: Bearer <JWT-TOKEN>
  ```

---

## Project Structure

```
src/main/java/org/mdt/busanproject
├── config                   # Spring Security configuration
├── controller               # REST controllers
├── entity                   # JPA entities for User, Role, Permission
├── provider                 # JWT token generation and validation
├── repository               # Repositories for User and Role
├── service                  # Service layer for business logic
└── BusanProjectApplication  # Main Spring Boot application class
```

---

## Database Structure

### Tables
1. **User Table**
   - Stores user details such as `username`, `password`, and associated roles.

2. **Role Table**
   - Stores roles such as `ROLE_USER`, `ROLE_ADMIN`.

3. **Permission Table**
   - Optional: Stores specific permissions assigned to roles.

### Relationships
- A **User** can have multiple **Roles** (Many-to-Many).
- A **Role** can have multiple **Permissions** (Many-to-Many).

---

## Configuration

### `application.properties`
```properties
# Server Configuration
server.port=8080

# H2 Database
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:busan
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

# JWT Configuration
jwt.secret=1cba37a2c7bc14bfe27585c2b40f368ce4e57b08f2a507932504e7e4cae38c7a4
jwt.expiration=3600000

# Logging
logging.level.org.springframework.security=DEBUG
```

---

## Future Enhancements
- Add Swagger API documentation.
- Implement refresh tokens for long-lived sessions.
- Integrate with a production-grade database (e.g., MySQL or PostgreSQL).

---

## License
This project is licensed under the MIT License.
