package rest_API_Binding_Validation.Custom_Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Pass implements ConstraintValidator<PassingMark , Integer>
{
    @Override
    public boolean isValid(Integer mark, ConstraintValidatorContext constraintValidatorContext)
    {
        if(mark < 35 )
        {
        return false;

        }
        return true;
    }
}
