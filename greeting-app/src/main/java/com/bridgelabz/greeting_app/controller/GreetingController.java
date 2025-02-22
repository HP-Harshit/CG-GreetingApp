package com.bridgelabz.greeting_app.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "!");
        return response;
    }

    @PostMapping
    public Map<String, String> createGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting created for " + name + "!");
        return response;
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
