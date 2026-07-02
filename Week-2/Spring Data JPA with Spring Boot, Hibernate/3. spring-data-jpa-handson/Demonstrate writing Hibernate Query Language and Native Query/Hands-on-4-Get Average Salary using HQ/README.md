# Hands-on 4 – Get Average Salary using HQL

## 📘 Objective
Compute the average salary of a department using **HQL aggregate function AVG()**.

> ✅ This hands-on is implemented inside **Hands-on-2-Get all permanent employees using HQL** project.
> The code is part of the same `ormlearn` Spring Boot project.

---

## 🔹 HQL Query Used

```java
@Query(value = "SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
double getAverageSalary(@Param("id") int id);
```

---

## 🔹 Service Method

```java
@Transactional
public double getAverageSalary(int id) {
    LOGGER.info("Start");
    return employeeRepository.getAverageSalary(id);
}
```

---

## 🔹 Test Method

```java
private static void testGetAverageSalary() {
    LOGGER.info("Start");
    double avg = employeeService.getAverageSalary(1);
    LOGGER.debug("Average Salary of Department 1: {}", avg);
    LOGGER.info("End");
}
```

---

## 🔹 Key Notes

| Point | Detail |
|---|---|
| `AVG()` | HQL aggregate function |
| `:id` | Named parameter using `@Param` |
| `e.department.id` | Navigating relation from Employee to Department |
| Similar functions | `SUM()`, `COUNT()`, `MIN()`, `MAX()` |

---

## ✅ Output

```text
Average Salary of Department 1: 85000.0
```

---

## 📁 Actual Code Location

```
Hands-on-2-Get all permanent employees using HQL/
└── ormlearn/
    ├── src/main/java/com/cognizant/ormlearn/
    │   ├── repository/
    │   │   └── EmployeeRepository.java  ← getAverageSalary() here
    │   ├── service/
    │   │   └── EmployeeService.java     ← service method here
    │   └── OrmlearnApplication.java     ← testGetAverageSalary() here
```

---

## 🎯 Concepts Covered

- HQL Aggregate Functions
- Named Parameters with `@Param`
- Navigating entity relationships in HQL
- `@Transactional` for service layer