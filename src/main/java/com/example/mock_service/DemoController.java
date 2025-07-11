package com.example.mock_service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    // GET JSON
    @GetMapping("/message")
    public ResponseEntity<Map<String, Object>> getJson() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello from Eureka client");
        response.put("code", 200);
        return ResponseEntity.ok(response);
    }

    // POST JSON
    @PostMapping("/message")
    public ResponseEntity<String> postJson(@RequestBody MessageRequest request) {
        return ResponseEntity.ok("Received message: " + request.getContent());
    }

    // POST JSON that returns HTTP 500
    @PostMapping("/error")
    public ResponseEntity<String> postJsonError(@RequestBody MessageRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Simulated server error for: " + request.getContent());
    }
}