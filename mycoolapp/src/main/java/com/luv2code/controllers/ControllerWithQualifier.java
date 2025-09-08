package com.luv2code.controllers;

import com.luv2code.components.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithQualifier {

    private ICoach coach;

    @Autowired
    public ControllerWithQualifier(@Qualifier("cricketCoach") ICoach aCoach) {
        System.out.println("Inside ControllerWithQualifier constructor");
        coach = aCoach;
    }

    @GetMapping("/cricket-workout")
    public String getCricketWorkout() {
        return coach.getDailyWorkout();
    }
}
