package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.mdt.ulsanproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users save(UsersDto usersDto) {


        Integer roleId = usersDto.getRoleId() != null ? usersDto.getRoleId() : 1;

        Users user = Users.builder()
                .username(validateString(usersDto.getUsername(), "Username"))
                .email(validateString(usersDto.getEmail(), "Email"))
                .password(passwordEncoder.encode(validateString(usersDto.getPassword(), "Password")))
                .roleId(roleId)
                .build();

        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> update(int id, UsersDto usersDto) {
        return usersRepository.findById(id).map(existingUser -> {
            if (usersDto.getPassword() != null && !usersDto.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(usersDto.getPassword()));
            }
            existingUser.setUsername(validateString(usersDto.getUsername(), "Username"));
            existingUser.setEmail(validateString(usersDto.getEmail(), "Email"));
            existingUser.setRoleId(usersDto.getRoleId() != null ? usersDto.getRoleId() : existingUser.getRoleId());

            return usersRepository.save(existingUser);
        });
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(int id) {
        return usersRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        usersRepository.deleteById(id);
    }

    /**
     * Helper method to validate strings.
     * Throws IllegalArgumentException if the input is null or empty.
     */
    private String validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        return value.trim();
    }
}
