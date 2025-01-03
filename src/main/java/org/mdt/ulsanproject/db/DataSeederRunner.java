package org.mdt.ulsanproject.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeederRunner implements CommandLineRunner {

    @Autowired
    private DataSeederService dataSeederService;

    @Override
    public void run(String... args) throws Exception {
        dataSeederService.seedDatabase();
    }
}
