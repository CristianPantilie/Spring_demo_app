package com.salutlume.salutlume;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalutlumeApplication {

    @Bean
    ApplicationRunner applicationRunner(GreetingRepository greetingRepository){
        return args -> {
            greetingRepository.save(new Greeting("hello"));
            greetingRepository.save(new Greeting("hi"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalutlumeApplication.class, args);
    }

}
