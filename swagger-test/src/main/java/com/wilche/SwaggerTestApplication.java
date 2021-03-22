package com.wilche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SwaggerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerTestApplication.class, args);
    }

}
