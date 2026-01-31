FROM eclipse-temurin:25-jdk-alpine

VOLUME /tmp
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
ENTRYPOINT ["java","-jar","target/course-0.0.1-SNAPSHOT.jar"]