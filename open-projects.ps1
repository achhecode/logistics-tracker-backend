# ================= Configuration =================

# IntelliJ Spring Boot Projects (absolute paths)
$intellijProjects = @(
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\discovery-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\api-gateway"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\auth-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\booking-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\trip-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\stakeholder-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\invoice-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\logistics-models"
)

# VS Code Projects (absolute paths)
$vscodeProjects = @(
#   "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-db"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-frontend\logistics-tracker"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-k8s"
)

# ================= Functions =================

function Open-IntelliJ {
    param ($projectPath)
    Write-Host "Opening IntelliJ Project: $projectPath"
    Start-Process "idea64.exe" -ArgumentList "`"$projectPath`""
    Start-Sleep -Seconds 2
}

function Open-VSCode {
    param ($projectPath)
    Write-Host "Opening VS Code Project: $projectPath"
    Start-Process "code.cmd" -ArgumentList "`"$projectPath`""
}

function Run-SpringBoot {
    param ($projectRoot)

    Write-Host "Searching for @SpringBootApplication in $projectRoot"

    $mainFile = Get-ChildItem -Path "$projectRoot\src\main\java" -Recurse -Filter *.java |
                Select-String -Pattern "@SpringBootApplication" |
                Select-Object -First 1 |
                ForEach-Object { $_.Path }

    if ($mainFile) {
        Write-Host "Found main class file: $mainFile"

        $packageLine = Get-Content $mainFile | Where-Object { $_ -match "^package " } | Select-Object -First 1
        $className = [System.IO.Path]::GetFileNameWithoutExtension($mainFile)

        if ($packageLine -match "^package\s+(.+);") {
            $package = $matches[1]
            $fullClassName = "$package.$className"

            Write-Host "Running main class: $fullClassName"
            
            $command = "cd `"$projectRoot`"; mvn spring-boot:run -Dspring-boot.run.main-class=$fullClassName"
            Start-Process "powershell.exe" -ArgumentList "-NoExit", "-Command", $command
        }
        else {
            Write-Host "Could not extract package name from $mainFile"
        }
    }
    else {
        Write-Host "No @SpringBootApplication file found in $projectRoot"
    }
}

# ================= Execution =================

foreach ($project in $intellijProjects) {
    Open-IntelliJ -projectPath $project

    # Run-SpringBoot -projectRoot $project

    Start-Sleep -Seconds 5  # Wait 5 seconds before opening the next one
}

foreach ($project in $vscodeProjects) {
    Open-VSCode -projectPath $project
}

Write-Host ""
Write-Host "All projects opened. If Spring Boot main classes were found, they're now running."


# .\open-projects.ps1