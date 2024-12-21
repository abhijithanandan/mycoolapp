package com.abhijithanandan.mycoolapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach {
    /**
     * @return String
     */
    @Override
    public String dailyWorkout() {
        return "Run a hard 5k";
    }
}
