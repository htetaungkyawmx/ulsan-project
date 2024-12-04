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
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> create(@RequestBody ReportDto reportDto) {
        Report createdReport = reportService.save(reportDto);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Report>> getAll() {
        List<Report> reports = reportService.findAll();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getById(@PathVariable int id) {
        return reportService.findById(id)
                .map(report -> new ResponseEntity<>(report, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> update(@PathVariable int id, @RequestBody ReportDto reportDto) {
        return reportService.update(id, reportDto)
                .map(updatedReport -> new ResponseEntity<>(updatedReport, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        reportService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
