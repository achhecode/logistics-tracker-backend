FROM amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/auth-service-*.jar auth-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]
  
EXPOSE 8083

# podman build -t auth-service:1.0.0 .