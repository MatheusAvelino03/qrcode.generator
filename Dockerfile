### CONFIGURAÇÕES DO DOCKERFILE PARA APLICAÇÃO SPRING BOOT COM AWS ###


# Usa Imagem maven para construir o projeto e depois uma imagem mais leve para rodar a aplicação
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


# Use a smaller base image for the runtime environment
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]


# Variáveis de ambiente para AWS (opcional, dependendo do uso da aplicação)
# Essas variáveis podem ser passadas durante a construção da imagem ou em tempo de execução
# AWS_ACCESS_KEY_ID e AWS_SECRET_ACCESS_KEY são usadas para autenticação com serviços AWS, como S3, DynamoDB, etc.
# São recebidas como argumentos por que são propriedades sensíveis e não devem ser hardcoded na imagem
ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_ACCESS_KEY

# Define as variáveis de ambiente dentro do container
ENV AWS_REGION=us-east-1
ENV AWS_S3_BUCKET_NAME=meu-bucket-s3

ENTRYPOINT ["java", "-jar", "app.jar"]