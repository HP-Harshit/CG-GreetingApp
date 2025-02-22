package com.bridgelabz.greeting_app.service;

import com.bridgelabz.greeting_app.model.Greeting;

public interface GreetingService {
    String getGreetingMessage();
    String getGreetingMessage(String firstName, String lastName);
    Greeting saveGreeting(String message);
}
