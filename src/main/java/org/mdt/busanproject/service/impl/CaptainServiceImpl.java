package org.mdt.busanproject.service.impl;

import org.mdt.aioceaneye.dto.CaptainDto;
import org.mdt.aioceaneye.model.Captain;
import org.mdt.aioceaneye.repository.CaptainRepository;
import org.mdt.aioceaneye.service.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaptainServiceImpl implements CaptainService {

    @Autowired
    private CaptainRepository captainRepository;

    @Override
    public Captain save(CaptainDto captainDto) {
        Captain captain = Captain.builder()
                .email(captainDto.getEmail())
                .password(captainDto.getPassword())
                .build();
        return captainRepository.save(captain);
    }

    @Override
    public List<Captain> findAll() {
        return captainRepository.findAll();
    }

    @Override
    public Optional<Captain> findById(int id) {
        return captainRepository.findById(id);
    }

    @Override
    public Captain findByEmail(String email) {
        return captainRepository.findByEmail(email);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Captain captain = captainRepository.findByEmail(email);
        return captain != null && captain.getPassword().equals(password);
    }
}
