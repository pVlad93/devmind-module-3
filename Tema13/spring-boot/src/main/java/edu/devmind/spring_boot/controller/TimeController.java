package edu.devmind.spring_boot.controller;

import edu.devmind.spring_boot.service.TimeZoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private final TimeZoneService timeZoneService;

    public TimeController(TimeZoneService timeZoneService) {
        this.timeZoneService = timeZoneService;
    }

    @GetMapping("/time")
    public String getTimezone(@RequestParam("timezone") String timeZone) {
        return timeZoneService.getTime(timeZone);
    }
}
