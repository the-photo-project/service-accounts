package com.photoproject.service.accounts.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple resource controller class from the Spring REST Service Guide.
 *
 * @link https://spring.io/guides/gs/rest-service/
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to
    // the greeting() method.
    // There are companion annotations for other HTTP verbs (e.g. @PostMapping for POST).
    // There is also a @RequestMapping annotation that they all derive from, and can serve
    // as a synonym (e.g. @RequestMapping(method=GET)).
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
