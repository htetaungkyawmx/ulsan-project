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
        // Validate input
        if (reportDto.getTitle() == null || reportDto.getContent() == null) {
            throw new IllegalArgumentException("Title and content cannot be null");
        }

        Report report = Report.builder()
                .title(reportDto.getTitle())
                .content(reportDto.getContent())
                .authorId(reportDto.getAuthorId())
                .reportType(reportDto.getReportType())
                .visibility(reportDto.getVisibility() != null ? reportDto.getVisibility() : "Public")
                .category(reportDto.getCategory())
                .date(reportDto.getDate())
                .failureDefects(reportDto.getFailureDefects())
                .build();

        return reportRepository.save(report);
    }

    @Override
    public Optional<Report> update(int id, ReportDto reportDto) {
        return reportRepository.findById(id).map(existingReport -> {
            // Update fields only if they are provided
            if (reportDto.getTitle() != null) existingReport.setTitle(reportDto.getTitle());
            if (reportDto.getContent() != null) existingReport.setContent(reportDto.getContent());
            if (reportDto.getReportType() != null) existingReport.setReportType(reportDto.getReportType());
            if (reportDto.getVisibility() != null) existingReport.setVisibility(reportDto.getVisibility());
            if (reportDto.getCategory() != null) existingReport.setCategory(reportDto.getCategory());
            if (reportDto.getDate() != null) existingReport.setDate(reportDto.getDate());
            if (reportDto.getFailureDefects() != null) existingReport.setFailureDefects(reportDto.getFailureDefects());

            return reportRepository.save(existingReport);
        });
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
    public void softDelete(int id) {
        reportRepository.findById(id).ifPresent(report -> {
            if (!report.isDeleted()) {
                report.setDeleted(true);
                reportRepository.save(report);
            }
        });
    }
}
