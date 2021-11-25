package com.up.stores;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.up.stores.mapper")
//配置mapper接口位置
public class StoresApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoresApplication.class, args);
    }

}
