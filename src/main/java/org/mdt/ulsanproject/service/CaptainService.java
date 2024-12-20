package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.CaptainBaseDTO;
import org.mdt.ulsanproject.model.Captain;

import java.util.List;

public interface CaptainService {
    Captain createCaptain(CaptainBaseDTO captainBaseDTO);
    List<Captain> getAllCaptains();
    Captain getCaptainById(int id);
    Captain updateCaptain(int id, CaptainBaseDTO captainBaseDTO);
    Captain deleteCaptain(int id);
}
