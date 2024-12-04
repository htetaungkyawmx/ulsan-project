package org.mdt.ulsanproject.util;

import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasswordEncoderUtil {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void encodeExistingPasswords() {
        List<Users> users = usersRepository.findAll();
        for (Users user : users) {
            if (!user.getPassword().startsWith("$2a$")) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                usersRepository.save(user);
            }
        }
    }
}
