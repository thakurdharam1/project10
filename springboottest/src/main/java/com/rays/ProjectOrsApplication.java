package com.rays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rays.common.FrontCtl;

/**
 * Suraj Sahu
 */
@SpringBootApplication
public class ProjectOrsApplication extends SpringBootServletInitializer {

    @Autowired
    private Environment env;

    @Autowired
    private FrontCtl frontCtl;

    public static void main(String[] args) {
        SpringApplication.run(ProjectOrsApplication.class, args);
    }

    /**
     * Enables CORS to all URLs (cross origin resource sharing).
     * 
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                CorsRegistration cors = registry.addMapping("/**");
                cors.allowedOrigins("http://localhost:4200");
                cors.allowedMethods("GET", "POST", "PUT", "DELETE");
                cors.allowCredentials(true);
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(frontCtl)
                        .addPathPatterns("/**")
                        .excludePathPatterns("/Auth/**", "/User/profilePic/**");
            }
        };
    }
}
