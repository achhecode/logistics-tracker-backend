#!/bin/bash

# ========== Configuration ==========

# IntelliJ Spring Boot project paths
intellij_projects=(
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\discovery-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\api-gateway"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\auth-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\invoice-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\stakeholder-service"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-backend\stakeholder-service"
)

# VS Code project paths
vscode_projects=(
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-db\logistics-tracker-db.yml"
  "C:\Users\danish.ar\Documents\Projects\logistics-invoice-tracker\logistics-tracker-frontend\logistics-tracker"
)

# ========== Functions ==========

run_spring_boot_app() {
  local project_root="$1"
  echo "🔍 Searching for @SpringBootApplication in $project_root"

  main_file=$(grep -rl '@SpringBootApplication' "$project_root/src/main/java" --include="*.java" | head -n 1)

  if [[ -n "$main_file" ]]; then
    echo "✅ Found main class: $main_file"

    # Extract fully qualified class name (package + class)
    package_line=$(grep "^package " "$main_file")
    class_name=$(basename "$main_file" .java)

    if [[ $package_line =~ ^package\ (.*); ]]; then
      full_class="${BASH_REMATCH[1]}.$class_name"
      echo "📦 Running: $full_class"

      # Run with Maven in background
      (cd "$project_root" && mvn spring-boot:run -Dspring-boot.run.main-class="$full_class") &
    else
      echo "⚠️ Could not detect package in $main_file"
    fi
  else
    echo "❌ No @SpringBootApplication found in $project_root"
  fi
}

# ========== Launch Projects ==========

echo "🚀 Opening IntelliJ projects..."
for project in "${intellij_projects[@]}"; do
  echo "🧠 Opening IntelliJ: $project"
  idea "$project" &
  sleep 2

  # Try to find and run Spring Boot main class
  run_spring_boot_app "$project"
done

echo "🛠️ Opening VS Code projects..."
for project in "${vscode_projects[@]}"; do
  echo "🧠 Opening VSCode: $project"
  code "$project"
done

echo "✅ All projects opened. Spring Boot apps are launching (if found)."


# Running it
# chmod +x open-projects.sh
# ./open-projects.sh