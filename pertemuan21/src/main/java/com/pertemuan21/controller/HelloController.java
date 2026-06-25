package com.pertemuan21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "<h1>Selamat Datang di Spring Boot!</h1>"
             + "<p>Pertemuan 21 - Framework Java Spring Boot</p>"
             + "<p>Aplikasi berjalan dengan sukses.</p>";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/api/info")
    public java.util.Map<String, String> info() {
        java.util.Map<String, String> data = new java.util.LinkedHashMap<>();
        data.put("nama", "Pertemuan 21");
        data.put("framework", "Spring Boot 3.5.3");
        data.put("java", System.getProperty("java.version"));
        data.put("status", "running");
        return data;
    }
}
