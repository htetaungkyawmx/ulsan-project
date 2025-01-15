package org.mdt.ulsanproject.client;

import org.springframework.stereotype.Service;

@Service
public class TelemetryService {
    private String latestTelemetryData = "No data available";

    public synchronized void outputTelemetryData(String telemetryData) {
        this.latestTelemetryData = telemetryData;
    }

    public synchronized String getLatestTelemetryData() {
        return latestTelemetryData;
    }
}
