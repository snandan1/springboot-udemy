package com.luv2code.componentqualifiers;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
        return "Practice jumping and dunking";
    }
}
