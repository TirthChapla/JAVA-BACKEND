package ioc.JAVA_BASE.Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Car
{

    Engine engine;

    Car(){}




    @Bean
    public Engine getEngine()       //Getter
    {
        return engine;
    }


    public void setEngine(Engine engine)       //Setter
    {
        this.engine = engine;
    }


    void carStart()
    {
        System.out.println("Car Started");
    }

}
