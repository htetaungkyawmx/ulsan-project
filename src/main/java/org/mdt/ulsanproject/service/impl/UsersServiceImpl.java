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
        Users user = Users.builder()
                .username(usersDto.getUsername())
                .email(usersDto.getEmail())
                .password(passwordEncoder.encode(usersDto.getPassword()))
                .roleId(usersDto.getRoleId())
                .build();
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> update(int id, UsersDto usersDto) {
        return usersRepository.findById(id).map(existingUser -> {
            if (usersDto.getPassword() != null && !usersDto.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(usersDto.getPassword()));
            }
            existingUser.setUsername(usersDto.getUsername());
            existingUser.setEmail(usersDto.getEmail());
            existingUser.setRoleId(usersDto.getRoleId());

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
}
