package JAVA_and_Anotation_both_IOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Child {
    public String childName;

    @Autowired
    public Child(@Qualifier("chd") String childName) {
        this.childName = childName;
    }
}
