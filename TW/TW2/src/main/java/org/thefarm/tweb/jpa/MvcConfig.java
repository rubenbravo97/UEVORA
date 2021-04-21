package org.thefarm.tweb.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/new-user").setViewName("new-user");
        registry.addViewController("/new-order").setViewName("new-order");
        registry.addViewController("/new-product").setViewName("new-product");
        registry.addViewController("/remove-product").setViewName("remove-product");


    }
}
