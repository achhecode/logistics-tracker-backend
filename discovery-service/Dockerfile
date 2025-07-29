from amazoncorretto:24

WORKDIR /app

COPY target/discovery-service-0.0.1-SNAPSHOT.jar discovery-service.jar

ENTRYPOINT ["java", "-jar", "/app/discovery-service.jar"]

EXPOSE 8761

# podman build -t discovery-service:0.0.1-SNAPSHOT .
#OR
# podman build -t discovery-service:0.0.1-SNAPSHOT -f C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\discovery-service\Dockerfile

