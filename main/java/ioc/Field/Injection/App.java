package ioc.Field.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main(String[] args) {
        System.out.println("Field Injection");

        ApplicationContext context = new AnnotationConfigApplicationContext("ioc.Field.Injection");

        Car car = context.getBean(Car.class);
        car.carStart();

    }
}
