/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.configs;

import com.nhb.validator.PassValidator;
import com.nhb.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author VIP
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.nhb")
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/"); 
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource 
                = new ResourceBundleMessageSource();
        resource.setBasename("messages");

        return resource;
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver 
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }
    
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        
        return bean;
    }

    @Override
    public Validator getValidator() {
       return validator();
    }
    
    @Bean
    public WebAppValidator userValidator() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new PassValidator());

        WebAppValidator validator = new WebAppValidator();
        validator.setSpringValidators(springValidators);

        return validator;
    }
}
