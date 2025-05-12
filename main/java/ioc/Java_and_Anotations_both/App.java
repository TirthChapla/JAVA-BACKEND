package ioc.Java_and_Anotations_both;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanContainer.class);

        Parent p = context.getBean(Parent.class);
        p.parentInfo();

        context.close();
    }
}
