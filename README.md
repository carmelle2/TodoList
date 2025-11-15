README — TodoList Application (Spring Boot)
 Overview

This project is a TodoList application built with Spring Boot.
It provides basic task-management features such as creating, updating, deleting, and retrieving tasks.
The project follows a clean and scalable architecture suitable for future extensions.

Features

Add a new task

Mark task as completed / not completed

Edit an existing task

Delete a task

Get all tasks

Full REST API

 Technologies Used

Java

Spring Boot

Spring Web

Spring Data JPA

Database  MySQL

Maven 

Installation & Run

Clone the repository:

git clone https://github.com/carmelle2/TodoList.git


Navigate into the project folder:

cd <repository>


Start the application:

mvn spring-boot:run


or

./mvnw spring-boot:run

 API Endpoints (examples)

GET /tasks — Retrieve all tasks

POST /tasks — Create a task

PUT /tasks/{id} — Update a task

DELETE /tasks/{id} — Delete a task

 Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

 License

This project is released under the MIT License.
