package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.PilotDto;
import org.mdt.ulsanproject.model.Pilot;
import org.mdt.ulsanproject.repository.PilotRepository;
import org.mdt.ulsanproject.service.PilotService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PilotServiceImpl implements PilotService {

    private final PilotRepository pilotRepository;

    public PilotServiceImpl(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    @Override
    public PilotDto createPilot(PilotDto pilotDto) {
        if (pilotRepository.existsBySerialNumberOrPassportNo(pilotDto.getSerialNumber(), pilotDto.getPassportNo())) {
            throw new RuntimeException("Pilot with this serial number or passport number already exists");
        }

        Pilot pilot = new Pilot();
        BeanUtils.copyProperties(pilotDto, pilot);

        Pilot savedPilot = pilotRepository.save(pilot);
        PilotDto responseDto = new PilotDto();
        BeanUtils.copyProperties(savedPilot, responseDto);

        return responseDto;
    }

    @Override
    public List<PilotDto> getAllPilots() {
        return pilotRepository.findAll()
                .stream()
                .map(pilot -> {
                    PilotDto dto = new PilotDto();
                    BeanUtils.copyProperties(pilot, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PilotDto getPilotById(int id) {
        Pilot pilot = pilotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pilot not found"));

        PilotDto dto = new PilotDto();
        BeanUtils.copyProperties(pilot, dto);

        return dto;
    }

    @Override
    public PilotDto updatePilot(int id, PilotDto pilotDto) {
        Pilot pilot = pilotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pilot not found"));

        BeanUtils.copyProperties(pilotDto, pilot, "id", "createdDate", "isDelete");
        pilotRepository.save(pilot);

        PilotDto responseDto = new PilotDto();
        BeanUtils.copyProperties(pilot, responseDto);

        return responseDto;
    }

    @Override
    public PilotDto deletePilot(int id) {
        Pilot pilot = pilotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pilot not found"));

        pilot.setDelete(true);
        pilotRepository.save(pilot);

        PilotDto dto = new PilotDto();
        BeanUtils.copyProperties(pilot, dto);

        return dto;
    }
}
