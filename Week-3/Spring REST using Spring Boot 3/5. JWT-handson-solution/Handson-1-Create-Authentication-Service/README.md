# Handson 1 – Create Authentication Service that Returns JWT

## 📘 Objective

The objective of this hands-on is to develop a secure authentication REST API using Spring Boot and Spring Security. The service authenticates users using HTTP Basic Authentication and generates a JSON Web Token (JWT), which can be used for accessing protected REST endpoints in subsequent hands-on exercises.

---

## 📁 Project Structure

```text
spring-learn/
├── pom.xml
├── src/main/java/com/cognizant/springlearn/
│   ├── SpringLearnApplication.java
│   ├── Country.java
│   ├── controller/
│   │   ├── AuthenticationController.java
│   │   └── CountryController.java
│   ├── service/
│   │   └── CountryService.java
│   └── security/
│       └── SecurityConfig.java
└── src/main/resources/
    ├── application.properties
    └── country.xml
```

---
# Implementation

## Step 1 – Create Spring Boot Project

Created a Maven-based Spring Boot project and added the required dependencies for:

- Spring Web
- Spring Security
- JWT (JJWT)

---

## Step 2 – Configure Spring Security

Configured Spring Security to:

- Disable CSRF
- Enable HTTP Basic Authentication
- Create two in-memory users:
  - admin / pwd
  - user / pwd

---

## Step 3 – Create Authentication Controller

Created an AuthenticationController that:

- Reads the Authorization header
- Extracts username from Basic Authentication
- Generates a JWT
- Returns the JWT in JSON format

---

## Step 4 – Generate JWT

Generated JWT using:

- HS256 Algorithm
- Secret Key
- Subject (Username)
- Issued Time
- Expiration Time

---

## Step 5 – Test using Postman

Authenticated using Basic Authentication:

Username:
user

Password:
pwd

Received JWT token successfully.

## 🎯 Key Concepts

| Concept | Description |
|---|---|
| JWT | JSON Web Token — secure token for authentication |
| `@EnableWebSecurity` | Enables Spring Security |
| `InMemoryUserDetailsManager` | In-memory users (admin, user) |
| `BCryptPasswordEncoder` | Encrypts passwords |
| `Keys.secretKeyFor()` | Generates secure 256-bit key for HS256 |
| `@RequestHeader` | Reads Authorization header from HTTP request |
| Base64 decode | Decodes Basic auth credentials |
| `Jwts.builder()` | Builds JWT with subject, issue time, expiry |

---

## 🔐 JWT Structure

```
eyJhbGciOiJIUzI1NiJ9        ← Header (algorithm)
.eyJzdWIiOiJ1c2VyIi...      ← Payload (user + expiry)
.yXD0XDYCBK0w31Kj...        ← Signature
```

---

## ▶️ How to Run

```bash
cd spring-learn
.\mvnw.cmd spring-boot:run
```

---

## 🌐 API Endpoint

| URL | Method | Auth | Response |
|---|---|---|---|
| `http://localhost:8083/authenticate` | GET | Basic (user/pwd) | JWT Token |

---

## ✅ Output

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzgzMjUxMjE4LCJleHAiOjE3ODMyNTI0MTh9.yXD0XDYCBK0w31KjNPmpJT..."
}
```

---

## 🖼️ Screenshots

## Codes
![Codes](code.png)


## Terminal Output
![Output](output.png)

# Testing
### Postman Configuration
![Postman](postman.png)


## browser-output1
![browser-output1](browser-output1.png)

## Browser-token response
![Browser-token-response](Browser-token-response.png)
