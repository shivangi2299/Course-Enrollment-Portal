# Course Management System

The **Course Management System** is a web application designed to provide a platform similar to D2L (Desire2Learn) for managing courses, student accounts, events, and more. It is built using **Spring Boot** for the backend and **HTML/CSS/JavaScript** for the frontend. The application is deployed on an **AWS EC2 instance** and is accessible at [http://3.132.95.238:8585](http://3.132.95.238:8585) But it is very basic look of the application this application is modified and is made great as shown in image below.

<img width="1466" alt="index" src="https://github.com/user-attachments/assets/365aba51-783e-45d7-a0a4-b71983463103" />
<img width="1375" alt="SignUp" src="https://github.com/user-attachments/assets/70689ffa-8dd3-4b61-81db-719feda616e3" />
<img width="1323" alt="Login" src="https://github.com/user-attachments/assets/ba4f9fd8-267b-48c8-87bb-c5ebffceff13" />



---

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Running the Application](#running-the-application)
4. [Application Sections](#application-sections)
5. [Project Members](#project-members)
6. [Deployment](#deployment)
7. [Usage](#usage)
8. [Contributing](#contributing)

---

## Features
The Course Management System includes the following major sections:
- **Login / Sign-up**: Secure authentication for students and instructors.
- **Events**: Manage and view upcoming events.
- **Course Catalog**: Browse available courses.
- **Enrollment**: Enroll in courses.
- **Student Notes**: Take and manage notes for courses.
- **Course Detail Page**: View detailed information about a course.
- **Student Accounts**: Manage student profiles and accounts.
- **Discussion**: Participate in course-related discussions.
- **Profile**: Update personal information and preferences.
- **Renting Equipment**: Rent equipment for classes.
- **Advisors Appointment**: Schedule appointments with academic advisors.

---

## Technologies Used
- **Backend**: Spring Boot, H2 Database (for local development), AWS RDS (for production).
- **Frontend**: HTML, CSS, JavaScript.
- **Deployment**: AWS EC2, Docker (optional).
- **Version Control**: Git, GitHub.
- **Other Tools**: Postman (for API testing), Maven (for dependency management).

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 17 or higher.
- Maven (for building the project).
- A modern web browser (Chrome, Firefox, Edge, etc.).
- AWS account (for deployment).

### Running the Application
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/course-management-system.git
   cd course-management-system
2. **Build the Project**:
   ```bash
    Copy
    mvn clean install
3. **Run the Application**:
    bash
    Copy
    mvn spring-boot:run OR Run the Application directly.
5. **Access the Application**:
    Open your browser and navigate to http://localhost:8585.
## Application Sections

The application is divided into the following sections, each managed by a team member:

| Section                     | Managed By                  |
|-----------------------------|-----------------------------|
| Events, Student, User        | Patel Jay Rashmitbhai       |
| Advisor, Appointment         | Reddy Guntaka Satish Harshavardhan |
| Course Catalog, Enrollment, Student Notes | Puneeth Talluri |
| Course Details, Instructor, Student Accounts, Discussion | Patel Shivangi |
| Equipment, Rental            | Siddiqui Atif               |

---

## Deployment

The application is deployed on an **AWS EC2 instance** and is accessible at [http://3.132.95.238:8585](http://3.132.95.238:8585).

### Deployment Steps:
1. **Set up an EC2 Instance**:
   - Launch an EC2 instance on AWS.
   - Install Java, Maven, and any other required dependencies.

2. **Deploy the Application**:
   - Copy the built JAR file to the EC2 instance.
   - Run the application using:
     ```bash
     java -jar course-management-system.jar
     ```

3. **Configure Security Groups**:
   - Ensure port `8585` is open for inbound traffic.

---

## Usage

To use the application:
1. **Sign Up**: Create a new account using the **Sign-up** page.
2. **Login**: Use the following credentials to log in:
   - **Email**: `puneeth@gmail.com`
   - **Password**: `puneeth123`
3. **Explore**: Navigate through the various sections of the application using the homepage.

---

## Contributing

We welcome contributions to the Course Management System! To contribute:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes.
4. Submit a pull request.

---

## Project Members

| Name                                | Role                                      |
|-------------------------------------|-------------------------------------------|
| Patel Jay Rashmitbhai               | Events, Student, User                     |
| Reddy Guntaka Satish Harshavardhan  | Advisor, Appointment                      |
| Puneeth Talluri                     | Course Catalog, Enrollment, Student Notes |
| Patel Shivangi                      | Course Details, Instructor, Student Accounts, Discussion |
| Siddiqui Atif                       | Equipment, Rental                         |

---

## Acknowledgments

- Special thanks to our instructor and peers for their guidance and support.
- Built with ❤️ by the Course Management System team.
