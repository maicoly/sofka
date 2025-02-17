# Usar una imagen base de OpenJDK 21 con Maven
FROM openjdk:21-jdk-slim as jdk-maven

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven curl && \
    rm -rf /var/lib/apt/lists/*

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar los JARs desde tu máquina anfitriona al contenedor
COPY AccountMovements-0.0.1-SNAPSHOT.jar /app/
COPY ClientPerson-0.0.1-SNAPSHOT.jar /app/

# Establecer el directorio de trabajo
WORKDIR /app
