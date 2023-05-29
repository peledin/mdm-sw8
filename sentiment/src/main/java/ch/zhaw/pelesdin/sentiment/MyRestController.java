package ch.zhaw.pelesdin.sentiment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    // Erster Endpunkt
    @GetMapping("/greet")
    public String greet() {
        return "Hello, User!";
    }

    // Zweiter Endpunkt
    @GetMapping("/info")
    public User info() {
        return new User("John Doe", "john.doe@example.com");
    }
}
