package rest_API_Binding_Validation.Custom_Annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Pass.class)
public @interface PassingMark
{
    String message() default "Student Fail";

    Class <?>[] groups() default {};

    Class <? extends Payload> [] payload() default {};
}
