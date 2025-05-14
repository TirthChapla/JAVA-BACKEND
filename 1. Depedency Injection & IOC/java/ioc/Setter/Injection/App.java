package ioc.Setter.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main(String[] args) {
        System.out.println("Constructor Injection");

        ApplicationContext context = new AnnotationConfigApplicationContext("ioc.Setter.Injection");

        Car car = context.getBean(Car.class);
        car.carStart();

    }
}
