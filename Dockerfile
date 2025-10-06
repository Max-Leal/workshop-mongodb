# Estágio 1: Build da aplicação com Maven
FROM eclipse-temurin:21-jdk-jammy as builder
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Estágio 2: Criação da imagem final, otimizada para execução
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# ATENÇÃO: Verifique se o nome do seu .jar está correto!
# Ele é definido no seu arquivo pom.xml (<artifactId> e <version>)
COPY --from=builder /app/target/workshopmongodb-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]