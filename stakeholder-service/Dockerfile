FROM amazoncorretto:24  
  
WORKDIR /app  
  
COPY target/stakeholder-service-*.jar stakeholder-service.jar
  
ENTRYPOINT ["java", "-jar", "/app/stakeholder-service.jar"]
  
EXPOSE 8083

# podman build -t stakeholder-service:1.0.0 .