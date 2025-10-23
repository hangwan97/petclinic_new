# Spring PetClinic Sample Application

[![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml)
[![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/gradle-build.yml)
[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/spring-projects/spring-petclinic)
[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new?hide_repo_select=true&ref=main&repo=7517918)

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Running Locally](#running-locally)
  - [Building a Container](#building-a-container)
- [Individual Point Tracking](#individual-point-tracking)
- [Database Configuration](#database-configuration)
- [Understanding the Application](#understanding-the-application)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)

## Overview

Spring PetClinic is a sample application designed to demonstrate Spring Boot best practices and features. It's a classic Spring Framework application built with Spring Boot, showcasing various aspects of the framework including:

- Spring Boot for application configuration and deployment
- Spring Data JPA for data access
- Spring MVC for web layer
- Thymeleaf for templating
- H2/MySQL/PostgreSQL database support

## Features

- **Pet Management**: Register and manage pets and their owners
- **Veterinarian Directory**: Browse available veterinarians and their specialties
- **Visit Tracking**: Schedule and track pet visits to the clinic
- **Point Tracking System**: Monitor individual performance metrics over time
- **Responsive UI**: Bootstrap-based responsive user interface
- **RESTful API**: Spring Boot Actuator endpoints for monitoring
- **Multiple Database Support**: H2 (in-memory), MySQL, and PostgreSQL

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17 or higher** - [Download JDK](https://adoptium.net/)
- **Maven 3.8+** (or use the included Maven Wrapper `./mvnw`)
- **Git** - For cloning the repository
- **Python 3.x** (optional) - For generating point tracking charts
- **Docker** (optional) - For containerized deployment

## Getting Started

### Running Locally

1. **Clone the repository**:

```bash
git clone https://github.com/hangwan97/petclinic_new.git
cd petclinic_new
```

2. **Build the application**:

```bash
./mvnw package
```

3. **Run the application**:

```bash
java -jar target/*.jar
```

Or run directly with Maven:

```bash
./mvnw spring-boot:run
```

4. **Access the application**: Open your web browser and navigate to [http://localhost:8080](http://localhost:8080/)

<img width="1042" alt="petclinic-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">

> **Note**: On Windows, or if your shell doesn't expand the glob pattern, you might need to specify the JAR file name explicitly.

> **Note**: If you prefer to use Gradle, you can build the app using `./gradlew build` and look for the jar file in `build/libs`.

### Building a Container

There is no `Dockerfile` in this project. You can build a container image (if you have a Docker daemon) using the Spring Boot build plugin:

```bash
./mvnw spring-boot:build-image
```

This will create a Docker image that you can run with:

```bash
docker run -p 8080:8080 spring-petclinic:3.4.0-SNAPSHOT
```

## Individual Point Tracking

This application includes a point tracking system that monitors individual performance over time. Below is a line chart showing the cumulative point totals for each individual per week, with each person represented by a unique color.

![Individual Point Tracking Chart](charts/individual_points_line_chart.png)

The chart displays:
- **X-axis**: Time segmented by week (2024-W00 to 2024-W11)
- **Y-axis**: Cumulative point total for each individual
- **Lines**: Each individual is represented by a unique color:
  - Alice (Red): #FF6B6B
  - Bob (Teal): #4ECDC4
  - Charlie (Blue): #45B7D1
  - Diana (Orange): #FFA726
  - Eve (Purple): #AB47BC

### Chart Generation

To regenerate the chart with updated data:

```bash
# Install Python dependencies
pip install -r requirements.txt

# Generate chart
python3 scripts/generate_chart.py
```

This will create:
- `charts/individual_points_line_chart.png` - The line chart visualization
- `charts/point_tracking_data.json` - Raw data used for chart generation

## Database Configuration

### Default Configuration (H2)

In its default configuration, Petclinic uses an in-memory database (H2) which gets populated at startup with data. The H2 console is exposed at `http://localhost:8080/h2-console`, and it is possible to inspect the content of the database using the `jdbc:h2:mem:<uuid>` URL. The UUID is printed at startup to the console.

### MySQL

To use MySQL as the database:

1. Start a MySQL instance (or use an existing one)
2. Create the database schema if needed
3. Run the application with the MySQL profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

Database settings are configured in `src/main/resources/application-mysql.properties`.

### PostgreSQL

To use PostgreSQL as the database:

1. Start a PostgreSQL instance (or use an existing one)
2. Create the database schema if needed
3. Run the application with the PostgreSQL profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=postgres
```

Database settings are configured in `src/main/resources/application-postgres.properties`.

## Understanding the Application

For a detailed walkthrough of the Spring PetClinic application architecture and design:

- [View the presentation](https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application)

The application demonstrates various Spring Framework features including:
- **Spring Boot**: Auto-configuration, embedded server
- **Spring Data JPA**: Repository pattern, entity relationships
- **Spring MVC**: Controllers, view templates
- **Spring Validation**: Bean validation
- **Spring Caching**: Method-level caching
- **Thymeleaf**: Server-side templating

## Development

### Project Structure

```
petclinic_new/
├── src/main/java/          # Java source files
├── src/main/resources/     # Application resources
│   ├── static/             # Static web resources (CSS, JS, images)
│   ├── templates/          # Thymeleaf templates
│   └── application.properties
├── scripts/                # Utility scripts
├── charts/                 # Generated charts and data
├── pom.xml                 # Maven configuration
└── README.md              # This file
```

### Running Tests

```bash
./mvnw test
```

### Code Style

This project uses Spring Java Format. The code style is enforced during the build process. To format your code:

```bash
./mvnw spring-javaformat:apply
```

### Building the Project

```bash
# Clean and build
./mvnw clean package

# Skip tests for faster builds
./mvnw clean package -DskipTests

# Build with code coverage
./mvnw clean test jacoco:report
```

### Hot Reload Development

For rapid development with automatic reload:

```bash
./mvnw spring-boot:run
```

Changes to Java files will require recompilation (most IDEs do this automatically).

## Contributing

Contributions are welcome! If you find a bug or have a suggestion for improvement:

1. Check the [issue tracker](https://github.com/hangwan97/petclinic_new/issues) for existing issues
2. Create a new issue describing your bug or feature request
3. If you want to contribute code:
   - Fork the repository
   - Create a feature branch
   - Make your changes
   - Submit a pull request

Please ensure your code follows the project's code style and includes appropriate tests.

## License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).