package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;


}
