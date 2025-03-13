# Usar una imagen base de OpenJDK
FROM openjdk:17-alpine

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 9999

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
