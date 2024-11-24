FROM maven:3.9-eclipse-temurin-22-alpine as build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:22-oracle
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
