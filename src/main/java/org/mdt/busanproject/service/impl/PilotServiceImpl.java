package org.mdt.busanproject.service.impl;

import org.mdt.aioceaneye.dto.PilotDto;
import org.mdt.aioceaneye.model.Pilot;
import org.mdt.aioceaneye.repository.PilotRepository;
import org.mdt.aioceaneye.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Override
    public Pilot save(PilotDto pilotDto) {
        Pilot pilot = Pilot.builder()
                .email(pilotDto.getEmail())
                .password(pilotDto.getPassword())
                .build();
        return pilotRepository.save(pilot);
    }

    @Override
    public List<Pilot> findAll() {
        return pilotRepository.findAll();
    }

    @Override
    public Optional<Pilot> findById(int id) {
        return pilotRepository.findById(id);
    }

    @Override
    public Pilot findByEmail(String email) {
        return pilotRepository.findByEmail(email);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Pilot pilot = pilotRepository.findByEmail(email);
        return pilot != null && pilot.getPassword().equals(password);
    }
}
