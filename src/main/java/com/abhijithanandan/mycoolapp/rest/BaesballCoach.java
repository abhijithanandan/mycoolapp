package com.abhijithanandan.mycoolapp.rest;

import org.springframework.stereotype.Component;

@Component
public class BaesballCoach implements Coach {
    /**
     * @return String
     */
    @Override
    public String dailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}