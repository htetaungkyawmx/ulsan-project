package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.FlightLogDto;
import org.mdt.ulsanproject.model.FlightLog;

import java.util.List;
import java.util.Optional;

public interface FlightLogService {
    FlightLog save(FlightLogDto flightLogDto);
    FlightLog update(int id, FlightLogDto flightLogDto);
    List<FlightLog> findAll();
    Optional<FlightLog> findById(int id);
    void delete(int id);
}
