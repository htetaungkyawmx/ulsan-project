# API Endpoints Documentation

This document provides details about the available API endpoints for **POST** requests in the \`ulsan-project\` application.

## Table of Contents

1. [Drone API](#1-drone-api)
2. [Help Center API](#2-help-center-api)
3. [Maintenance API](#3-maintenance-api)
4. [Users API](#4-users-api)
5. [Vessel API](#5-vessel-api)
6. [Video API](#6-video-api)
7. [Company API](#7-company-api)
8. [Feedback API](#8-feedback-api)
9. [Flight Log API](#9-flight-log-api)
10. [Report API](#10-report-api)
11. [Photo API](#11-photo-api)
12. [Document API](#12-document-api)
13. [Role API](#13-role-api)
14. [Permission API](#14-permission-api)
15. [Role_Permission API](#15-role_permission-api)

---

## **1. Drone API**

### Endpoint:
\`POST /drone/create\`

### Request JSON:
\`\`\`json
{
"model": "DJI Phantom 4",
"manufacturer": "DJI",
"weight": "1.4 kg",
"maxAltitude": "5000 meters",
"batteryCapacity": "6000 mAh",
"operatingRange": "7 km"
}
\`\`\`

---

## **2. Help Center API**

### Endpoint:
\`POST /help_center/create\`

### Request JSON:
\`\`\`json
{
"question": "How to reset a drone?",
"answer": "Press and hold the power button for 10 seconds."
}
\`\`\`

---

## **3. Maintenance API**

### Endpoint:
\`POST /maintenance/create\`

### Request JSON:
\`\`\`json
{
"droneId": "1",
"description": "Battery replacement",
"date": "2024-12-01",
"cost": "200 USD"
}
\`\`\`

---

## **4. Users API**

### Endpoint:
\`POST /users/create\`

### Request JSON:
\`\`\`json
{
"username": "john_doe",
"email": "john.doe@example.com",
"password": "securepassword"
}
\`\`\`

---

## **5. Vessel API**

### Endpoint:
\`POST /vessel/create\`

### Request JSON:
\`\`\`json
{
"name": "Titanic",
"type": "Cargo",
"status": "Active",
"capacity": "5000 tons",
"location": "Port of Busan"
}
\`\`\`

---

## **6. Video API**

### Endpoint:
\`POST /video/create\`

### Request JSON:
\`\`\`json
{
"title": "Drone Flight Over Ocean",
"description": "A beautiful view of the ocean captured by a drone.",
"status": "Published",
"createdAt": "2024-12-02",
"url": "http://example.com/video/ocean-flight"
}
\`\`\`

---

## **7. Company API**

### Endpoint:
\`POST /companies/create\`

### Request JSON:
\`\`\`json
{
"name": "QuantumTech",
"email": "contact@quantumtech.com",
"address": "123 Tech Street, Silicon Valley, CA"
}
\`\`\`

---

## **8. Feedback API**

### Endpoint:
\`POST /feedback/create\`

### Request JSON:
\`\`\`json
{
"rating": "5 stars",
"comment": "Excellent drone performance!",
"createdAt": "2024-12-02",
"userId": "123"
}
\`\`\`

---

## **9. Flight Log API**

### Endpoint:
\`POST /flight_log/create\`

### Request JSON:
\`\`\`json
{
"flightNumber": "FL-1234",
"companyId": "1",
"droneId": "1",
"pilotName": "Captain Smith",
"flightDate": "2024-12-01",
"duration": "2 hours",
"status": "Completed"
}
\`\`\`

---

## **10. Report API**

### Endpoint:
\`POST /report/create\`

### Request JSON:
\`\`\`json
{
"title": "Drone Malfunction Report",
"content": "The drone experienced a battery failure during flight.",
"status": "Pending",
"createdAt": "2024-12-02"
}
\`\`\`

---

## **11. Photo API**

### Endpoint:
\`POST /photo/create\`

### Request JSON:
\`\`\`json
{
"title": "Sunset from Drone View",
"description": "A stunning photo of the sunset taken by a drone.",
"status": "Published",
"createdAt": "2024-12-01",
"url": "http://example.com/photo/sunset"
}
\`\`\`

---

## **12. Document**

### Endpoint:
\`POST /document/create\`

### Request JSON:
\`\`\`json
{
"title": "Introduction to Drones",
"content": "This document explains the basics of drone operation.",
"author_id": "101"
}
\`\`\`

---

## Notes:

- Ensure the required fields in the JSON payload are correctly filled.
- Replace example values with actual data as necessary.
- Use the correct API base URL (\`http://localhost:8080\`) for testing with Postman or other tools.

---
