package com.luv2code.componentqualifiers;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements ICoach {

    public HockeyCoach() {
        System.out.println("Inside HockeyCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice passing in the field";
    }
}
