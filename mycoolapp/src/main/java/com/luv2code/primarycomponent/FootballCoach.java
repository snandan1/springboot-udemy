package com.luv2code.primarycomponent;

import com.luv2code.componentqualifiers.ICoach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
        return "Practice sprinting";
    }
}
