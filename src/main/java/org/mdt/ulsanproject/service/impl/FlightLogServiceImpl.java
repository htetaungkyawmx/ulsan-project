package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.repository.FlightLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightLogServiceImpl {
    @Autowired
    private FlightLogRepository flightLogRepository;

}
