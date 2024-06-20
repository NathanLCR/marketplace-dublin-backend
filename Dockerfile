# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean;

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Expose the application port
EXPOSE 8080

# Run the application with Maven Spring Boot plugin
CMD ["mvn", "spring-boot:run"]
