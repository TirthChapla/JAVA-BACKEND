package ioc.Setter.Injection;

import org.springframework.stereotype.Component;

@Component
public class Engine
{
    Engine() {
        System.out.println("Engine Started");
    }
}
