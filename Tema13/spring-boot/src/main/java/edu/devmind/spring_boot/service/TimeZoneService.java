package edu.devmind.spring_boot.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeZoneService {

    public String getTime(String timeZone) {
        ZonedDateTime currentTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        switch (timeZone) {
            case "UTC":
                currentTime = ZonedDateTime.now(ZoneId.of("UTC"));
                break;
            case "CET":
                currentTime = ZonedDateTime.now(ZoneId.of("CET"));
                break;
            case "EET":
                currentTime = ZonedDateTime.now(ZoneId.of("EET"));
                break;
            case "GMT":
                currentTime = ZonedDateTime.now(ZoneId.of("GMT"));
                break;
            case "EAT":
                currentTime = ZonedDateTime.now(ZoneId.of("Africa/Nairobi"));
                break;
            default:
                currentTime = ZonedDateTime.now(ZoneId.of("CET"));
        }
        return currentTime.format(formatter);
    }
}
