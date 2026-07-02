# Hands-on 1 – Introduction to HQL and JPQL

## 📘 Objective
Understand the difference between HQL and JPQL.

---

## What is HQL?
- HQL stands for **Hibernate Query Language**
- It is an object-oriented query language similar to SQL
- Instead of table names, it uses **Java class names**
- Instead of column names, it uses **Java field names**

---

## What is JPQL?
- JPQL stands for **Java Persistence Query Language**
- It is a subset of HQL
- Defined by the JPA specification

---

## Difference between HQL and JPQL

| Feature | HQL | JPQL |
|---|---|---|
| Full form | Hibernate Query Language | Java Persistence Query Language |
| Defined by | Hibernate | JPA Specification |
| SELECT | ✅ | ✅ |
| UPDATE | ✅ | ✅ |
| DELETE | ✅ | ✅ |
| INSERT | ✅ | ❌ |
| Portability | Hibernate only | Any JPA provider |

---

## Key Point
- All JPQL queries are valid HQL queries
- But reverse is NOT true
- HQL supports INSERT, JPQL does not

---

## Reference
- https://docs.jboss.org/hibernate/orm/4.3/devguide/en-US/html/ch11.html
- https://www.baeldung.com/spring-data-jpa-query