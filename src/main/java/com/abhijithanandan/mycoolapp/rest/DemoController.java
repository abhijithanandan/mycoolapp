package com.abhijithanandan.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for dependency
    private Coach myCoach;

    // define constructor for dependency injection

    // Generally recommended by the spring.io development team as first choice

//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//    }

    // Use this when we have optional dependencies, provide a reasonable default logic

    @Autowired
    public void setMyCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return myCoach.dailyWorkout();
    }

}
