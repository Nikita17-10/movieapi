# Use official Maven + JDK image to build the app
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the Spring Boot jar
RUN mvn clean package -DskipTests

# Use minimal JDK image for running the app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 9091
EXPOSE 9091

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
