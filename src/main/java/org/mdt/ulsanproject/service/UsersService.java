package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.UsersDto;
import org.mdt.ulsanproject.model.Users;

import java.util.List;

public interface UsersService {
    Users save(UsersDto usersDto);
    Users update(int id, UsersDto usersDto);
    List<Users> findAll();
    void delete(int id);
}
