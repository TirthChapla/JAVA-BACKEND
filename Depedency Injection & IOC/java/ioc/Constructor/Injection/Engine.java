package ioc.Constructor.Injection;

import org.springframework.stereotype.Component;

@Component
public class Engine
{
    Engine() {
        System.out.println("Engine Started");
    }
}
