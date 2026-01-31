# Usamos a imagem oficial do Java 25 baseada em Ubuntu (mais estável que Alpine)
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY . .

# --- A MÁGICA PARA QUEM USA WINDOWS ---
# 1. Atualiza o Linux e instala o conversor 'dos2unix'
RUN apt-get update && apt-get install -y dos2unix

# 2. Converte o script mvnw (tira os caracteres invisíveis do Windows)
RUN dos2unix mvnw

# 3. Dá permissão de execução
RUN chmod +x mvnw
# --------------------------------------

# Agora roda o build usando o script consertado
RUN ./mvnw clean package -DskipTests

# Roda a aplicação
ENTRYPOINT ["java","-jar","target/course-0.0.1-SNAPSHOT.jar"]