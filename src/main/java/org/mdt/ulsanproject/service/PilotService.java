package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.PilotDto;

import java.util.List;

public interface PilotService {
    PilotDto createPilot(PilotDto pilotDto);
    List<PilotDto> getAllPilots();
    PilotDto getPilotById(int id);
    PilotDto updatePilot(int id, PilotDto pilotDto);
    PilotDto deletePilot(int id);
}
