package com.realdolmen.devops.whatisthedate.date;

import java.time.Clock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {
    
    private final Clock clock;
    
    public DateController(Clock clock) {
        this.clock = clock;
    }
    
    @GetMapping("/date")
    public String getUtcTime() {
        return clock.instant().toString();
    }
    
}
