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
                .serialnumber(vesselDto.getSerialnumber())
                .name(vesselDto.getName())
                .type(vesselDto.getType())
                .manufacturer(vesselDto.getManufacturer())
                .picture(vesselDto.getPicture())
                .weight(vesselDto.getWeight())
                .capacity(vesselDto.getCapacity())
                .IMO(vesselDto.getIMO())
                .MMSI(vesselDto.getMMSI())
                .callsign(vesselDto.getCallsign())
                .nation(vesselDto.getNation())
                .length(vesselDto.getLength())
                .build();
        return vesselRepository.save(vessel);
    }

    @Override
    public Optional<Vessel> update(int id, VesselDto vesselDto) {
        return vesselRepository.findById(id).map(existingVessel -> {
            existingVessel.setSerialnumber(vesselDto.getSerialnumber());
            existingVessel.setName(vesselDto.getName());
            existingVessel.setType(vesselDto.getType());
            existingVessel.setManufacturer(vesselDto.getManufacturer());
            existingVessel.setPicture(vesselDto.getPicture());
            existingVessel.setWeight(vesselDto.getWeight());
            existingVessel.setCapacity(vesselDto.getCapacity());
            existingVessel.setIMO(vesselDto.getIMO());
            existingVessel.setMMSI(vesselDto.getMMSI());
            existingVessel.setCallsign(vesselDto.getCallsign());
            existingVessel.setNation(vesselDto.getNation());
            existingVessel.setLength(vesselDto.getLength());
            return vesselRepository.save(existingVessel);
        });
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
