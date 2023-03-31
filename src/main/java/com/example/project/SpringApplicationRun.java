package com.example.project;

import com.example.project.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationRun {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfiguration.class
        );

    }
}
