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

    @PutMapping("/{id}")
    public Optional<Greeting> updateGreeting(
            @PathVariable Long id,
            @RequestParam(value = "message") String message) {
        return greetingService.updateGreeting(id, message);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting deleted with ID: " + id);
        return response;
    }
}
