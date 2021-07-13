package cn.moexc.ddd.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.moexc.ddd"})
@MapperScan("cn.moexc.ddd.infrastructure.dao")
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
