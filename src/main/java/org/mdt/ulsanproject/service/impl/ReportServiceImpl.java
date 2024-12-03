package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.ReportDto;
import org.mdt.ulsanproject.model.Report;
import org.mdt.ulsanproject.repository.ReportRepository;
import org.mdt.ulsanproject.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report save(ReportDto reportDto) {
        Report report = Report.builder()
                .title(reportDto.getTitle())
                .content(reportDto.getContent())
                .status(reportDto.getStatus())
                .created_at(reportDto.getCreated_at())
                .build();
        return reportRepository.save(report);
    }

    @Override
    public Report update(int id, ReportDto reportDto) {

        return null;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        reportRepository.deleteById(id);
    }
}
