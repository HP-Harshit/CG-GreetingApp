package com.bridgelabz.greeting_app.controller;

import com.bridgelabz.greeting_app.model.Greeting;
import com.bridgelabz.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }

    @GetMapping("/personalized")
    public Map<String, String> getPersonalizedGreeting(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    @PostMapping
    public Greeting createGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        String message = "Hello, " + name + "!";
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/{id}")
    public Optional<Greeting> findGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    @GetMapping("/all")
    public List<Greeting> findAllGreetings() {
        return greetingService.findAllGreetings();
    }

    @PutMapping
    public Map<String, String> updateGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting updated for " + name + "!");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting deleted for " + name + "!");
        return response;
    }
}
