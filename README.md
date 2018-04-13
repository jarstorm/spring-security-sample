# spring-security-sample
This JWT sample is made using Spring Boot and Spring Security.

# Database
I'm using MySQL as database.
You could change connection data in application.properties file
Also I'm using Spring Data Jpa to execute queries to database.

# SQL initialization
Please use data.sql file to initialize your database. This will create a test/test user. User password is encrypted using BCrypt so if you want to cerate a new user please remember it.

# How to run
Just launch MainAppConfig class as a Java application. It will launch your server in http://localhost:8080

# How to log in the app
Make a POST call to http://localhost:8080/login?username=test&password=test

# How to try JWT
I created one simple method at http://localhost:8080/example/sayHello. You need to make the call with the token obtained in login process.

# How to test it
I created a simple JUnit test class called TestClient under src/test/java folder. It has different tests to login and test the JWT app.
