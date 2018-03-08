package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
@RestController
public class ConfigServerApplication {

    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
