package com.project.springapistudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringApiStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiStudyApplication.class, args);
    }

}
