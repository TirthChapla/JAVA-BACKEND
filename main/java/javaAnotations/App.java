package javaAnotations;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//        Engine e1 = new Engine("Ford");
//        Car c1 = new Car("Nexon",e1);

//        ❤️ XML Use kar ye tyre :-
//        ApplicationContext context = new ClassPathXmlApplicationContext("javaAnotationConfig.xml");
//
//        Car car = context.getBean("car" , Car.class);
//        car.start();

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanContainer.class);

        Car car = context.getBean("car" , Car.class);
        car.start();
    }





}

