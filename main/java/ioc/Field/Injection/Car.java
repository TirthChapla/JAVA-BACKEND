package ioc.Field.Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car
{
    @Autowired
    Engine engine;

    Car(){}

//    public Engine getEngine() {
//        return engine;
//    }


    void carStart()
    {
        System.out.println("Car Started");
    }



}
