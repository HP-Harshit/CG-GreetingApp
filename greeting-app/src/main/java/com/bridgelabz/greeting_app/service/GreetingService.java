package com.bridgelabz.greeting_app.service;

import com.bridgelabz.greeting_app.model.Greeting;
import java.util.List;
import java.util.Optional;

public interface GreetingService {
    String getGreetingMessage();
    String getGreetingMessage(String firstName, String lastName);
    Greeting saveGreeting(String message);
    Optional<Greeting> findGreetingById(Long id);
    List<Greeting> findAllGreetings();
}
