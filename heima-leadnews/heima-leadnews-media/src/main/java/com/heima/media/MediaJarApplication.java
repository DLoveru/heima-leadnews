package com.heima.media;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.heima.model.mappers.*")
public class MediaJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaJarApplication.class,args);
    }
}
