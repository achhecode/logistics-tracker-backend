FROM amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/api-gateway-*.jar api-gateway.jar
  
ENTRYPOINT ["java", "-jar", "/app/api-gateway.jar"]
  
EXPOSE 8083

# podman build -t api-gateway:1.0.0 .