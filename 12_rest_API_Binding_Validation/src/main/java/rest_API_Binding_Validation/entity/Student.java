package rest_API_Binding_Validation.entity;

import jakarta.validation.constraints.*;
import rest_API_Binding_Validation.Custom_Annotations.PassingMark;

public class Student
{
    @NotNull(message = "Roll No is Null")
    @Min(value = 1, message = "Roll No must be at least 1")
    @Max(value = 100, message = "Roll No too large")
    private Integer rollNo;

    @NotNull(message = "Name is Null")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
    private String name;

    @PassingMark
    @NotNull(message = "Mark is Null")
    @Min(value = 0, message = "Mark must be >= 0")
    @Max(value = 100, message = "Mark must be <= 100")
    private Integer mark;


    public Student()
    {}

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
