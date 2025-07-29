FROM amazoncorretto:24

WORKDIR /app

COPY target/discovery-service-*.jar discovery-service.jar

ENTRYPOINT ["java", "-jar", "/app/discovery-service.jar"]

EXPOSE 8761

# podman build -t discovery-service:1.0.0 .
#OR
# podman build -t discovery-service:1.0.0 -f C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\discovery-service\Dockerfile

