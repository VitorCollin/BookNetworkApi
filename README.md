# 📚 Book Network API

Book Network API is a RESTful application built with **Java and Spring Boot** to manage a simple library system.
It allows the creation and management of **users**, **books**, and **loans**, following good backend development practices.

This project was developed for **portfolio and learning purposes**, focusing on clean architecture, validation, and proper entity relationships.

---

## 🚀 Features

* User management (Create, Read, Delete)
* Book management (Create, Read, Delete)
* Loan management (Create, Read, Delete)
* Business rules for book availability
* Input validation with Jakarta Validation
* Swagger/OpenAPI documentation
* In-memory database using H2

> ⚠️ Note: Update operation is intentionally not implemented.

---

## 🛠 Technologies Used

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Swagger (Springdoc OpenAPI)
* ModelMapper
* Maven

---

## 🏗 Project Structure

```
src/main/java/com/vitor/bookNetwork_api
├── controllers
├── services
├── repositories
├── models
├── DTOs
├── exceptions
└── config
```

---

## ⚙️ How to Run the Project

### Prerequisites

* Java 17+
* Maven

### Steps

```bash
git clone https://github.com/your-username/book-network-api.git
cd book-network-api
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

## 📄 API Documentation (Swagger)

Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

Use Swagger to test all endpoints and view request/response models.

---

## 🗄 Database

* H2 in-memory database
* Automatically created at application startup
* Data is reset when the application stops

Optional H2 Console:

```
http://localhost:8080/h2-console
```

Default settings:

* JDBC URL: `jdbc:h2:mem:testdb`
* Username: `sa`
* Password: (empty)

---

## 📌 Business Rules

* A book can only be loaned if it is available
* When a loan is created, the book becomes unavailable
* A loan must always be associated with an existing user and book

---

## 📦 Example JSON Requests

### Create User

```json
{
  "name": "John Doe",
  "email": "john.doe@email.com"
}
```

### Create Book

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "category": "Software Engineering"
}
```

### Create Loan

```json
{
  "userId": 1,
  "bookId": 1
}
```

---

## 📈 Future Improvements

* Implement Update (PUT/PATCH) operations
* Add pagination and sorting
* Improve exception handling with custom responses
* Add authentication and authorization (Spring Security)
* Replace ModelMapper with MapStruct

---

## 👤 Author

Developed by **Vitor Hugo de Faria Collin**
📌 Java Backend Developer (Spring Boot)

---

## 📄 License

This project is open for learning and portfolio purposes.
