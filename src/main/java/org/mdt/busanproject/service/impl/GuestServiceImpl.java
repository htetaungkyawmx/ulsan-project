package org.mdt.busanproject.service.impl;

import org.mdt.busanproject.dto.GuestDto;
import org.mdt.busanproject.model.Guest;
import org.mdt.busanproject.repository.GuestRepository;
import org.mdt.busanproject.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest save(GuestDto guestDto) {
        Guest guest = Guest.builder()
                .email(guestDto.getEmail())
                .password(guestDto.getPassword())
                .build();
        return guestRepository.save(guest);
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Optional<Guest> findById(int id) {
        return guestRepository.findById(id);
    }

    @Override
    public Guest findByEmail(String email) {
        return guestRepository.findByEmail(email);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Guest guest = guestRepository.findByEmail(email);
        return guest != null && guest.getPassword().equals(password);
    }
}
