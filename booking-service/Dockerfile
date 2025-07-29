from amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/booking-service-0.0.1-SNAPSHOT.jar booking-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/booking-service.jar"]
  
EXPOSE 8082

# podman build -t booking-service:0.0.1-SNAPSHOT .