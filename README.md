# 📦 JDBC Project - MySQL Database Interaction

This project demonstrates a complete Java Database Connectivity (JDBC) workflow for managing student records in a MySQL database. It was built to showcase best practices in SQL interaction and safe data management.

## 🚀 Features

- **Automated Setup:** Automatically creates the database and required tables if they don't exist.
- **Batch Processing:** Ability to collect multiple user inputs and insert them in a single database round-trip for maximum performance.
- **Prepared Statements:** Prevents SQL Injection by using parameters for all queries.
- **Case-Insensitive Deletion:** Deletion logic that works regardless of capitalization (uses SQL's `UPPER()` function).
- **Resource Management:** Ensures all connections and statements are properly closed after use to prevent memory leaks.

## 🛠️ Technologies Used

- **Java Standard Edition (JDK)**
- **MySQL Server**
- **MySQL Connector J** (v9.6.0)
- **Git & GitHub**

## 📖 How to Run

1. **Prerequisites:** 
   - Ensure the MySQL JDBC connector JAR is in your project folder.
   - Update the `url`, `username`, and `password` in `main.java` to match your local setup.

2. **Compilation:**
   ```powershell
   javac -cp ".;mysql-connector-j-9.6.0.jar" main.java
   ```

3. **Execution:**
   ```powershell
   java -cp ".;mysql-connector-j-9.6.0.jar" main
   ```

---
*Created by SMuzammil2508*
