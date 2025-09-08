package com.luv2code.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/hello")
    public String sayHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Team: " + teamName + ", Coach: " + coachName;
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return "Greetings, there Visitor!!";
    }
}
