package org.mdt.ulsanproject.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final Dotenv dotenv;

    // Load .env file only once to avoid repeated calls
    public AppConfig() {
        this.dotenv = Dotenv.load();
    }

    // Fetch environment variables from .env file
    public String getDbUsername() {
        return dotenv.get("DB_USERNAME", "root"); // Default to 'root' if not set
    }

    public String getDbPassword() {
        return dotenv.get("DB_PASSWORD", ""); // Default to empty if not set
    }

    public String getDbHost() {
        return dotenv.get("DB_HOST", "localhost"); // Default to 'localhost' if not set
    }

    public String getDbPort() {
        return dotenv.get("DB_PORT", "3306"); // Default to '3306' if not set
    }

    public String getDbName() {
        return dotenv.get("DB_NAME", "db_aioceaneye_java"); // Default database name
    }
}
