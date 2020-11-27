package com.heima.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrawlerJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerJarApplication.class,args);
    }
}
