# Hands-on 6 – Criteria Query

## 📘 Objective
Understand how **Criteria Query** helps in dynamically building database queries based on user-selected filters.

---

## Scenario

Consider an online shopping website like **Amazon**.

A user searches:

```text
laptop
```

After searching, the user can apply filters such as:

- Customer Review
- Hard Disk Size
- RAM Size
- CPU Speed
- Operating System
- Weight
- CPU Type

The user may choose:
- one filter
- multiple filters
- or no filters

Example:

```text
RAM Size = 16GB
CPU = Intel i7
Operating System = Windows 11
```

---

## Problem with Normal HQL

In normal HQL:

```java
FROM Product p WHERE p.ramSize = :ram
AND p.cpu = :cpu
AND p.os = :os
```

Problem:
- Fixed query
- Difficult when filters are optional
- Need many combinations

Examples:
- only RAM selected
- only CPU selected
- RAM + CPU selected
- RAM + CPU + OS selected

This becomes complex.

---

## Solution: Criteria Query

Criteria Query helps build queries dynamically.

Instead of writing fixed HQL:

```java
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Product> cq = cb.createQuery(Product.class);
Root<Product> root = cq.from(Product.class);
```

Add conditions dynamically:

```java
List<Predicate> predicates = new ArrayList<>();

if(ramSize != null){
    predicates.add(cb.equal(root.get("ramSize"), ramSize));
}

if(cpu != null){
    predicates.add(cb.equal(root.get("cpu"), cpu));
}

if(os != null){
    predicates.add(cb.equal(root.get("operatingSystem"), os));
}

cq.where(predicates.toArray(new Predicate[0]));
```

---

## Dynamic Where Clause Example

If user selects:

```text
RAM = 16GB
CPU = Intel i7
OS = Windows 11
```

Generated where clause:

```sql
WHERE ram_size='16GB'
AND cpu='Intel i7'
AND operating_system='Windows 11'
```

---

If user selects:

```text
RAM = 8GB
Weight < 2kg
```

Generated where clause:

```sql
WHERE ram_size='8GB'
AND weight < 2
```

---

## Advantages of Criteria Query

✔ Dynamic query generation  
✔ Cleaner code  
✔ Better readability  
✔ No need to write multiple HQL statements  
✔ Easier maintenance  
✔ Supports optional filters

---

## Difference between HQL and Criteria Query

| HQL | Criteria Query |
|---|---|
| Fixed query | Dynamic query |
| String based | Object based |
| Hard to manage optional filters | Easy to manage |
| More error-prone | Type-safe |

---

## Real-world Use Cases

- Amazon product filtering
- Flipkart product search
- Employee search in HR system
- Student filtering in college portal
- Job filtering in placement portals

---

## Conclusion

Criteria Query is useful when query conditions change dynamically based on user input. It is best suited for filtering systems like e-commerce platforms where users can apply multiple optional filters.