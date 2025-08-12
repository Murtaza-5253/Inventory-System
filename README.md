# 🛒 Inventory Management API

A backend REST API for managing products, categories, and stock in an inventory system. Built with **Java 17**, **Spring Boot**, and **MySQL**, this project follows a clean layered architecture using `Controller → Service → Repository`.

---

## 🚀 Features

- Add, view, update, and delete products (CRUD)
- RESTful APIs using Spring Boot
- Connected to MySQL with Spring Data JPA
- Clean 3-layer architecture
- Tested with Postman
- Easily extendable for categories, users, and roles

---

## 🧰 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Lombok**
- **Postman** for API testing

---

## 📦 API Endpoints

| Method | Endpoint            | Description              |
|--------|---------------------|--------------------------|
| GET    | `/api/products`     | Get all products         |
| POST   | `/api/products`     | Add a new product        |
| PUT    | `/api/products`     | Update a product         |
| DELETE | `/api/products/{id}`| Delete a product by ID   |

---

## Project Structure

src/main/java/com/mz/inventory
│── controller      # REST controllers
│── dto             # DTO classes
│── exception       # Custom exceptions
│── model           # JPA entities
│── repository      # Spring Data JPA repositories
│── service         # Service interfaces
│── service/impl    # Service implementations

src/main/resources
│── application.properties
│── data.sql (optional sample data)


---

## ⚙️ Setup Instructions

1. Clone the repo  
   `git clone https://github.com/Murtaza-5253/inventory-system.git`

2. Open in **IntelliJ** or your preferred IDE

3. Configure `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Run the application:
   - In IntelliJ: Run `InventorySystemApplication.java`
   - Or use terminal:  
     `./mvnw spring-boot:run`

5. Test APIs in **Postman**:
   - Use sample JSON:
     ```json
     {
       "name": "Keyboard",
       "category": "Electronics",
       "quantity": 10,
       "price": 999.99
     }
     ```

---

## 📌 To-Do (Optional Enhancements)

- Add input validation using `@Valid`
- Handle errors with global `@ControllerAdvice`
- Add Swagger documentation
- Implement role-based access (Admin/Staff)
- Add unit tests with JUnit and Mockito

---

## 👨‍💻 Author

**Murtuza Bohari**  
- GitHub: [@Murtaza-5253](https://github.com/Murtaza-5253)  
- LinkedIn: [Murtuza Bohari](https://www.linkedin.com/in/murtazabohari5253/)

---

## 📄 License

This project is licensed under the MIT License.
