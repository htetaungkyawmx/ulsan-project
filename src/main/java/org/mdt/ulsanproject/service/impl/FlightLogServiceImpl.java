package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.FlightLogDto;
import org.mdt.ulsanproject.dto.FlightLogUpdateDto;
import org.mdt.ulsanproject.model.FlightLog;
import org.mdt.ulsanproject.repository.FlightLogRepository;
import org.mdt.ulsanproject.service.FlightLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightLogServiceImpl implements FlightLogService {

    @Autowired
    private FlightLogRepository flightLogRepository;

    @Override
    public FlightLog save(FlightLogDto flightLogDto) {
        FlightLog flightLog = mapDtoToEntity(flightLogDto);
        flightLog.setCreatedAt(LocalDateTime.now());
        flightLog.setUpdatedAt(LocalDateTime.now());
        flightLog.setIsDeleted(false);
        return flightLogRepository.save(flightLog);
    }

    @Override
    public Optional<FlightLog> update(int id, FlightLogDto flightLogDto) {
        return flightLogRepository.findById((long) id)
                .map(existingFlightLog -> {
                    updateEntityFromDto(existingFlightLog, flightLogDto);
                    existingFlightLog.setUpdatedAt(LocalDateTime.now());
                    return flightLogRepository.save(existingFlightLog);
                });
    }

    @Override
    public Optional<FlightLog> update(int id, FlightLogUpdateDto flightLogUpdateDto) {
        return flightLogRepository.findById((long) id)
                .map(existingFlightLog -> {
                    updateEntityFromUpdateDto(existingFlightLog, flightLogUpdateDto);
                    existingFlightLog.setUpdatedAt(LocalDateTime.now());
                    return flightLogRepository.save(existingFlightLog);
                });
    }

    @Override
    public List<FlightLog> findAll() {
        return flightLogRepository.findAll();
    }

    @Override
    public Optional<FlightLog> findById(Long id) {
        return flightLogRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        FlightLog flightLog = flightLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight Log not found"));
        flightLog.setIsDeleted(true);
        flightLog.setUpdatedAt(LocalDateTime.now());
        flightLogRepository.save(flightLog);
    }

    // Helper method to map DTO to Entity
    private FlightLog mapDtoToEntity(FlightLogDto dto) {
        FlightLog flightLog = new FlightLog();
        // Mapping all fields from dto to entity
        flightLog.setPilotSerialNumber(dto.getPilotSerialNumber());
        flightLog.setDroneSerialNumber(dto.getDroneSerialNumber());
        flightLog.setFlightIdx(dto.getFlightIdx());
        flightLog.setWindChurningWind(dto.getWindChurningWind());
        flightLog.setBatterySerialNumber(dto.getBatterySerialNumber());
        flightLog.setTakeoffTime(dto.getTakeoffTime());
        flightLog.setTakeoffSituationSpeed(dto.getTakeoffSituationSpeed());
        flightLog.setTakeoffPosition(dto.getTakeoffPosition());
        flightLog.setTakeoffLandmark(dto.getTakeoffLandmark());
        flightLog.setLandingTime(dto.getLandingTime());
        flightLog.setLandingSituationVesselSpeed(dto.getLandingSituationVesselSpeed());
        flightLog.setLandMap(dto.getLandMap());
        flightLog.setLandingMap(dto.getLandingMap());
        flightLog.setFlightTimeMinutes(dto.getFlightTimeMinutes());
        flightLog.setFlightRadiusKm(dto.getFlightRadiusKm());
        flightLog.setFlightDistanceKm(dto.getFlightDistanceKm());
        flightLog.setCruiseFlightAltitudeM(dto.getCruiseFlightAltitudeM());
        flightLog.setCruiseFlightSpeedMs(dto.getCruiseFlightSpeedMs());
        flightLog.setWhitewave1DiscoveryTime(dto.getWhitewave1DiscoveryTime());
        flightLog.setWhitewave1Latitude(dto.getWhitewave1Latitude());
        flightLog.setWhitewave1Hardness(dto.getWhitewave1Hardness());
        flightLog.setWhitewave1ShootingAltitude(dto.getWhitewave1ShootingAltitude());
        flightLog.setWhitewave1ShootingSpeed(dto.getWhitewave1ShootingSpeed());
        flightLog.setWhitewave1ShootingRadius(dto.getWhitewave1ShootingRadius());
        flightLog.setWhitewave1DetectedFish(dto.getWhitewave1DetectedFish());
        flightLog.setWhitewave1DetectedTones(dto.getWhitewave1DetectedTones());
        flightLog.setWhitewave1VesselMissionStatus(dto.getWhitewave1VesselMissionStatus());
        flightLog.setWhitewave2DiscoveryTime(dto.getWhitewave2DiscoveryTime());
        flightLog.setWhitewave2Latitude(dto.getWhitewave2Latitude());
        flightLog.setWhitewave2Hardness(dto.getWhitewave2Hardness());
        return flightLog;
    }

    // Helper method to update FlightLog entity from FlightLogDto
    private void updateEntityFromDto(FlightLog flightLog, FlightLogDto dto) {
        if (dto.getPilotSerialNumber() != null) flightLog.setPilotSerialNumber(dto.getPilotSerialNumber());
        if (dto.getDroneSerialNumber() != null) flightLog.setDroneSerialNumber(dto.getDroneSerialNumber());
        // Similarly for other fields...
    }

    // Helper method to update FlightLog entity from FlightLogUpdateDto
    private void updateEntityFromUpdateDto(FlightLog flightLog, FlightLogUpdateDto updateDto) {
        if (updateDto.getPilotSerialNumber() != null) flightLog.setPilotSerialNumber(updateDto.getPilotSerialNumber());
        // Similarly for other fields...
    }
}
