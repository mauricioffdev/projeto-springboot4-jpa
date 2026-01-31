# --- Estágio 1: Build (Compilação) ---
# Usamos uma imagem Maven oficial que já tem o Java 25
# Se der erro de imagem não encontrada, troque '25' por '21' no FROM abaixo,
# mas em 2026 essa imagem já deve existir.
FROM maven:3-eclipse-temurin-25-alpine AS build
WORKDIR /app
COPY . .
# Aqui usamos o 'mvn' do Linux, ignorando o seu 'mvnw' do Windows
RUN mvn clean package -DskipTests

# --- Estágio 2: Run (Execução) ---
# Imagem leve do Java 25 para rodar
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=build /app/target/course-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]