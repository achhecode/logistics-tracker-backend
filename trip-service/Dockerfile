from amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/trip-service-*.jar trip-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/trip-service.jar"]
  
EXPOSE 8083

# podman build -t trip-service:1.0.0 .