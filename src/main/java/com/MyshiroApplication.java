package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.springboot.demo.dao", "com.springboot.demo.base.dao"})
public class MyshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshiroApplication.class, args);
    }

}
