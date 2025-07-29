from amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/booking-service-*.jar booking-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/booking-service.jar"]
  
EXPOSE 8082

# podman build -t booking-service:1.0.0 .