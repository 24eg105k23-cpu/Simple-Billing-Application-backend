FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -B dependency:go-offline
COPY src/ src/
RUN ./mvnw -B package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/billing_application-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar /app/app.jar"]
