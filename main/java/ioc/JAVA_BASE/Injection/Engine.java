package ioc.JAVA_BASE.Injection;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Engine
{
    Engine() {
        System.out.println("Engine Started");
    }
}
