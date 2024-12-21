package com.abhijithanandan.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {
    @Override
    public String dailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @PostConstruct
    public void doStartupStuff() {
        System.out.println("I'm doing startup stuff for :" + this.getClass().getName());
    }

    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("I'm doing cleanup stuff for :" + this.getClass().getName());
    }
}
