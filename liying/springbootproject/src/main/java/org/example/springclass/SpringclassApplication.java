package org.example.springclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.springclass.demos.web.mapper")
public class SpringclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringclassApplication.class, args);
    }

}
