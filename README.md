# AIOCEANEYE: Tuna Fish Group Detection

**AIOCEANEYE** is a web application designed to detect tuna fish groups using drone technology. It features role-based authentication, with access tailored to different user roles, including Admin, Pilot, Captain, Guest, and Company. Each role is assigned a unique dashboard with custom functionality, ensuring a personalized and secure experience.

## Table of Contents
- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Project Overview
**AIOCEANEYE** leverages advanced drone technology to monitor and detect tuna fish groups. It supports multiple user roles, with each role being directed to different pages after authentication. Whether you're an Admin, Pilot, Captain, Guest, or Company user, the platform ensures a seamless, secure, and intuitive experience.

## Project Structure

### Frontend (React.js)
- **Login Form**: A login page where users input their credentials and select their role. The role is automatically detected based on the email domain.
- **Dashboard**: Role-based redirection sends users to the correct dashboard (e.g., Admin, Pilot, Captain, etc.).
- **UI Library**: Built with CoreUI for responsive layout components and @coreui/icons-react for icons.

### Backend (Spring Boot)
- **Role-based Authentication**: Validates user credentials and assigns roles based on the email domain (e.g., admin.co.kr → Admin, pilot.co.kr → Pilot).
- **Role-Based Redirection**: After login, users are redirected to role-specific endpoints.
- **Security**: API endpoints are secured using Spring Security, ensuring sensitive data protection.

## Features
- **Role Detection**: Automatically assigns user roles based on email domains. For example:
  - admin.co.kr → Admin
  - pilot.co.kr → Pilot
  - captain.co.kr → Captain
- **User Authentication**: Secure login system with email and password.
- **Role-Based Dashboards**: Separate dashboards for each user role, including Admin, Pilot, Captain, Guest, and Company.
- **Feedback Messages**: Clear success and error messages displayed after login attempts, ensuring users are informed about the login status.

## Technologies Used

### Frontend
- **React.js**: A powerful JavaScript library for building user interfaces.
- **CoreUI**: A UI component library for React, providing pre-designed elements and layouts.
- **React Router**: For navigation between different views.
- **Axios / Fetch API**: For making HTTP requests to the backend API.

### Backend
- **Spring Boot**: A Java-based framework for building production-grade backend applications.
- **Spring Security**: Manages user authentication and role-based authorization.
- **REST API**: To communicate between the frontend and backend.
- **Java 11+**: The programming language used for the backend.
- **JPA/Hibernate**: For seamless database interaction and ORM functionality.

## Prerequisites
Before running the project, ensure you have the following installed:

- **Node.js** (for frontend development)
- **Java 11+** (for backend development)
- **Maven** (for backend build automation)
- **MySQL** (or a preferred database)

## Setup Instructions

### 1. Clone the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/busan_project/busan_project.git
