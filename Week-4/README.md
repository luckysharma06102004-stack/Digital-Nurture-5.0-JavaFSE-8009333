# Week 4 – Microservices with Spring Boot and Spring Cloud

## Overview

This week focuses on building a microservices-based application using Spring Boot and Spring Cloud. The exercises demonstrate how to create independent microservices, register them with a Eureka Discovery Server, and expose them through a centralized Spring Cloud API Gateway.

---

## Learning Objectives

- Understand Monolithic vs Microservices Architecture
- Create independent Spring Boot microservices
- Register microservices with Eureka Discovery Server
- Implement Service Discovery using Spring Cloud Netflix Eureka
- Route requests through Spring Cloud API Gateway
- Implement a Global Filter for centralized request logging

---

## Technology Stack

- Java 17
- Spring Boot
- Spring Cloud
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- Spring Web
- Maven
- VS Code

---

# Hands-on Exercises

## Handson 1 – Creating Microservices for Account and Loan

### Objective

Create two independent Spring Boot microservices:

- Account Service
- Loan Service

Each microservice runs independently on its own port.

### Features

- Account REST API
- Loan REST API
- Independent deployment
- Separate Maven projects
- RESTful Web Services

### Endpoints

| Service | Endpoint |
|----------|----------|
| Account | `GET /accounts/{number}` |
| Loan | `GET /loans/{number}` |

### Ports

| Service | Port |
|----------|------|
| Account | 8080 |
| Loan | 8081 |

📂 Folder

```
Handson-1-Creating-Microservices-Account-and-Loan/
```

---

## Handson 2 – Eureka Discovery Server

### Objective

Create a Eureka Discovery Server and register the Account and Loan microservices.

### Components

- Eureka Discovery Server
- Account Service
- Loan Service

### Ports

| Service | Port |
|----------|------|
| Eureka Server | 8761 |
| Account | 8080 |
| Loan | 8081 |

### Features

- Service Registration
- Service Discovery
- Dynamic Service Lookup
- Eureka Dashboard

📂 Folder

```
Handson-2-Eureka-Discovery-Server/
```

---

## Handson 3 – Spring Cloud API Gateway

### Objective

Create a Spring Cloud API Gateway that routes requests to a microservice registered with Eureka Discovery Server.

### Components

- Eureka Server
- Greet Service
- API Gateway
- Global Logging Filter

### Ports

| Service | Port |
|----------|------|
| Eureka Server | 8761 |
| Greet Service | 8080 |
| API Gateway | 9090 |

### Endpoint

```
GET /greet
```

### Features

- Dynamic Routing
- Service Discovery
- API Gateway
- Global Filter
- Request Logging

📂 Folder

```
Handson-3-Spring-Cloud-API-Gateway/
```

---

# Folder Structure

```
Week-4/
└── 2. Microservices with API gateway/
    ├── Handson-1-Creating-Microservices-Account-and-Loan/
    │   ├── account/
    │   ├── loan/
    │   └── README.md
    │
    ├── Handson-2-Eureka-Discovery-Server/
    │   ├── account/
    │   ├── loan/
    │   ├── eureka-discovery-server/
    │   └── README.md
    │
    └── Handson-3-Spring-Cloud-API-Gateway/
        ├── api-gateway/
        ├── eureka-server/
        ├── greet-service/
        └── README.md
```

---

# Concepts Covered

- Microservices Architecture
- RESTful Web Services
- Spring Boot
- Spring Cloud
- Eureka Discovery Server
- Eureka Client
- Service Registration
- Service Discovery
- Spring Cloud Gateway
- Global Filters
- Request Logging

---

# Skills Acquired

- Creating Spring Boot REST APIs
- Developing Independent Microservices
- Service Registration using Eureka
- Dynamic Service Discovery
- API Gateway Configuration
- Request Routing
- Centralized Logging
- Maven Project Management

---

# Result

Successfully implemented a complete Microservices architecture using Spring Boot and Spring Cloud, including:

- Independent Account and Loan Microservices
- Eureka Discovery Server
- Service Registration and Discovery
- Spring Cloud API Gateway
- Global Request Logging Filter
- Dynamic Request Routing

All hands-on exercises were successfully completed and verified.

---

## Repository Structure

```
Digital-Nurture-5.0-JavaFSE-8009333
└── Week-4
    └── 2. Microservices with API gateway
        ├── Handson-1-Creating-Microservices-Account-and-Loan
        ├── Handson-2-Eureka-Discovery-Server
        └── Handson-3-Spring-Cloud-API-Gateway
```

---

## Status

| Hands-on | Status |
|----------|--------|
| Handson 1 – Creating Microservices | ✅ Completed |
| Handson 2 – Eureka Discovery Server | ✅ Completed |
| Handson 3 – Spring Cloud API Gateway | ✅ Completed |

# Overall Status

**✅ Week 4 Completed Successfully**