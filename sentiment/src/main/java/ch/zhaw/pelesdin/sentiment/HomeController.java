package ch.zhaw.pelesdin.sentiment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home(Model model) {
        String greet = restTemplate.getForObject("http://localhost:8080/greet", String.class);
        User user = restTemplate.getForObject("http://localhost:8080/info", User.class);

        model.addAttribute("greet", greet);
        model.addAttribute("user", user);

        return "home";
    }
}
