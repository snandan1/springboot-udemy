package com.luv2code.controllers;

import com.luv2code.components.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private ICoach myCoach;

    @Autowired
    public DemoController(ICoach aCoach) {
        System.out.println("Inside DemoController constructor");
        myCoach = aCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
