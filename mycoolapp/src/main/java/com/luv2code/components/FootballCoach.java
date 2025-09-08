package com.luv2code.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements ICoach {

    public FootballCoach() {
        System.out.println("Inside FootballCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice sprinting";
    }
}
