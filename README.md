# Spring PetClinic Sample Application [![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml)[![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/gradle-build.yml)

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/spring-projects/spring-petclinic) [![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new?hide_repo_select=true&ref=main&repo=7517918)

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

## Understanding the Spring Petclinic application with a few diagrams

[See the presentation here](https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application)

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17 or newer** - Required to build and run the Spring Boot application
- **Maven 3.6+** - For building the project
- **Python 3.x** (Optional) - Required only if you want to regenerate the point tracking charts
- **pip** (Optional) - For installing Python dependencies

### Python Dependencies (Optional)

If you want to generate or update the point tracking charts:

```bash
pip install -r requirements.txt
```

This will install:
- matplotlib >= 3.10.0

## Run Petclinic locally

Spring Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/) or [Gradle](https://spring.io/guides/gs/gradle/). You can build a jar file and run it from the command line (it should work just as well with Java 17 or newer):

```bash
git clone https://github.com/hangwan97/petclinic_new.git
cd petclinic_new
mvn package
java -jar target/*.jar
```

(On Windows, or if your shell doesn't expand the glob, you might need to specify the JAR file name explicitly on the command line at the end there.)

You can then access the Petclinic at <http://localhost:8080/>.

<img width="1042" alt="petclinic-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this, it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```bash
mvn spring-boot:run
```

## Building a Container

There is no `Dockerfile` in this project. You can build a container image (if you have a docker daemon) using the Spring Boot build plugin:

```bash
mvn spring-boot:build-image
```

## In case you find a bug/suggested improvement for Spring Petclinic

Our issue tracker is available [here](https://github.com/hangwan97/petclinic_new/issues).

## Database configuration

In its default configuration, Petclinic uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is exposed at `http://localhost:8080/h2-console`,
and it is possible to inspect the content of the database using the `jdbc:h2:mem:<uuid>` URL. The UUID is printed at startup to the console.

### MySQL, PostgreSQL

You can also use MySQL or PostgreSQL databases. Database settings are located in `application-mysql.properties` and `application-postgres.properties` in the `src/main/resources` directory.

1. Run the application with `mvn spring-boot:run -Dspring-boot.run.profiles=mysql` for MySQL or `mvn spring-boot:run -Dspring-boot.run.profiles=postgres` for PostgreSQL.

For more details on using these databases, please refer to the documentation.

## License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).