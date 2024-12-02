package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.mdt.ulsanproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users save(UsersDto usersDto) {
        return null;
    }

    @Override
    public Users update(int id, UsersDto usersDto) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

}
