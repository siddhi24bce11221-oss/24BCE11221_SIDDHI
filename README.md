#  Inventory Management System

A Spring Boot + MongoDB project for managing categories, products, suppliers, and warehouses with CRUD operations.

##  Technologies Used
- Java 17
- Spring Boot
- MongoDB
- Lombok
- Postman (API testing)
- Swagger UI

##  Features Implemented
- **CRUD Operations** for Products, Categories, Suppliers, and Warehouses
- **Product APIs**
  - `GET /products/search/{name}` → Search products by name
  - `GET /products/count` → Get total product count
  - `GET /products/sort/asc` → Sort products by price (ascending)
  - `GET /products/sort/desc` → Sort products by price (descending)
- **Validation**
  - Ensures product name is not empty
  - Price must be positive
  - Quantity must be non‑negative
- **Exception Handling**
  - `ResourceNotFoundException` for invalid IDs
  - `GlobalExceptionHandler` for clean error responses

##  Project Structure
- `src/` → Source code (controllers, models, repositories, services)
- `exception/` → Custom exceptions and global handler
- `application.properties` → MongoDB connection config
- `pom.xml` → Maven dependencies
- `Screenshots.pdf` → CRUD operation outputs
-  OTHER API'S like search, count ,sort
- `Postman_Collection.json` → API testing collection

##  How to Run
1. Clone or download the repository.
2. Open the project in **Spring Tool Suite (STS)** or **VS Code**.
3. Configure MongoDB in `application.properties`:

##   Run the project using:
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
or use the IDE’s Run button.

##  API Endpoints
- **Products**
- `POST /products` → Create product
- `GET /products` → Get all products
- `GET /products/{id}` → Get product by ID
- `PUT /products/{id}` → Update product
- `DELETE /products/{id}` → Delete product
- Similar endpoints exist for **Categories**, **Suppliers**, and **Warehouses**.
- Search, Count, Sort endpoints for Products
- Validation and exception handling responses

##  Author
**Siddhi (24BCE11221)**  
B.Tech Computer Science  
Inventory Management Project – June 2026
