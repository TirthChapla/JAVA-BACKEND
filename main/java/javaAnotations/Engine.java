package javaAnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Engine
{
    @Autowired @Qualifier("EngineBean")
    private String modelName;

    Engine()
    {
        System.out.println("Engine created using Default Constructor");
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    Engine(String modelName)
    {
        this.modelName = modelName;

    }

    public void engineStart()
    {
        System.out.println(this.modelName + " Engine is Started");

    }

}
