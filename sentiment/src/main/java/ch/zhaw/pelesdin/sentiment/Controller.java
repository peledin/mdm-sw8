package ch.zhaw.pelesdin.sentiment;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ai.djl.modality.Classifications;

@RestController
public class Controller {
    @RequestMapping(value = { "/analyze", "/analyze" }, method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String analyze(@RequestParam String text) {
        try {
            Classifications classifications = SentimentAnalysis.predict(text);
            return classifications.toString();
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/greet")
    @ResponseBody
    public String greetUser() {
        LocalTime currentTime = LocalTime.now();
        String greeting = "Hello! The current time is: " + currentTime;
        return greeting;
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "Sentiment Analysis is running!";
    }
}