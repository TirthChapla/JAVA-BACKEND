package JAVA_and_Anotation_both_IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "JAVA_and_Anotation_both_IOC")
public class BeanContainer {

    @Bean(name ="fat")
    public String father() {
        return "Navnit";
    }

    @Bean(name ="mot")
    public String mother() {
        return "Rashmita";
    }

    @Bean(name ="chd")
    public String child() {
        return "Tirth";
    }
}
