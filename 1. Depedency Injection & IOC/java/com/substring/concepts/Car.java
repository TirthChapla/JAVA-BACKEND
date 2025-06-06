package com.substring.concepts;

public class Car {
    private String name;
    private Engine engine;

    public Car() {}

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start()
    {
        System.out.println(this.name + " Car is Created");
        engine.engineStart();
    }
}
