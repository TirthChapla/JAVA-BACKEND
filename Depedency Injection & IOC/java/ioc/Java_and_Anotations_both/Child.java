package ioc.Java_and_Anotations_both;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Child {
    public String childName;

    @Autowired
    public Child(@Qualifier("child") String childName) {
        this.childName = childName;
    }
}
