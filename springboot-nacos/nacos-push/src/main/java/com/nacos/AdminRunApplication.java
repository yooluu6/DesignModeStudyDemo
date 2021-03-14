package com.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: esgcc-cyanbird
 * @description: 启动类
 * @author: yjgl
 * @date: 2021-03-04 11:28
 **/
@SpringBootApplication
@NacosPropertySource(dataId = "Test", autoRefreshed = true)
public class AdminRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminRunApplication.class,args);
    }

}
