1. Clone the repository
git clone https://github.com/LUC1F3R-666/user-management-service.git
cd user-management-service

2. Build the project
   
mvn clean install
This will:
compile the code
run tests
package the application

3. Run the Spring Boot application

./mvnw spring-boot:run

OR

mvn spring-boot:run

4. Access the application
API Base URL:
http://localhost:8080

5. Access H2 Database Console

Open in browser:

http://localhost:8080/h2-console

Login details:
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)

6. API Usage (using cURL)
Create User (POST)
curl -X POST http://localhost:8080/user \
-H "Content-Type: application/json" \
-d '{"name":"John","email":"john@test.com"}'

Get All Users (GET)
curl http://localhost:8080/user

Search Users (Pagination + Search)
curl "http://localhost:8080/user/search?query=jo&page=0&size=5"

Get User by ID
curl http://localhost:8080/user/1

7. Run using Docker
Build Docker image
docker build -t user-management-service .

Run Docker container
docker run -p 8080:8080 user-management-service

Access application (Docker)
http://localhost:8080

Test APIs (Docker same as above)

Use the same cURL commands:

curl http://localhost:8080/user

Notes:
H2 database is in-memory, data resets on restart
Docker runs the app in an isolated environment
Default port: 8080
