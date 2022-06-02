package br.edu.ufsj.tecweb.pigman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}

@SpringBootApplication
public class PigmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigmanApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new CorsConfiguration();
    }

}
