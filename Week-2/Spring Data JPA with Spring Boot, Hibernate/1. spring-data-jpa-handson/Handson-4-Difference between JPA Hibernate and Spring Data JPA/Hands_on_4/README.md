# Difference between JPA, Hibernate and Spring Data JPA

## 📘 Objective
Understand the relationship and differences between Java Persistence API (JPA), Hibernate, and Spring Data JPA — and compare how the same database operation is written using Hibernate versus Spring Data JPA.

---

## 🧱 Java Persistence API (JPA)

- JSR 338 Specification for persisting, reading, and managing data from Java objects
- Does **not** contain a concrete implementation of the specification — it's just a set of interfaces/rules
- Hibernate is one of the implementations of JPA (others include EclipseLink, OpenJPA)

---

## 🧱 Hibernate

- An **ORM (Object-Relational Mapping) Tool** that implements the JPA specification
- Provides the actual concrete classes (`Session`, `SessionFactory`, `Transaction`) that do the real work of mapping Java objects to database rows

---

## 🧱 Spring Data JPA

- Does **not** have its own JPA implementation — it sits on top of a JPA provider like Hibernate
- Reduces boilerplate code significantly — no need to manually open sessions, manage transactions, or write try/catch/finally blocks
- Another level of abstraction over the underlying JPA implementation (Hibernate)
- Manages transactions declaratively via `@Transactional`

---

## 🔍 Relationship Summary

```
JPA (Specification)
   ↓ implemented by
Hibernate (ORM Tool)
   ↓ abstracted further by
Spring Data JPA (removes boilerplate)
```

---

## 🧪 Code Comparison: Adding an Employee

### Using Hibernate (manual session/transaction management)

```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;

   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee);
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
   } finally {
      session.close();
   }
   return employeeID;
}
```

Notice everything that has to be managed manually: opening a session, beginning a transaction, catching exceptions, rolling back on failure, and closing the session in a `finally` block.

### Using Spring Data JPA (boilerplate removed)

**EmployeeRepository.java**
```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

**EmployeeService.java**
```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

Spring Data JPA handles session creation, transaction management, and exception handling internally. The developer only writes the interface (no implementation needed) and a one-line service method.

---

## 📊 Key Differences

| Aspect | JPA | Hibernate | Spring Data JPA |
|--------|-----|-----------|------------------|
| Type | Specification (JSR 338) | ORM implementation | Abstraction layer |
| Has implementation? | ❌ No | ✅ Yes | ❌ No (relies on Hibernate) |
| Boilerplate code | N/A | High (manual session/transaction) | Minimal (just interfaces) |
| Transaction management | Manual | Manual | Declarative (`@Transactional`) |
| Code to write for CRUD | N/A | Full session/transaction logic | Extend `JpaRepository`, done |

---

## ✅ Hands-on Requirements Met

| Requirement | Status |
|-------------|--------|
| Explain JPA as a specification | ✅ |
| Explain Hibernate as a JPA implementation | ✅ |
| Explain Spring Data JPA as an abstraction over Hibernate | ✅ |
| Compare code: Hibernate vs Spring Data JPA for adding an employee | ✅ |
| Reference links provided | ✅ |

---

## 🔗 Reference Links
- [What is the difference between Hibernate and Spring Data JPA](https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1)
- [What is JPA? Introduction to the Java Persistence API](https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html)