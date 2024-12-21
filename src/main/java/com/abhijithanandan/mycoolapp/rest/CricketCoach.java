package com.abhijithanandan.mycoolapp.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
