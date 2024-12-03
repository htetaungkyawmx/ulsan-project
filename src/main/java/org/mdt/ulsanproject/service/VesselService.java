package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.VesselDto;
import org.mdt.ulsanproject.model.Vessel;

import java.util.List;
import java.util.Optional;

public interface VesselService {
    Vessel save(VesselDto vesselDto);
    Vessel update(int id, VesselDto vesselDto);
    List<Vessel> findAll();
    Optional<Vessel> findById(int id);
    void delete(int id);
}
