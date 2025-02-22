package com.bridgelabz.greeting_app.service;

import com.bridgelabz.greeting_app.model.Greeting;
import com.bridgelabz.greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String getGreetingMessage() {
        return "Hello, World";
    }

    @Override
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello, " + firstName + " " + lastName;
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello, " + firstName;
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello, " + lastName;
        } else {
            return "Hello, World";
        }
    }

    @Override
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
