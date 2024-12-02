package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl {
    @Autowired
    private UsersRepository usersRepository;

}
