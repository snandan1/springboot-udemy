package com.luv2code.components;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SoccerCoach implements ICoach {

    public SoccerCoach() {
        System.out.println("Inside SoccerCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice dribbling";
    }
}
