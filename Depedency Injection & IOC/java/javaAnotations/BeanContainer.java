package javaAnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
  
@Configuration
@ComponentScan(basePackages = "javaAnotations")
public class BeanContainer
{
    //✅ we have to make this class Configurations
    //✅ this will allow to manuplate the inbult beans

    //✅ we are manuplating String Class here
    //✅ 1. create a method like this.
    //✅ 2. Give @Bean anotation to it

    @Bean(name ="CarBean")
    public String carName()
    {
        return "BMW";
    }

    @Bean(name="EngineBean")
    public String engineName()
    {
        return "FORD";
    }




}
