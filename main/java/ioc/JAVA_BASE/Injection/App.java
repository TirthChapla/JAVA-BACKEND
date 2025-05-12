package ioc.JAVA_BASE.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main(String[] args) {
        System.out.println("JAVA BASE CONFIGURATION");

        ApplicationContext context = new AnnotationConfigApplicationContext("ioc.JAVA_BASE.Injection");

        Car car = context.getBean(Car.class);
        car.carStart();

    }
}
