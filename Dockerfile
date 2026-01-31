FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY .. .
RUN ./mvnw clean package -DskipTests
ENTRYPOINT ["java","-jar","target/course-0.0.1-SNAPSHOT.jar"]