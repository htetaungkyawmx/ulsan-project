package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.ReportDto;
import org.mdt.ulsanproject.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    Report save(ReportDto reportDto);
    Report update(int id, ReportDto reportDto);
    List<Report> findAll();
    Optional<Report> findById(int id);
    void delete(int id);
}
