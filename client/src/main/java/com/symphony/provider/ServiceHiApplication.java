package com.symphony.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ServiceHiApplication {

    private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());


    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "simon") String name) {
        LOG.log(Level.INFO, "hi is being called");
        return String.format("hi %s, i am from port: %s", name, port);
    }
}
