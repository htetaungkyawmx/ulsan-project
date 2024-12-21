package org.mdt.ulsanproject.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final Dotenv dotenv;

    public AppConfig() {
        this.dotenv = Dotenv.load();
    }

    public String getDbUsername() {
        return dotenv.get("DB_USERNAME", "root");
    }

    public String getDbPassword() {
        return dotenv.get("DB_PASSWORD", "");
    }

    public String getDbHost() {
        return dotenv.get("DB_HOST", "localhost");
    }

    public String getDbPort() {
        return dotenv.get("DB_PORT", "3306");
    }

    public String getDbName() {
        return dotenv.get("DB_NAME", "db_aioceaneye_java");
    }
}
