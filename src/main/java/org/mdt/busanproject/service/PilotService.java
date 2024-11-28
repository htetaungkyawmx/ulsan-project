package org.mdt.busanproject.service;

import org.mdt.busanproject.dto.PilotDto;
import org.mdt.busanproject.model.Pilot;

import java.util.List;
import java.util.Optional;

public interface PilotService {
    Pilot save(PilotDto pilotDto); // Save pilot details
    List<Pilot> findAll(); // Get all pilots
    Optional<Pilot> findById(int id); // Find a pilot by ID
    Pilot findByEmail(String email); // Find a pilot by email
    boolean validateUser(String email, String password); // Validate login credentials
}
