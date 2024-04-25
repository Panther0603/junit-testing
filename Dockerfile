# Stage 1: Build the application
FROM maven:3.9.6-amazoncorretto-21 AS build

WORKDIR /app
COPY . .

RUN mvn clean install

# Stage 2: Create the final image
FROM amazoncorretto:21
LABEL authors="mohitkumar"

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/junittestingdemo-0.0.1-SNAPSHOT.jar junittesting.jar

# Expose the port
EXPOSE 5003

# Set the entry point
ENTRYPOINT ["java", "-jar", "junittesting.jar"]
