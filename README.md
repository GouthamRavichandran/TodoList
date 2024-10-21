# Project Details

This project was built with Java 17 and Spring Boot 3.3.4 using Maven.

# To Run Project

1. To run this application, make sure to run the **pom.xml** first and download all the required node_modules.
2. The database used in for this application is H2 to make it light, portable and fast.
3. To create a user, start the application by running "**TodoListApplication**" java file. Next, please go to "**http://localhost:9090/h2**" and login using the credentials provided in **application.properties** file that has been **mailed** separately.
4. Then, run a query to add a user in the H2 console. Below is a sample query,

    INSERT INTO APP_USER (ID, USER_NAME, PASSWORD) VALUES ('1', 'demo', 'complex123');

5. Make sure to run the Angular application after this to view in browser.
