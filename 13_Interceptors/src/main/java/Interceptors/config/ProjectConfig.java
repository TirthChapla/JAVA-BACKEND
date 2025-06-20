package Interceptors.config;

import Interceptors.interceptors.CarInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfig implements WebMvcConfigurer
{
    @Autowired
    CarInterceptor carInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {

        registry.addInterceptor(carInterceptor)
                .addPathPatterns("/cars/**")
                .excludePathPatterns("/cars/delete");

    }
}
