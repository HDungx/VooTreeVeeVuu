# Use OpenJDK 19 image from Docker Hub
FROM openjdk:19-jdk

# Expose the port that the app runs on
EXPOSE 8080

COPY ./target/VooTreeVeeVuu-0.0.1-SNAPSHOT.jar VooTreeVeeVu-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/VooTreeVeeVu-0.0.1-SNAPSHOT.jar"]