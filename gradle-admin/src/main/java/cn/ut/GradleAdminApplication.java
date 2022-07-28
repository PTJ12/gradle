package cn.ut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("cn.ut.mapper")
@EnableOpenApi
public class GradleAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleAdminApplication.class, args);
    }

}
