package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.VesselDto;
import org.mdt.ulsanproject.model.Vessel;
import org.mdt.ulsanproject.repository.VesselRepository;
import org.mdt.ulsanproject.service.VesselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VesselServiceImpl implements VesselService {
    @Autowired
    private VesselRepository vesselRepository;

    @Override
    public Vessel save(VesselDto vesselDto) {
        Vessel vessel = Vessel.builder()
                .name(vesselDto.getName())
                .type(vesselDto.getType())
                .status(vesselDto.getStatus())
                .capacity(vesselDto.getCapacity())
                .location(vesselDto.getLocation())
                .build();
        return vesselRepository.save(vessel);
    }

    @Override
    public Vessel update(int id, VesselDto vesselDto) {

        return null;
    }

    @Override
    public List<Vessel> findAll() {
        return vesselRepository.findAll();
    }

    @Override
    public Optional<Vessel> findById(int id) {
        return vesselRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        vesselRepository.deleteById(id);
    }
}
