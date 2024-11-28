package org.mdt.busanproject.service;

import org.mdt.aioceaneye.dto.AdminDto;
import org.mdt.aioceaneye.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin save(AdminDto adminDto);
    List<Admin> findAll();
    Optional<Admin> findById(int id);
    Admin findByEmail(String email);
    boolean validateUser(String email, String password); // Validate login credentials
}
