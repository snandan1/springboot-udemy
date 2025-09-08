package com.luv2code.controllers;

import com.luv2code.components.ICoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerThatUsesTwoSingletonBeans {

    private final ICoach volleyballCoachOne;
    private final ICoach volleyballCoachTwo;

    public ControllerThatUsesTwoSingletonBeans(
            @Qualifier("volleyballCoach") ICoach coachOne,
            @Qualifier("volleyballCoach") ICoach coachTwo) {
        volleyballCoachOne = coachOne;
        volleyballCoachTwo = coachTwo;
    }

    @GetMapping("/volleyball-workout")
    public String getVolleyballWorkout() {
        return volleyballCoachOne.getDailyWorkout() + " " + volleyballCoachTwo.getDailyWorkout();
    }

    @GetMapping("/bean-equality")
    public String getBeanEquality() {
        return Boolean.valueOf(volleyballCoachOne.equals(volleyballCoachTwo)).toString();
    }
}
