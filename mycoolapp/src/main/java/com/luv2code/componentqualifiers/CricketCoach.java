package com.luv2code.componentqualifiers;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
        return "Practice batting for 3 hours everyday";
    }
}
