# StudentForm

A Java web application for managing student records, built with Maven and NetBeans. It provides a RESTful web service backed by a database through JDBC.

## Features

- Add new student records
- View student details
- Update and delete student records
- RESTful web service endpoints
- Database connectivity using JDBC

## Technologies Used

- Java [version, e.g. 8 / 11 / 17]
- Maven
- RESTful Web Services (JAX-RS)
- JDBC
- [Database, e.g. MySQL]
- [Server, e.g. Apache Tomcat / GlassFish Payara]
- NetBeans IDE

## Project Structure

```
StudentForm-1.0-SNAPSHOT
├── Web Pages                         # Frontend files (HTML, JSP, CSS)
├── Source Packages
│   ├── com.server.studentform        # Server-side logic and database connection
│   ├── com.server.studentform.resources  # REST resource classes
│   └── com.student                   # Student model/classes
├── Dependencies                      # Maven dependencies
└── pom.xml                           # Maven configuration
```

## Prerequisites

- JDK [version] or higher
- Apache Maven
- [Database] installed and running
- [Application server] installed
- NetBeans IDE (optional)

## Setup and Installation

1. **Clone the repository**
   ```
   git clone https://github.com/[your-username]/StudentForm.git
   ```

2. **Set up the database**
   - Create a database named `[database_name]`
   - Create the table:
     ```sql
     CREATE TABLE student (
         id INT PRIMARY KEY AUTO_INCREMENT,
         name VARCHAR(100),
         [other columns]
     );
     ```

3. **Configure the database connection**
   - Open the file where the JDBC connection is created
   - Update the URL, username, and password to match your database

4. **Open the project in NetBeans**
   - File → Open Project → select the `StudentForm` folder

5. **Build and run**
   - Right-click the project → **Clean and Build**
   - Right-click the project → **Run**

6. Open in your browser: `http://localhost:8080/StudentForm-1.0-SNAPSHOT/`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/[path]` | Get all students |
| POST   | `/[path]` | Add a new student |
| PUT    | `/[path]/{id}` | Update a student |
| DELETE | `/[path]/{id}` | Delete a student |

## Author

[Your Name]
GitHub: [@your-username](https://github.com/your-username)
