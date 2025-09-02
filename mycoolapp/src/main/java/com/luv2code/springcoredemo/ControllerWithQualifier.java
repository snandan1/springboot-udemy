package com.luv2code.springcoredemo;

import com.luv2code.componentqualifiers.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithQualifier {

    private ICoach coach;

    @Autowired
    public ControllerWithQualifier(@Qualifier("cricketCoach") ICoach aCoach) {
        coach = aCoach;
    }

    @GetMapping("qualified-workout")
    public String getQualifiedWorkout() {
        return coach.getDailyWorkout();
    }
}
