package com.heima.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/23 13:28
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaWebApplication.class, args);
    }
}
