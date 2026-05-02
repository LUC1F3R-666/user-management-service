User Management Service

A Spring Boot REST API for managing users, with support for Docker-based deployment using PostgreSQL and local execution using H2.

Overview

This service provides basic user management functionality including create, read, update, delete, and search operations. It supports two modes of execution:

Local mode using H2 in-memory database
Docker mode using PostgreSQL
Technology Stack
Java 21
Spring Boot 3
Spring Data JPA
H2 Database (local)
PostgreSQL (Docker)
Maven
Docker and Docker Compose
Running the Application
1. Clone the repository
git clone <repository-url>
cd user-management-service

2. Build the application
mvn clean install -DskipTests

3. Run locally (H2 database)
./mvnw spring-boot:run


Access:

Application: http://localhost:8080
H2 Console: http://localhost:8080/h2-console
4. Run with Docker (PostgreSQL)
docker-compose up --build


Services:

Application: http://localhost:8080
PostgreSQL: localhost:5433
API Endpoints
Health Check
GET /hello

Create User
POST /user


Request body:

{
  "name": "John",
  "email": "john@test.com"
}

Get All Users
GET /user?page=0&size=10

Get User by ID
GET /user/{id}

Search Users
GET /user/search?query=john

Update User (Full)
PUT /user/{id}


Request body:

{
  "name": "John Updated",
  "email": "john.updated@test.com"
}

Partial Update
PATCH /user/{id}


Request body:

{
  "email": "new@test.com"
}

Delete User
DELETE /user/{id}

Sample cURL Commands
Create User
curl -X POST http://localhost:8080/user \
-H "Content-Type: application/json" \
-d '{"name":"John","email":"john@test.com"}'

Get Users
curl http://localhost:8080/user

Search Users
curl "http://localhost:8080/user/search?query=john"

Notes
H2 is used for local development and testing
PostgreSQL is used when running via Docker
Configuration determines which database is active
Postman Usage

Create a collection named User Management Service and add the following requests.

Base URL
http://localhost:8080

Create User
Method: POST
URL: /user
Body (JSON):
{
  "name": "John",
  "email": "john@test.com"
}

Get All Users
Method: GET
URL: /user?page=0&size=10
Get User by ID
Method: GET
URL: /user/1
Search Users
Method: GET
URL: /user/search?query=john
Update User
Method: PUT
URL: /user/1
Body:
{
  "name": "Updated Name",
  "email": "updated@test.com"
}

Patch User
Method: PATCH
URL: /user/1
Body:
{
  "email": "patch@test.com"
}

Delete User
Method: DELETE
URL: /user/1
