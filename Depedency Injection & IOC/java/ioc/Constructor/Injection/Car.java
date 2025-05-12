package ioc.Constructor.Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car
{
    Engine engine;

    Car(){}

    @Autowired
    Car(Engine e)
    {
          this.engine=e;
    }

    void carStart()
    {
        System.out.println("Car Started");
    }

}
