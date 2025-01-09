package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.FlightLogDto;
import org.mdt.ulsanproject.dto.FlightLogUpdateDto;
import org.mdt.ulsanproject.model.FlightLog;

import java.util.List;
import java.util.Optional;

public interface FlightLogService {
    FlightLog save(FlightLogDto flightLogDto);

    Optional<FlightLog> update(int id, FlightLogDto flightLogDto);

    Optional<FlightLog> update(int id, FlightLogUpdateDto flightLogUpdateDto);

    List<FlightLog> findAll();

    Optional<FlightLog> findById(Long id);

    void delete(Long id);

}
