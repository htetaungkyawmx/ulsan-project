package org.mdt.ulsanproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UlsanProjectApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8000");  // Set port 8000
        SpringApplication.run(UlsanProjectApplication.class, args);
    }

}
