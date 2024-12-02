package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.FlightLogDto;
import org.mdt.ulsanproject.model.FlightLog;
import org.mdt.ulsanproject.repository.FlightLogRepository;
import org.mdt.ulsanproject.service.FlightLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightLogServiceImpl implements FlightLogService {
    @Autowired
    private FlightLogRepository flightLogRepository;

    @Override
    public FlightLog save(FlightLogDto flightLogDto) {
        return null;
    }

    @Override
    public FlightLog update(int id, FlightLogDto flightLogDto) {
        return null;
    }

    @Override
    public List<FlightLog> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

}
