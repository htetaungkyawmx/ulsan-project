package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.CaptainBaseDTO;
import org.mdt.ulsanproject.model.Captain;
import org.mdt.ulsanproject.repository.CaptainRepository;
import org.mdt.ulsanproject.service.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainServiceImpl implements CaptainService {

    @Autowired
    private CaptainRepository captainRepository;

    @Override
    public Captain createCaptain(CaptainBaseDTO captainBaseDTO) {
        if (captainRepository.findByLicenseNumber(captainBaseDTO.getLicenseNumber()).isPresent()) {
            throw new RuntimeException("Captain with this license number already exists");
        }

        Captain captain = Captain.builder()
                .name(captainBaseDTO.getName())
                .licenseNumber(captainBaseDTO.getLicenseNumber())
                .nationality(captainBaseDTO.getNationality())
                .picture(captainBaseDTO.getPicture())
                .yearsOfExperience(captainBaseDTO.getYearsOfExperience())
                .certificates(captainBaseDTO.getCertificates())
                .specializations(captainBaseDTO.getSpecializations())
                .medicalClearanceDate(captainBaseDTO.getMedicalClearanceDate())
                .assignedVesselId(captainBaseDTO.getAssignedVesselId())
                .languagesKnown(captainBaseDTO.getLanguagesKnown())
                .contactInfo(captainBaseDTO.getContactInfo())
                .isDelete(false)
                .build();

        return captainRepository.save(captain);
    }

    @Override
    public List<Captain> getAllCaptains() {
        return captainRepository.findAll().stream().filter(c -> !c.isDelete()).toList();
    }

    @Override
    public Captain getCaptainById(int id) {
        return captainRepository.findByIdAndIsDeleteFalse(id)
                .orElseThrow(() -> new RuntimeException("Captain not found"));
    }

    @Override
    public Captain updateCaptain(int id, CaptainBaseDTO captainBaseDTO) {
        Captain captain = getCaptainById(id);
        if (captainBaseDTO.getName() != null) captain.setName(captainBaseDTO.getName());
        if (captainBaseDTO.getLicenseNumber() != null) captain.setLicenseNumber(captainBaseDTO.getLicenseNumber());
        if (captainBaseDTO.getNationality() != null) captain.setNationality(captainBaseDTO.getNationality());
        if (captainBaseDTO.getPicture() != null) captain.setPicture(captainBaseDTO.getPicture());
        if (captainBaseDTO.getYearsOfExperience() != 0) captain.setYearsOfExperience(captainBaseDTO.getYearsOfExperience());
        if (captainBaseDTO.getCertificates() != null) captain.setCertificates(captainBaseDTO.getCertificates());
        if (captainBaseDTO.getSpecializations() != null) captain.setSpecializations(captainBaseDTO.getSpecializations());
        if (captainBaseDTO.getMedicalClearanceDate() != null) captain.setMedicalClearanceDate(captainBaseDTO.getMedicalClearanceDate());
        if (captainBaseDTO.getAssignedVesselId() != null) captain.setAssignedVesselId(captainBaseDTO.getAssignedVesselId());
        if (captainBaseDTO.getLanguagesKnown() != null) captain.setLanguagesKnown(captainBaseDTO.getLanguagesKnown());
        if (captainBaseDTO.getContactInfo() != null) captain.setContactInfo(captainBaseDTO.getContactInfo());

        return captainRepository.save(captain);
    }

    @Override
    public Captain deleteCaptain(int id) {
        Captain captain = getCaptainById(id);
        captain.setDelete(true);
        return captainRepository.save(captain);
    }
}
