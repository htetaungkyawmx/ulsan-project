package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.CaptainBaseDto;
import org.mdt.ulsanproject.model.Captain;

import java.util.List;

public interface CaptainService {
    Captain createCaptain(CaptainBaseDto captainBaseDTO);
    List<Captain> getAllCaptains();
    Captain getCaptainById(int id);
    Captain updateCaptain(int id, CaptainBaseDto captainBaseDTO);
    Captain deleteCaptain(int id);
}
