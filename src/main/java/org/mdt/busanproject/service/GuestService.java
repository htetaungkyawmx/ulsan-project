package org.mdt.busanproject.service;

import org.mdt.busanproject.dto.GuestDto;
import org.mdt.busanproject.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    Guest save(GuestDto guestDto); // Save guest details
    List<Guest> findAll(); // Get all guests
    Optional<Guest> findById(int id); // Find a guest by ID
    Guest findByEmail(String email); // Find a guest by email
    boolean validateUser(String email, String password); // Validate login credentials
}
