package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.FlightLogDto;
import org.mdt.ulsanproject.model.FlightLog;
import org.mdt.ulsanproject.repository.FlightLogRepository;
import org.mdt.ulsanproject.service.FlightLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightLogServiceImpl implements FlightLogService {
    @Autowired
    private FlightLogRepository flightLogRepository;

    @Override
    public FlightLog save(FlightLogDto flightLogDto) {
        FlightLog flightLog = FlightLog.builder()
                .flight_number(flightLogDto.getFlight_number())
                .company_id(flightLogDto.getCompany_id())
                .drone_id(flightLogDto.getDrone_id())
                .pilot_name(flightLogDto.getPilot_name())
                .flight_date(flightLogDto.getFlight_date())
                .duration(flightLogDto.getDuration())
                .status(flightLogDto.getStatus())
                .build();
        return flightLogRepository.save(flightLog);
    }

    @Override
    public FlightLog update(int id, FlightLogDto flightLogDto) {

        return null;
    }

    @Override
    public List<FlightLog> findAll() {
        return flightLogRepository.findAll();
    }

    @Override
    public Optional<FlightLog> findById(int id) {
        return flightLogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        flightLogRepository.deleteById(id);
    }

}
