FROM amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/invoice-service-*.jar invoice-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/invoice-service.jar"]
  
EXPOSE 8083

# podman build -t invoice-service:1.0.0 .