package com.bridgelabz.greeting_app.service;

public interface GreetingService {
    String getGreetingMessage();
    String getGreetingMessage(String firstName, String lastName);
}
