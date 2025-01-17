package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.dto.ReportDto;
import org.mdt.ulsanproject.model.Report;
import org.mdt.ulsanproject.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports/")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> create(@RequestBody ReportDto reportDto) {
        return ResponseEntity.status(201).body(reportService.save(reportDto));
    }

    @GetMapping
    public ResponseEntity<List<Report>> getAll() {
        return ResponseEntity.ok(reportService.findAll());
    }

    @GetMapping("{id}/")
    public ResponseEntity<Report> getById(@PathVariable int id) {
        return reportService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}/")
    public ResponseEntity<Report> update(@PathVariable int id, @RequestBody ReportDto reportDto) {
        return reportService.update(id, reportDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        reportService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
