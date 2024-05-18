package com.maizi.quan.manager.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan ("com.maizi.quan.manager")
})
@MapperScan("com.maizi.quan.manager.mapper")
public class ManagerBeanConfig {
}
