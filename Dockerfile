# Use a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Create a non-root user and group
RUN groupadd -r spring && useradd -r -g spring spring

# Create app directory and set permissions
WORKDIR /app
COPY --chown=target/spring:spring spring-boot-example2-0.0.1-SNAPSHOT.war /app/app.war

# Switch to non-root user
USER spring

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.war"]