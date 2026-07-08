# Week 3 – Spring REST using Spring Boot 3

## 📘 Overview
This repository contains the solutions for **Week 3 – Spring REST using Spring Boot 3** of the Cognizant Digital Nurture 5.0 Java FSE Program.

---

## 📚 Learning Objectives
- Spring Boot Project Creation
- Maven Project Structure
- RESTful Web Services
- Spring MVC + Request Mapping
- JSON Response Generation
- Spring Bean XML Configuration
- Path Variables
- Controller → Service → DAO Architecture
- Spring Security + Basic Authentication
- JWT Authentication
- Postman API Testing
- Logging using SLF4J

---

## 📂 Folder Structure

```text
Week-3/
└── Spring REST using Spring Boot 3/
    ├── 1. spring-rest-handson-solution/
    │   ├── Handson-1-Create-Spring-Web-Project-using-Maven/
    │   │   └── spring-learn/
    │   └── Handson-2-Load-Country-from-Spring-Configuration-XML/
    │       └── spring-learn/
    │
    ├── 2. spring-rest-handson-solution/
    │   ├── Handson-1-Hello-World-RESTful-Web-Service/
    │   │   └── spring-learn/
    │   ├── Handson-2-REST-Country-Web-Service/
    │   │   └── spring-learn/
    │   └── Handson-3-REST-Get-Country-based-on-Country-Code/
    │       └── spring-learn/
    │
    ├── 3. spring-rest-handson-solution/
    │   └── Handson-1-Employee-Department-REST-Service/
    │       └── spring-learn/
    │
    └── 5. JWT-handson-solution/
        └── Handson-1-Create-Authentication-Service/
            └── spring-learn/
```

---

## ✅ Hands-on Summary

| Module | Hands-on | Topics Covered | Status |
|---|---|---|---|
| 1. spring-rest-handson | Create Spring Web Project using Maven | Spring Boot, Maven, Logging | ✅ Done |
| 1. spring-rest-handson | Load Country from Spring XML | XML Bean Config, ClassPathXmlApplicationContext | ✅ Done |
| 2. spring-rest-handson | Hello World RESTful Web Service | @RestController, @GetMapping | ✅ Done |
| 2. spring-rest-handson | REST - Country Web Service | JSON Response, @RequestMapping | ✅ Done |
| 2. spring-rest-handson | REST - Get Country by Code | @PathVariable, Case Insensitive Search | ✅ Done |
| 3. spring-rest-handson | Employee & Department REST Service | Controller→Service→DAO, XML Config | ✅ Done |
| 5. JWT-handson | JWT Authentication Service | Spring Security, JWT, Basic Auth | ✅ Done |

---

## 🌐 API Endpoints

| Endpoint | Method | Auth | Response |
|---|---|---|---|
| `/hello` | GET | None | `Hello World!!` |
| `/country` | GET | None | India country JSON |
| `/countries/{code}` | GET | None | Country by code |
| `/employees` | GET | Basic Auth | Employee list |
| `/departments` | GET | Basic Auth | Department list |
| `/authenticate` | GET | Basic Auth | JWT Token |

---

## 🔐 Authentication Credentials

```
Username : user
Password : pwd
```

---

## ▶️ How to Run Any Project

```bash
cd <handson-folder>/spring-learn
.\mvnw.cmd spring-boot:run
```

Server starts on: `http://localhost:8083`

---

## 🛠️ Tech Stack

| Technology | Version |
|---|---|
| Java | 17+ |
| Spring Boot | 4.1.0 |
| Spring Security | Latest |
| JJWT | 0.11.5 |
| Maven | 3.9.x |
| Embedded Tomcat | 11.0.22 |

---

## 👩‍💻 Author

**Lucky Sharma**

Superset ID: 8009333

B.Tech – Computer Science & Engineering

KIIT University

Cognizant Digital Nurture 5.0 – Java FSE