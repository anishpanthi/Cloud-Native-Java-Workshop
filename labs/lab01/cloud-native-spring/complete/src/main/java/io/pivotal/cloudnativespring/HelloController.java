package io.pivotal.cloudnativespring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${greeting:Hola}")
    private String greeting;

    @GetMapping("/hello")
    public String sayHello() {
        return greeting + " World!";
    }

    @PostMapping("/hello")
    public String sayHelloPost(@RequestBody String text) {
        return greeting + text;
    }
}
