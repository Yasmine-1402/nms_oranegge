# Centralized Internal Management System

## 📌 Overview
This project is a **Centralized Internal Management System** designed for **IT departments** to efficiently manage **personnel, infrastructure, applications, vendors, tickets, and knowledge assets**.  
It provides **role-based access control** with admin approval and ensures **traceability** and **organized operations** across teams.

---

## 🎯 Purpose
The main goal is to **define the requirements** and deliver a fully functional platform that serves as a **centralized hub** for IT management operations.

---

## 📍 Scope
- **Admin Capabilities**:  
  - Full control over all modules  
  - Manage user access and approvals  
  - Track all operations for traceability

- **User Capabilities**:  
  - Restricted access based on admin permissions  
  - Submit and manage tickets  
  - Access approved resources and information  

This system promotes **structured workflows**, **data security**, and **collaborative efficiency**.

---

## 🛠️ Tech Stack

### Backend
- **Spring Boot** – REST API & business logic
- **JWT (JSON Web Tokens)** – Authorization & authentication
- **PostgreSQL** – Relational database for persistent storage

### Frontend
- **HTML5** – Structure  
- **CSS3** – Styling and responsive design  
- **JavaScript (ES6)** – Interactive features and API integration

---

## 🔐 Authorization
- Authentication is **JWT-based** for secure user sessions
- Role-based access control:
  - **Admin**: Full privileges
  - **User**: Limited privileges based on approval
- All sensitive operations require **valid JWT tokens**

---

## 📂 Features
- Personnel Management  
- Infrastructure & Asset Tracking  
- Application Inventory  
- Vendor Management  
- Ticketing System  
- Knowledge Base

---

## 📦 Installation & Setup

### Prerequisites
- **Java 17+**
- **Maven**
- **PostgreSQL**

### Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/centralized-management-system.git
   cd centralized-management-system
