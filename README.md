# Spring-JPA-CRUD

A Spring Boot project demonstrating a complete CRUD application using JPA, H2 in-memory testing, and layered architecture (Model, Repository, Service). Includes clean code with Lombok annotations, Actuator monitoring, and unit tests with Mockito.

## Features

* ✅ Java 21 & Spring Boot
* ✅ CRUD operations for `Grocery` and `Store` entities
* ✅ Service layer abstraction and JPA repositories
* ✅ In-memory H2 testing and Mockito-based unit tests
* ✅ Exposed actuator endpoints for monitoring
* ✅ Uses Lombok to reduce boilerplate code

## Project Structure

```
src/
├── main/
│   ├── java/com/app/
│   │   ├── Model/          → JPA entities: Grocery, Store
│   │   ├── Repository/     → JpaRepository interfaces
│   │   ├── Service/        → Business logic for each entity
│   │   └── Application.java→ Main app entry point & demo
│   └── resources/
│       └── application.properties → Config & actuator setup
├── test/
│   └── java/com/app/
│       └── StoreServiceTestSuite.java → Unit tests (Mockito)
```

## How to Run

1. **Clone the repo**

   ```bash
   git clone https://github.com/SylverVB/BE-W10D1-Java-Spring-JPA-CRUD.git
   cd BE-W10D1-Java-Spring-JPA-CRUD
   ```

2. **Build & run the project**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Access actuator endpoints**
   Visit: `http://localhost:8080/actuator`

## Dependencies

* Spring Boot Starter Web, Data JPA, DevTools, Actuator
* Lombok (auto-generates getters/setters/etc.)
* Mockito + JUnit (for unit testing)
* H2 Database (in-memory testing)

## Sample Output

The `Application.java` demonstrates:

* Creating, retrieving, updating, and deleting groceries
* Creating and updating stores
* Sample output printed to console to trace entity state

## Testing

```bash
mvn test
```

* Tests core `StoreService` functionality using mocked `StoreRepository`
* Verifies method behavior, calls, and handles null-safe logic

## License

This project is open-source and available under the MIT License.