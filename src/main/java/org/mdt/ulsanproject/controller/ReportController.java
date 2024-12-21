package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.ReportDto;
import org.mdt.ulsanproject.model.Report;
import org.mdt.ulsanproject.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    // Create Report
    @PostMapping
    public ResponseEntity<Report> create(@RequestBody ReportDto reportDto) {
        Report createdReport = reportService.save(reportDto);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    // Get All Reports
    @GetMapping
    public ResponseEntity<List<Report>> getAll() {
        List<Report> reports = reportService.findAll();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Get Report by ID
    @GetMapping("/{id}")
    public ResponseEntity<Report> getById(@PathVariable int id) {
        return reportService.findById(id)
                .map(report -> new ResponseEntity<>(report, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update Report
    @PutMapping("/{id}")
    public ResponseEntity<Report> update(@PathVariable int id, @RequestBody ReportDto reportDto) {
        return reportService.update(id, reportDto)
                .map(updatedReport -> new ResponseEntity<>(updatedReport, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete Report (Soft Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        reportService.softDelete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
