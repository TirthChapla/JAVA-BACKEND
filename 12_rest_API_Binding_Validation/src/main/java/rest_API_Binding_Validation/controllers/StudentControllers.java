package rest_API_Binding_Validation.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest_API_Binding_Validation.entity.Student;
import rest_API_Binding_Validation.service.StudentService;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentControllers
{

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{rollNo}")
    public Student getOneStudent(@PathVariable Integer rollNo)
    {
        return studentService.getOneStudent(rollNo);
    }

    @PostMapping
    public String addStudent(@Valid @RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

}
