package ioc.Setter.Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car
{
    Engine engine;

    Car(){}

    public Engine getEngine() {
        return engine;
    }

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    void carStart()
    {
        System.out.println("Car Started");
    }



}
