package org.mdt.busanproject.service.impl;

import org.mdt.busanproject.dto.AdminDto;
import org.mdt.busanproject.model.Admin;
import org.mdt.busanproject.repository.AdminRepository;
import org.mdt.busanproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .email(adminDto.getEmail())
                .password(adminDto.getPassword())
                .build();
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(int id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }
}
