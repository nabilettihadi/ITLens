# ITLens - Advanced Survey Management System

## Table of Contents

- [Features](#features)
- [Quick Start](#quick-start)
- [API Endpoints](#api-endpoints)
- [Data Models](#data-models)
- [Testing](#testing)
- [Contributing](#contributing)
- [Contact](#contact)

## 🌟 Features

- **Hierarchical Survey Structure**: Organize surveys with nested subjects and questions.
- **Dynamic Question Types**: Support for multiple question formats.
- **Real-time Statistics**: Track and analyze survey responses.
- **RESTful API**: Complete API coverage for all operations.
- **Validation**: Comprehensive input validation with custom annotations.
- **Pagination**: Efficient data handling for large datasets.
- **Transaction Management**: Ensures data consistency.

## 🚀 Quick Start

### Prerequisites

- Java 21
- Maven 3.8+
- PostgreSQL 13+
- Docker (optional)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/nabilettihadi/ITLens.git
   cd ITLens
   ```

2. **Configure database**:
   Update the `application.properties` file with your database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/itlens
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and run**:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📚 API Endpoints

### Survey Operations

For detailed API operations, refer to the `SurveyController`:

```java:src/main/java/ma/nabil/ITLens/controller/SurveyController.java
startLine: 20
endLine: 51
```

## 📦 Data Models

### Survey DTO

```java:src/main/java/ma/nabil/ITLens/dto/SurveyDTO.java
startLine: 1
endLine: 31
```

### Subject DTO

```java:src/main/java/ma/nabil/ITLens/dto/SubjectDTO.java
startLine: 1
endLine: 36
```

### Survey Edition DTO

```java:src/main/java/ma/nabil/ITLens/dto/SurveyEditionDTO.java
startLine: 1
endLine: 28
```

### Survey Participation DTO

```java:src/main/java/ma/nabil/ITLens/dto/SurveyParticipationDTO.java
startLine: 1
endLine: 29
```

### Survey Result DTO

```java:src/main/java/ma/nabil/ITLens/dto/SurveyResultDTO.java
startLine: 1
endLine: 45
```

## 🧪 Testing

To run tests, use the following commands:

- **Unit tests**:
  ```bash
  ./mvnw test
  ```

- **Integration tests**:
  ```bash
  ./mvnw verify
  ```

## 🤝 Contributing

We welcome contributions! Follow these steps to contribute:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## 📞 Contact

For any inquiries, please contact:

Ettihadi Nabil - [@nabilettihadi](https://github.com/nabilettihadi)

Project Link: [https://github.com/nabilettihadi/ITLens](https://github.com/nabilettihadi/ITLens)

---

<div align="center">

**[⬆ back to top](#itlens---advanced-survey-management-system)**

Made with ❤️ by [Ettihadi Nabil](https://github.com/nabilettihadi)

</div>
```