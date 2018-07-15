package com.evan.study;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Auther: Administrator
 * @Date: 2018/6/20 22:27
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.evan.study")
@EnableDubboConfiguration
@EnableCaching
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class);
    }

}
