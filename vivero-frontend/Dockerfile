# Usar la imagen oficial de Node.js para construir la app
FROM node:18 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos del frontend
COPY package*.json ./
RUN npm install
COPY . .

# Construir la aplicación Angular
RUN npm run build --configuration=production --output-path=/app/dist

# Usar una imagen de Nginx para servir el frontend
FROM nginx:latest

# Eliminar configuración predeterminada de Nginx
RUN rm /etc/nginx/conf.d/default.conf

# Copiar el build de Angular
COPY --from=build /app/dist/* /usr/share/nginx/html/


# Copiar la configuración personalizada de Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Exponer el puerto 80
EXPOSE 80

# Iniciar Nginx
CMD ["nginx", "-g", "daemon off;"]
