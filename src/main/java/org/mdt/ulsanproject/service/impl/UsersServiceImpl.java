package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Role;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.mdt.ulsanproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users save(UsersDto usersDto) {
        Users user = convertToEntity(usersDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> update(int id, UsersDto usersDto) {
        return usersRepository.findById(id).map(existingUser -> {
            if (usersDto.getUsername() != null) {
                existingUser.setUsername(usersDto.getUsername().trim());
            }
            if (usersDto.getEmail() != null) {
                existingUser.setEmail(usersDto.getEmail().trim());
            }
            if (usersDto.getPassword() != null) {
                existingUser.setPassword(passwordEncoder.encode(usersDto.getPassword().trim()));
            }
            if (usersDto.getRoles() != null) {
                Set<Role> roles = usersDto.getRoles().stream()
                        .map(roleName -> Role.builder().name(roleName).build())
                        .collect(Collectors.toSet());
                existingUser.setRoles(roles);
            }
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
     * Helper method to convert a UsersDto to Users entity.
     */
    private Users convertToEntity(UsersDto usersDto) {
        return Users.builder()
                .username(validateString(usersDto.getUsername(), "Username"))
                .email(validateString(usersDto.getEmail(), "Email"))
                .password(validateString(usersDto.getPassword(), "Password"))
                .roles(usersDto.getRoles().stream()
                        .map(roleName -> Role.builder().name(roleName).build())
                        .collect(Collectors.toSet()))
                .build();
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
