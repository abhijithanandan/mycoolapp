package com.abhijithanandan.mycoolapp.rest;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    /**
     * @return String
     */
    @Override
    public String dailyWorkout() {
        return "Run a hard 5k";
    }
}
