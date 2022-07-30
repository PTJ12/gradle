package cn.ut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("cn.ut.mapper")
@EnableOpenApi
public class GradleSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleSystemApplication.class, args);
    }


}
