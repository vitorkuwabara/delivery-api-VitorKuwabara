package com.deliverytech.delivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "timestamp", LocalDateTime.now().toString(), "Service", "Delivery API", "javaVersion", System.getProperty("java.version"));
    }
    @GetMapping("/info")
    public AppInfo info() {
        return new AppInfo("Delivery Tech API", "1.0.0", "[Vitor Kenzo Kuwabara]", "JDK 21", "Spring Boot 3.5.7");
    }
    public record AppInfo(String application, String version, String developer, String javaVersion, String framework) { }
}