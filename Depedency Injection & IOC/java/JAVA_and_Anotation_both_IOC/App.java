package JAVA_and_Anotation_both_IOC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanContainer.class);

        Parent parent = context.getBean("parent",Parent.class);
        parent.parentInfo();

        context.close();
    }
}
