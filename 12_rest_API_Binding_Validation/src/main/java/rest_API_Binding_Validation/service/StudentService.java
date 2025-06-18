package rest_API_Binding_Validation.service;

import org.springframework.stereotype.Service;
import rest_API_Binding_Validation.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService
{
    List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents()
    {
        return students;
    }

    public Student getOneStudent(Integer rollNo)
    {
        return this.students
                .stream()
                .filter(student -> student
                                            .getRollNo().equals(rollNo))
                .findFirst()
                .get();
    }


    public String addStudent(Student student)
    {
        students.add(student);
        return "Student-Added SuccesFully";
    }

}
