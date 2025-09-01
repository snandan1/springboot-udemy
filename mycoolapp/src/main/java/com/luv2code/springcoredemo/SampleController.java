package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private ICoach coach;

    @Autowired
    public void setCoach(ICoach aCoach) {
        coach = aCoach;
    }

    @GetMapping("/setter-injection-test")
    public String getSetterInjectionTest() {
        return "From Setter injection method: " + coach.getDailyWorkout();
    }
}
