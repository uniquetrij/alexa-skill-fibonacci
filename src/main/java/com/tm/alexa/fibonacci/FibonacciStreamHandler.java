package com.tm.alexa.fibonacci;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.tm.alexa.fibonacci.handlers.*;

public class FibonacciStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new FibonacciIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler()).withSkillId("amzn1.ask.skill.62789074-fe5f-4399-b0cc-bfaf79ba1dc5")
                .build();
    }

    public FibonacciStreamHandler() {
        super(getSkill());
    }

}