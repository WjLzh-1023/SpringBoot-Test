package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "com.dao")
@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMain.class,args);


    }
}
