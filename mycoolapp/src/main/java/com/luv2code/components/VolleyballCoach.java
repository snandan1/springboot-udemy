package com.luv2code.components;

import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements ICoach {

    public VolleyballCoach() {
        System.out.println("Inside VolleyballCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice jumping in the court";
    }
}
