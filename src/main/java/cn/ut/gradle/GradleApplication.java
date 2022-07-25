package cn.ut.gradle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ut.gradle.mapper")
public class GradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleApplication.class, args);
    }

}
