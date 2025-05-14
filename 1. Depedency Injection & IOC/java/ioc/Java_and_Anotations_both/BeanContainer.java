package ioc.Java_and_Anotations_both;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ioc.Java_and_Anotations_both")
public class BeanContainer {

    @Bean
    public String father() {
        return "Navnit";
    }

    @Bean
    public String mother() {
        return "Rashmita";
    }

    @Bean
    public String child() {
        return "Tirth";
    }
}
