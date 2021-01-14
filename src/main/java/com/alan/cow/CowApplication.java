package com.alan.cow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CowApplication.class, args);
        System.out.println("***************************************");
        System.out.println("************启  动  成  功***************");
        System.out.println("");
        System.out.println("访问地址:   http://localhost:8001");
        System.out.println("");
        System.out.println("******复制访问地址到浏览器网址即可访问*******");
        System.out.println("***************************************");
    }

}
