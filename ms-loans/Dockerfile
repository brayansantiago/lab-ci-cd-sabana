FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/*.jar ms-loans-1.0.0.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "ms-loans-1.0.0.jar"]