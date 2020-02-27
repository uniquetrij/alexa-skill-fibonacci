package com.tm.alexa.fibonacci.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("FibonacciIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
        Map<String, Slot> slots = intentRequest.getIntent().getSlots();

        String speechText = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(Integer.parseInt(slots.get("number").getValue()))
                .map(i -> i[0])
                .collect(Collectors.toList()).toString();

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Fibonacci", speechText)
                .build();
    }


}