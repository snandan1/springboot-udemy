package com.luv2code.componentqualifiers;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

    public CricketCoach() {
        System.out.println("Inside CricketCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting for 3 hours everyday";
    }
}
