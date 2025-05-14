package JAVA_and_Anotation_both_IOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Parent
{
    String fatherName;
    String motherName;
    Child c;

    @Autowired
    public Parent(@Qualifier("fat") String father,
                  @Qualifier("mot") String mother,
                  Child c)
    {
        this.fatherName = father;
        this.motherName = mother;
        this.c = c;
    }

    public void parentInfo() {
        System.out.println("Father: " + fatherName);
        System.out.println("Mother: " + motherName);
        System.out.println("Child: " + c.childName);
    }
}
