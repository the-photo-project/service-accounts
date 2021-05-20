package com.photoproject.service.accounts.vu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.photoproject.service.accounts.greeting.Greeting;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple resource controller class from the Spring REST Service Guide.
 *
 * @link https://spring.io/guides/gs/rest-service/
 */

@RestController
public class VuController {

    private static final String template = "Xin chao, This is Vu's Controller, %s!";
    private static final String templatetwo = "Xin chao, This is Vu's Second Function, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/vu")
    public Vu vu(@RequestParam(value = "name", defaultValue = "Vu") String name) {
        return new Vu(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/vu/test2")
    public Vu testtwo(@RequestParam(value = "name", defaultValue = "Vu") String name) {
        return new Vu(counter.incrementAndGet(), String.format(templatetwo, name));
    }
}
