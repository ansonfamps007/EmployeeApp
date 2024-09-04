FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build.gradle.kts and settings.gradle.kts files
COPY build.gradle.kts settings.gradle.kts /app/

# Copy the gradle wrapper
COPY gradlew /app/gradlew
COPY gradle /app/gradle

# Copy the source code
COPY src /app/src

# Set execute permission on gradlew
RUN chmod +x gradlew

# Download dependencies and build the application
#RUN ./gradlew clean build

# Expose the port the app runs on
EXPOSE 8080

# Add a volume to store logs
VOLUME /app/logs

# The application's jar file
ARG JAR_FILE=build/libs/EmployeeApp-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} employee-app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "employee-app.jar"]