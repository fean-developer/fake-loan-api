# Dockerfile para Fake Loan API (Spring Boot)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/fake-loan-api-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
