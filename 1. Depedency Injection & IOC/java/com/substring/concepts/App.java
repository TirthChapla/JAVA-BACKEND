package com.substring.concepts;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//        Engine e1 = new Engine("Ford");
//        Car c1 = new Car("Nexon",e1);


        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Car car = context.getBean("car" , Car.class);
        car.start();
    }
}
