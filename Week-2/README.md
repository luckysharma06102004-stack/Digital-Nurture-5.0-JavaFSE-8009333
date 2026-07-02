# Week 2 – Spring Data JPA, Hibernate, Spring Core & Maven

## 📘 Overview

This repository contains all the **Week-2 hands-on exercises** for learning:

- Spring Core
- Maven
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- Object Relational Mapping (O/R Mapping)
- HQL (Hibernate Query Language)
- Native Queries
- Criteria Queries

The folder structure is organized module-wise so anyone opening this week can easily understand what was implemented.

---

# 📂 Folder Structure

```text
Week-2
│
├── Spring Core and Maven
│   ├── exercise_1
│   ├── exercise_2
│   ├── exercise_4
│   ├── exercise_5
│   ├── exercise_7
│   └── exercise_9
│
└── Spring Data JPA with Spring Boot, Hibernate
    │
    ├── 1. spring-data-jpa-handson
    │   ├── Handson-1-Spring Data JPA Quick Example
    │   ├── Handson-4-Difference between JPA Hibernate and Spring Data JPA
    │   ├── Handson-5-Implement services for managing Country
    │   ├── Handson-6-Find a country based on country code
    │   └── Handson-7-Add a new country
    │
    ├── 2. spring-data-jpa-handson
    │   ├── Demonstrate implementation of O-R Mapping
    │   │   ├── Handson-3-Payroll Bean Mapping
    │   │   ├── Handson-4-Implement Many-to-One
    │   │   ├── Handson-5-Implement One-to-Many
    │   │   └── Handson-6-Implement Many-to-Many
    │   │
    │   └── Demonstrate implementation of Query Methods
    │       ├── Handson-1-Query Methods Country
    │       └── Handson-2-Query Methods Stock
    │
    └── 3. spring-data-jpa-handson
        └── Demonstrate writing Hibernate Query Language and Native Query
            ├── Hands-on-1-Introduction to HQL and JPQL
            ├── Hands-on-2-Get all permanent employees using HQL
            ├── Hands-on-3-Fetch Quiz Attempt using HQL
            ├── Hands-on-4-Get Average Salary using HQL
            ├── Hands-on-5-Get all employees using Native Query
            └── Hands-on-6-Criteria Query
```

---

# Module 1 – Spring Core and Maven

This module covers Spring basics.

## Exercises covered:

| Exercise | Topic |
|---|---|
| Exercise 1 | Configuring a Basic Spring Application |
| Exercise 2 | Implementing Dependency Injection |
| Exercise 4 | Creating and Configuring a Maven Project |
| Exercise 5 | Configuring the Spring IoC Container |
| Exercise 7 | Constructor and Setter Injection |
| Exercise 9 | Creating a Spring Boot Application |

---

# Module 2 – Spring Data JPA Basics

This module covers the basics of JPA with Spring Boot.

## Hands-ons covered:

| Hands-on | Topic |
|---|---|
| Handson-1 | Spring Data JPA Quick Example |
| Handson-4 | Difference between JPA, Hibernate and Spring Data JPA |
| Handson-5 | Implement services for managing Country |
| Handson-6 | Find Country by Code |
| Handson-7 | Add New Country |

### Concepts covered:

- Entity Mapping
- Repository Layer
- Service Layer
- Transactions
- CRUD operations
- Exception Handling

---

# Module 3 – O/R Mapping

This module demonstrates relationship mapping between entities.

## Hands-ons covered:

| Hands-on | Mapping Type |
|---|---|
| Handson-3 | Basic Payroll Bean Mapping |
| Handson-4 | Many-to-One Mapping |
| Handson-5 | One-to-Many Mapping |
| Handson-6 | Many-to-Many Mapping |

### Relationships implemented:

```text
Employee → Department (Many-to-One)
Department → Employee (One-to-Many)
Employee ↔ Skill (Many-to-Many)
```

---

# Module 4 – Query Methods

Spring Data JPA custom query methods.

## Hands-ons:

| Hands-on | Topic |
|---|---|
| Handson-1 | Country Query Methods |
| Handson-2 | Stock Query Methods |

Concepts:

- Derived query methods
- Custom repository methods
- Filtering records

---

# Module 5 – HQL, Native Query & Criteria Query

Advanced querying module.

## Hands-ons:

| Hands-on | Topic |
|---|---|
| HO-1 | Introduction to HQL and JPQL |
| HO-2 | Get all permanent employees using HQL |
| HO-3 | Fetch Quiz Attempt using HQL |
| HO-4 | Get Average Salary using HQL |
| HO-5 | Get all employees using Native Query |
| HO-6 | Criteria Query |

---

## Concepts covered:

### HQL

Examples:

```java
SELECT e FROM Employee e WHERE e.permanent = true
```

```java
SELECT AVG(e.salary) FROM Employee e
```

---

### Native Query

Examples:

```java
SELECT * FROM employee
```

---

### Criteria Query

Used for dynamic filtering like:

- Amazon product search filters
- Salary filters
- Employee filters

Example:

```java
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
```

---

# Database Used

MySQL Database:

```sql
ormlearn
```

Contains:

- country
- employee
- department
- skill
- employee_skill
- quiz related tables

---

# Tech Stack

| Technology | Version |
|---|---|
| Java | 20 |
| Spring Boot | 3.5.16 |
| Spring Data JPA | 3.5.x |
| Hibernate ORM | 6.6.x |
| MySQL | 8.0 |
| Maven | 3.9.16 |

---

# How to Run

Go inside any project:

```bash
cd ormlearn
```

Run:

```bash
mvn clean spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

# Important Notes

- Each hands-on is separated into its own folder.
- Every folder contains:
  - Source code
  - README.md
  - Code screenshots
  - Output screenshots
- Folder names are kept according to Cognizant handson names for easy reference.

---

# Status

## Completed:

✅ Spring Core and Maven  
✅ Spring Data JPA Basics  
✅ O/R Mapping  
✅ Query Methods  
✅ HQL  
✅ Native Query  
✅ Criteria Query  

Week-2 implementation completed successfully.