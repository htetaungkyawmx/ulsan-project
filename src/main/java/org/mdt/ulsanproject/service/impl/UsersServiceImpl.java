package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.mdt.ulsanproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users save(UsersDto usersDto) {
        Users users = Users.builder()
                .username(usersDto.getUsername())
                .email(usersDto.getEmail())
                .password(usersDto.getPassword())
                .build();
        return usersRepository.save(users);
    }

    @Override
    public Users update(int id, UsersDto usersDto) {

        return null;
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
