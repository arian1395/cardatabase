package com.packt.cardatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class EnvironmentConfig {

    /*
    if you put the currentFolder resource definition in CardatabaseApplication,
     you need to allow circular-references via application.properties
    */
    @Bean(name="currentFolder")
    public File getFile() {
        File file = new File(".");
        return file;
    }

}
