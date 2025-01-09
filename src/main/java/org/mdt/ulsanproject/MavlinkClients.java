package org.mdt.ulsanproject;

import org.mdt.ulsanproject.client.MavlinkClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavlinkClients implements CommandLineRunner {
	private final MavlinkClient mavlinkClient;

	public MavlinkClients(MavlinkClient mavlinkClient) {
		this.mavlinkClient = mavlinkClient;
	}

	public static void main(String[] args) {
		System.setProperty("server.port", "8001");
		SpringApplication.run(MavlinkClients.class, args);
	}

	@Override
	public void run(String... args) {
		mavlinkClient.startListening();
	}
}
