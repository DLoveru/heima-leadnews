package com.heima.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminJarApplication.class,args);
    }
}
