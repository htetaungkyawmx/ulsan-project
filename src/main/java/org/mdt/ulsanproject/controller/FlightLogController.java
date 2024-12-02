package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.service.FlightLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightLogController {
    @Autowired
    private FlightLogService flightLogService;

}
