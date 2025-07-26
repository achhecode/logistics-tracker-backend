# Open Podman Desktop
Start-Process "podman-desktop://"

# Wait 10 seconds for Podman Desktop to initialize
Start-Sleep -Seconds 15

# Change directory to your project
Set-Location "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-db"

# Run the podman compose command
podman compose -f logistics-tracker-db.yml up -d
