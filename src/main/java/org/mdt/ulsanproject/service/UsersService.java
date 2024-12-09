package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users save(UsersDto usersDto);
    Optional<Users> update(int id, UsersDto usersDto);
    List<Users> findAll();
    Optional<Users> findById(int id);
    void delete(int id);
}
