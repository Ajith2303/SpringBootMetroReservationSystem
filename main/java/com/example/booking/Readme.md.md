# Chennai Metro Ticket Booking System

This is a Spring Boot web application that allows users to book tickets for Chennai Metro Rail. Users can add, view, update, and delete bookings, with routes listed for various Chennai metro stations.

---

## 🚀 Features

- List all ticket bookings
- Add new bookings
- Edit existing bookings
- Delete bookings with success/error messages
- Flash messages for operations
- Chennai Metro stations dropdown
- Styled UI with a metro background
- MySQL database integration

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- HTML5/CSS3

---

## 🗂️ Project Structure

```
src/
 └── main/
     ├── java/com/example/booking/
     │   ├── Controller/
     │   │   └── BookingController.java
     │   ├── Model/
     │   │   └── Booking.java
     │   ├── Service/
     │   │   └── BookingService.java
     │   └── BookingRepository.java
     └── resources/
         ├── static/
         │   └── css/style.css
         │   └── images/Metro.jpg
         ├── templates/
         │   ├── index.html
         │   ├── new_booking.html
         │   ├── update_booking.html
         │   └── error.html
         └── application.properties
```

---

## 🧪 How to Run

### 1. ✅ Prerequisites

- Java 17+
- Maven
- MySQL

### 2. ✅ Database Setup

- Create a MySQL database:
  ```sql
  CREATE DATABASE metro_booking;
  ```

- Update `application.properties`:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/metro_booking
  spring.datasource.username=root
  spring.datasource.password=your_password

  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  ```

### 3. ✅ Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🌐 Access the App

- Open browser: [http://localhost:8080](http://localhost:8080)

---

## 📷 Screenshots

> Add screenshots here if needed.

---

## 📝 Credits

Developed by: **Ajith**  
Project: **Chennai Metro Ticket Booking (2025)**  
Tech Stack: Spring Boot, Thymeleaf, MySQL

---

## 📄 License

This project is for educational purposes only. No commercial use.