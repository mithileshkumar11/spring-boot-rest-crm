# Project Name spring-boot-rest-crm

# Used Application Technologies.
JAVA VERTION-17
SPRING BOOT VERSION-3.3.3
POSTGRESQL DB VERSION-15
JWT VERSION-0.11.5

# Database Configuration
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.url=jdbc:postgresql://localhost:5433/crmdb 

# APIs
# APIs CREATE USER

curl --location 'http://localhost:8080/api/v1/auth/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"Anil",
    "lastName":"Kumar",
    "mobile":9087656787,
    "email": "anil@gmail.com",
    "password": "12345"
}'


# APIs LOGIN USER 
curl --location 'http://localhost:8080/api/v1/auth/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "mithilesh@gmail.com",
    "password": "12345"
}'

