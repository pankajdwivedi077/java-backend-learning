FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# COPY built jar into container
COPY target/cloud.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]