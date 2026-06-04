FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/*.jar ms-books-1.0.0.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "ms-books-1.0.0.jar"]