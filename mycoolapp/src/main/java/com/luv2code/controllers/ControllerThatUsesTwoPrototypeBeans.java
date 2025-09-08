package com.luv2code.controllers;

import com.luv2code.components.ICoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerThatUsesTwoPrototypeBeans {

    private final ICoach soccerCoachOne;
    private final ICoach soccerCoachTwo;

    public ControllerThatUsesTwoPrototypeBeans(
            @Qualifier("soccerCoach") ICoach coachOne,
            @Qualifier("soccerCoach") ICoach coachTwo) {
        soccerCoachOne = coachOne;
        soccerCoachTwo = coachTwo;
    }

    @GetMapping("/soccer-workout")
    public String getSoccerWorkout() {
        return soccerCoachOne.getDailyWorkout() + " " + soccerCoachTwo.getDailyWorkout();
    }

    @GetMapping("/bean-equality-proto")
    public String getBeanEqualityWithProto() {
        return Boolean.valueOf(soccerCoachOne.equals(soccerCoachTwo)).toString();
    }
}
