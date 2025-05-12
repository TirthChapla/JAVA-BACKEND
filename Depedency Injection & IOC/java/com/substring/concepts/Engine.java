package com.substring.concepts;

public class Engine
{
    private String modelName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    Engine()
    {}

    Engine(String modelName)
    {
        this.modelName = modelName;

    }

    public void engineStart()
    {
        System.out.println(this.modelName + " Engine is Started");

    }

}
