package org.mdt.ulsanproject;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class DroneGCS {

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final List<Runnable> droneTasks = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DroneGCS.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://127.0.0.1:3000",
                                "http://localhost:3000",
                                "http://172.24.6.136:3000",
                                "http://172.24.16.12:3000"
                        )
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    @Bean
    CommandLineRunner initDroneConnections() {
        return args -> {
            droneTasks.add(() -> fetchTelemetry("drone", "tcp:127.0.0.1:14550"));
            droneTasks.forEach(executorService::submit);
            System.out.println("Drone connections have been started.");
        };
    }

    private void fetchTelemetry(String droneId, String connectionString) {
        System.out.printf("Fetching telemetry for %s using %s%n", droneId, connectionString);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
                System.out.printf("Drone %s: Data fetched%n", droneId);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("Drone %s: Connection interrupted%n", droneId);
            }
        }
    }

    @PreDestroy
    @EventListener(ContextClosedEvent.class)
    public void gracefulShutdown() {
        System.out.println("Shutting down gracefully...");
        executorService.shutdownNow();
    }
}
