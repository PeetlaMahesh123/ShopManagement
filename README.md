

---

## 📌 Project Overview

The **Shop Management System** is a Java-based desktop application developed using **Hibernate ORM and Maven**.
It provides **admin-only access** to manage users and products with full **CRUD operations**, role-based access control, and database persistence.

---

## 🚀 Features

* 🔐 Admin Login Authentication
* 👥 User Management (CRUD)
* 📦 Product Management (CRUD)
* 🧑‍💼 Role-based access using Enum (ADMIN / USER)
* 🗄️ Hibernate ORM with MySQL
* 🖥️ Java Swing UI
* 📁 Maven project structure

---

## 🛠️ Technologies Used

* **Java**
* **Hibernate (JPA)**
* **Maven**
* **MySQL**
* **Java Swing**
* **DAO Design Pattern**

---

## 📂 Project Structure

```
ShopManagement/
├── src/main/java/
│   └── com.shop.shopmanagement
│       ├── App.java
│       ├── LoginFrame.java
│       ├── WelcomeFrame.java
│       ├── User.java
│       ├── Product.java
│       ├── Role.java
│       ├── UserDAO.java
│       ├── ProductDAO.java
│       └── UI & Operations classes
│
├── src/main/resources/
│   └── hibernate.cfg.xml
│
├── database/
│   └── shop_management.sql   ✅
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🗄️ Database Setup

### 📁 Database File

The project includes a **MySQL database file**:

```
database/shop_management.sql
```

This file contains:

* Database creation
* Tables for users and products
* Required constraints and relationships

---

### ⚙️ How to Import the Database

#### Option 1: Using MySQL Command Line

```bash
mysql -u root -p
CREATE DATABASE shop_management;
USE shop_management;
SOURCE path/to/shop_management.sql;
```

#### Option 2: Using MySQL Workbench

1. Open **MySQL Workbench**
2. Create database:

   ```sql
   CREATE DATABASE shop_management;
   ```
3. Go to **Server → Data Import**
4. Select `shop_management.sql`
5. Click **Start Import**

---

### 🔐 Update Hibernate Configuration

Edit `hibernate.cfg.xml` with your DB credentials:

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/shop_management
</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password</property>
```

---

## ▶️ How to Run the Project

### 1️⃣ Prerequisites

* Java JDK 8+
* Maven
* MySQL
* IDE (Eclipse / IntelliJ)

---

### 2️⃣ Build the Project

```bash
mvn clean install
```

---

### 3️⃣ Run the Application

Run the main class:

```java
App.java
```

---

## 🧠 Learning Outcomes

* Hibernate ORM & entity mapping
* Maven lifecycle and dependency management
* DAO pattern implementation
* Role-based access using enums
* Database integration with Java

---

## 🚀 Future Enhancements

* Convert to Spring Boot
* Add REST APIs
* Password encryption
* Search & pagination
* Web UI using React

---

## 👨‍💻 Author

**Peetla Mahesh**
Aspiring Backend Software Developer
📍 Tirupati, Andhra Pradesh, India

---

⭐ *Feel free to clone the repository, import the database, and explore the project!*

---


