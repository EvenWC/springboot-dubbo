package com.evan.study.app;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 21:16
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.evan.study.app")
@EnableDubboConfiguration
@EnableCaching
public class AppUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppUserApplication.class);
    }
}
