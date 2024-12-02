package org.mdt.ulsanproject.controller;

import org.mdt.ulsanproject.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneController {
    @Autowired
    private DroneService droneService;
}
