# 🗂️ Task Management Web App

The idea of this project is to build a A full-stack task management application with support for recurring reminders, real-time notifications, audit logging, and user authentication. Built to learn and apply Spring Boot, 
Quarkus, Angular, GraphQL, WebSocket, RabbitMQ, Kafka, Quartz Scheduler, and more!

---

## 🚀 Features

- User registration and login (JWT-based authentication)
- Create, update, and delete tasks
- One-time or recurring reminders with cron expressions
- Real-time notifications (WebSocket + RabbitMQ)
- Audit logs for tracking task changes
- Role-based user system
- Modular and scalable architecture

---

## 🛠 Tech Stack

### Backend
- Spring Boot / Quarkus (for microservices)
- GraphQL & REST APIs
- Quartz Scheduler (for reminders)
- RabbitMQ (message broker)
- Kafka (optional, for streaming events)
- PostgreSQL (database)
- JPA/Hibernate (ORM)
- WebSocket (real-time updates)
- Integrated with Swagger UI for Listing API's { http://localhost:8080/swagger-ui/index.html }

### Frontend
- Angular
- RxJS (data stream handling)
- WebSocket integration for notifications
- Bootstrap / Tailwind CSS (UI)
