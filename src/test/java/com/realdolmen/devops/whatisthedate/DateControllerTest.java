package com.realdolmen.devops.whatisthedate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.realdolmen.devops.whatisthedate.date.DateController;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DateControllerTest {
    
    @Mock
    private Clock clock;
    
    @InjectMocks
    private DateController dateController;
    
    @Test
    void givenClockHasTime_whenCallController_thenReturnUtcTimeAsText() {
        Instant fakeInstant = LocalDate.parse("2022-08-02")
                .atStartOfDay()
                .plus(9, ChronoUnit.HOURS)
                .toInstant(ZoneOffset.ofHours(1));
        
        when(clock.instant()).thenReturn(fakeInstant);
        
        String dateText = dateController.getUtcTime();
        
        assertThat(dateText).isEqualTo("2022-08-02T08:00:00Z");
    }
}
