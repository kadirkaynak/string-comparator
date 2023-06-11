package com.kadirkaynak.stringcomparator;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class StringComparatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringComparatorApplication.class, args);
    }

    @Bean
    public OpenAPI constructOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("StringComparatorApplication")
                        .description("StringComparatorApplication")
                        .version("v1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
