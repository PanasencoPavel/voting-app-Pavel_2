package com.usmteam3.votingapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

//    @Value("${upload.path}")
//    private String uploadPath;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");

    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry    registry) {
//        registry.addResourceHandler("/images/**")
//                .addResourceLocations( uploadPath + "/");
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }

}