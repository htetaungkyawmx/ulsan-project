AIOCEANEYE: Tuna Fish Group Detection
AIOCEANEYE is a web application designed to detect tuna fish groups using drone technology. It features role-based authentication, with access tailored to different user roles including Admin, Pilot, Captain, Guest, and Company. Each role is assigned a unique dashboard with custom functionality, ensuring a personalized and secure experience.

Table of Contents
Project Overview
Project Structure
Features
Technologies Used
Prerequisites
Setup Instructions
API Endpoints
Contributing
License
Acknowledgements
Project Overview
AIOCEANEYE leverages advanced drone technology to monitor and detect tuna fish groups. It supports multiple user roles, with each role being directed to different pages after authentication. Whether you're an Admin, Pilot, Captain, Guest, or Company user, the platform ensures a seamless, secure, and intuitive experience.

Project Structure
Frontend (React.js)
Login Form: A login page where users input their credentials and select their role. The role is automatically detected based on the email domain.
Dashboard: Role-based redirection sends users to the correct dashboard (e.g., Admin, Pilot, Captain, etc.).
UI Library: Built with CoreUI for responsive layout components and @coreui/icons-react for icons.
Backend (Spring Boot)
Role-based Authentication: Validates user credentials and assigns roles based on the email domain (e.g., admin.co.kr → Admin, pilot.co.kr → Pilot).
Role-Based Redirection: After login, users are redirected to role-specific endpoints.
Security: API endpoints are secured using Spring Security, ensuring sensitive data protection.
Features
Role Detection: Automatically assigns user roles based on email domains. For example:
admin.co.kr → Admin
pilot.co.kr → Pilot
captain.co.kr → Captain
User Authentication: Secure login system with email and password.
Role-Based Dashboards: Separate dashboards for each user role, including Admin, Pilot, Captain, Guest, and Company.
Feedback Messages: Clear success and error messages displayed after login attempts, ensuring users are informed about the login status.
Technologies Used
Frontend
React.js: A powerful JavaScript library for building user interfaces.
CoreUI: A UI component library for React, providing pre-designed elements and layouts.
React Router: For navigation between different views.
Axios / Fetch API: For making HTTP requests to the backend API.
Backend
Spring Boot: A Java-based framework for building production-grade backend applications.
Spring Security: Manages user authentication and role-based authorization.
REST API: To communicate between the frontend and backend.
Java 11+: The programming language used for the backend.
JPA/Hibernate: For seamless database interaction and ORM functionality.
Prerequisites
Before running the project, ensure you have the following installed:

Node.js (for frontend development)
Java 11+ (for backend development)
Maven (for backend build automation)
MySQL (or a preferred database)
Setup Instructions
1. Clone the Repository
Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/busan_project/busan_project.git
Navigate into the project directory:

bash
Copy code
cd aioceane-eye
2. Frontend Setup (React)
Install Frontend Dependencies
Navigate to the frontend directory and install the required dependencies:

bash
Copy code
cd frontend
npm install
Run the Frontend
Start the React development server:

bash
Copy code
npm start
This will launch the frontend on http://localhost:3000.

3. Backend Setup (Spring Boot)
Install Backend Dependencies
Navigate to the backend directory:

bash
Copy code
cd backend
Build the project using Maven:

bash
Copy code
mvn clean install
Run the Backend
Start the Spring Boot backend:

bash
Copy code
mvn spring-boot:run
The backend will be available at http://localhost:8080.

4. Database Configuration
Ensure that MySQL is running and configure the database connection in application.properties (or application.yml):

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/aioceane
spring.datasource.username=root
spring.datasource.password=root
Adjust the database credentials as needed to match your setup.

API Endpoints
POST /api/login
Purpose: Authenticate the user and return role-specific data.

Request Body:

json
Copy code
{
  "email": "user@admin.co.kr",
  "password": "your-password"
}
Response (on success):

json
Copy code
{
  "message": "Login successful",
  "role": "admin"
}
Response (on error):

json
Copy code
{
  "message": "Invalid credentials"
}
Role-Based Dashboards
/admin-dashboard: Admin user dashboard.
/pilot-dashboard: Pilot user dashboard.
/captain-dashboard: Captain user dashboard.
/guest-dashboard: Guest user dashboard (limited access).
/company-dashboard: Company user dashboard.
Contributing
We welcome contributions! To contribute, follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature/feature-name).
Commit your changes (git commit -am 'Add new feature').
Push the changes to the branch (git push origin feature/feature-name).
Open a pull request.
License
This project is licensed under the MIT License. See the LICENSE file for more details.

Acknowledgements
We would like to acknowledge the following tools and libraries:

CoreUI: For providing a rich set of React components and UI elements.
Spring Boot: For building the backend.
MySQL: For handling database management.
Font Awesome: For providing icons used in the UI.
React: For enabling dynamic web application development.
