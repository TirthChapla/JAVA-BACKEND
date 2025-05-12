package javaAnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car
{
    private String name;

    // @Autowired   // ❤️ Aane FIELD INJECTION kevai
    private Engine engine;

    public Car()
    {
        System.out.println("Car created using Default Constructor");
    }

    @Autowired  // ❤️ Aane CONSTRUCTION INJECTION kevai
    public Car(@Qualifier("CarBean") String name, Engine engine)
    {
        //✅ Now name is primitive data type so we have modify its inbuilt bean
        //✅ so we create one class : BeanContainer

        this.name=name;
        this.engine = engine;
        System.out.println("Car created using : Using Construction Injection");
    }

    public String getName() {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    //@Autowired  // ❤️ Aane SETTER INJECTION kevai
    public void setEngine(Engine engine)
    {
        this.engine = engine;
        System.out.println("Engine SET using Seter ");
    }

    public void start()
    {
        System.out.println(this.name + " Car is Created");
        engine.engineStart();
    }
}
