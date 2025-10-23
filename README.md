# Spring PetClinic Sample Application [![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml)[![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/gradle-build.yml)

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/spring-projects/spring-petclinic) [![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new?hide_repo_select=true&ref=main&repo=7517918)

## 📖 Overview

The Spring PetClinic is a sample application designed to showcase the Spring Boot framework and best practices for building web applications. This enhanced version includes additional features like pet adoption management, individual point tracking, and Eclipse Copilot TAM estimation capabilities.

## ✨ Features

- **Pet Management**: Complete CRUD operations for managing pets, owners, and veterinarians
- **Appointment System**: Schedule and manage veterinary visits
- **Pet Adoption**: New adoption feature allowing users to view and adopt available pets
- **Point Tracking System**: Monitor individual performance metrics over time with visual charts
- **TAM Estimation**: Eclipse Copilot Total Addressable Market estimation tools
- **Multiple Database Support**: H2 (in-memory), MySQL, and PostgreSQL
- **Modern UI**: Bootstrap-based responsive web interface

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Prerequisites](#-prerequisites)
- [Adoption Feature](#-adoption-feature)
- [Individual Point Tracking](#individual-point-tracking)
- [Getting Started](#getting-started)
- [Database Configuration](#database-configuration)
- [Project Structure](#-project-structure)
- [Building a Container](#building-a-container)
- [Contributing](#in-case-you-find-a-bugsuggested-improvement-for-spring-petclinic)
- [License](#license)

## 🔧 Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17 or newer** - [Download Java](https://adoptium.net/)
- **Maven 3.8+** (included via Maven Wrapper) or **Gradle 7+**
- **Python 3.x** with `matplotlib>=3.10.0` (for chart generation)
- **Git** for version control

## 🐾 Adoption Feature

The application includes a comprehensive pet adoption system that allows users to view available pets and submit adoption requests.

### How It Works

The adoption feature is implemented through the `AdoptionController` class located at:
```
src/main/java/org/springframework/samples/petclinic/adoption/AdoptionController.java
```

#### Key Components:

1. **AdoptionController** (Lines 34-41 explanation):
   - `@PostMapping("/{petId}/adopt")`: Handles POST requests to adopt a specific pet
   - `@PathVariable("petId")`: Extracts the pet ID from the URL path
   - `adoptPet()` method: Processes the adoption request by:
     - Finding the pet by ID using the repository
     - Checking if the pet exists (null check)
     - Setting the `isAdopted` flag to `true`
     - Saving the updated pet to the database
     - Redirecting back to the adoption list page

2. **AdoptablePet Entity**: Represents pets available for adoption with properties:
   - Species (e.g., dog, cat)
   - Gender
   - Age
   - Description
   - Adoption status (isAdopted flag)

3. **AdoptablePetRepository**: Spring Data JPA repository for database operations

### Accessing the Adoption Feature

Once the application is running, visit:
```
http://localhost:8080/adoption
```

This will display a list of all adoptable pets. Users can click the "Adopt" button to mark a pet as adopted.

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
cd petclinic_new
python3 scripts/generate_chart.py
```

This will create:
- `charts/individual_points_line_chart.png` - The line chart visualization
- `charts/point_tracking_data.json` - Raw data used for chart generation

**Requirements**: Install Python dependencies first:
```bash
pip install -r requirements.txt
```

## Getting Started

### Understanding the Spring Petclinic Application

For a comprehensive overview of the application architecture and design patterns, [see the presentation here](https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application).

### Run Petclinic Locally

Spring Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/) or [Gradle](https://spring.io/guides/gs/gradle/). You can build a jar file and run it from the command line (it should work just as well with Java 17 or newer):

```bash
git clone https://github.com/hangwan97/petclinic_new.git
cd petclinic_new
./mvnw package
java -jar target/*.jar
```

(On Windows, or if your shell doesn't expand the glob, you might need to specify the JAR file name explicitly on the command line at the end there.)

You can then access the Petclinic at <http://localhost:8080/>.

<img width="1042" alt="petclinic-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this, it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```bash
./mvnw spring-boot:run
```

> NOTE: If you prefer to use Gradle, you can build the app using `./gradlew build` and look for the jar file in `build/libs`.

## Building a Container

There is no `Dockerfile` in this project. You can build a container image (if you have a docker daemon) using the Spring Boot build plugin:

```bash
./mvnw spring-boot:build-image
```

## Database configuration

In its default configuration, Petclinic uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is exposed at `http://localhost:8080/h2-console`,
and it is possible to inspect the content of the database using the `jdbc:h2:mem:<uuid>` URL. The UUID is printed at startup to the console.

### MySQL, PostgreSQL

You can also use MySQL or PostgreSQL databases. Database settings are located in `application-mysql.properties` and `application-postgres.properties` in the `src/main/resources` directory.

1. Run the application with `./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql` for MySQL or `./mvnw spring-boot:run -Dspring-boot.run.profiles=postgres` for PostgreSQL.

For more details on using these databases, please refer to the documentation.

## 📁 Project Structure

```
petclinic_new/
├── src/
│   └── main/
│       ├── java/org/springframework/samples/petclinic/
│       │   ├── adoption/          # Adoption feature package
│       │   │   ├── AdoptionController.java
│       │   │   ├── AdoptablePet.java
│       │   │   └── AdoptablePetRepository.java
│       │   ├── model/             # Domain entities
│       │   ├── vet/               # Veterinarian management
│       │   └── PetClinicApplication.java
│       └── resources/
│           ├── templates/         # Thymeleaf templates
│           │   └── adoption/      # Adoption UI templates
│           └── application.properties
├── charts/                        # Point tracking visualizations
│   ├── individual_points_line_chart.png
│   └── point_tracking_data.json
├── scripts/
│   └── generate_chart.py         # Chart generation script
├── estimation.html                # TAM estimation tool
├── pom.xml                        # Maven configuration
├── requirements.txt               # Python dependencies
└── README.md
```

## 🧪 Testing

Run the test suite using Maven:

```bash
./mvnw test
```

Or with Maven installed:
```bash
mvn test
```

## 🤝 Contributing

Contributions are welcome! If you find a bug or have suggestions for improvements, please open an issue in our [issue tracker](https://github.com/hangwan97/petclinic_new/issues).

## License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).