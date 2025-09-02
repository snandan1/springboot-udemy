package com.luv2code.componentqualifiers;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements ICoach {

    public BasketballCoach() {
        System.out.println("Inside BasketballCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice jumping and dunking";
    }
}
