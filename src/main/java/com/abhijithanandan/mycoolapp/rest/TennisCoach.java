package com.abhijithanandan.mycoolapp.rest;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    /**
     * @return String
     */
    @Override
    public String dailyWorkout() {
        return "Practice your backhand volley";
    }
}
