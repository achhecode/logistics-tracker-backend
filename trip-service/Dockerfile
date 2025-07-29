from amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/trip-service-0.0.1-SNAPSHOT.jar trip-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/trip-service.jar"]
  
EXPOSE 8083

# podman build -t trip-service:0.0.1-SNAPSHOT .