package com.substring.smartresult.Service;

import com.substring.smartresult.Data_Holders.StudentHolders;
import com.substring.smartresult.Repository.ResultRepo;
import com.substring.smartresult.entities.Mark;
import com.substring.smartresult.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
public class ResultService
{
    @Autowired
    ResultRepo resultRepo;

    public String saveResult(StudentHolders studentHolders)
    {
        Student student = new Student();

        student.setId(UUID.randomUUID().toString());
        student.setName(studentHolders.getName());
        student.setRollNumber(studentHolders.getRollNumber());
        student.setEmail(studentHolders.getEmail());
        student.setSchoolName(studentHolders.getSchoolName());
        student.setDob(studentHolders.getDob());
        student.setGender(studentHolders.getGender());

        List<Mark> markList = studentHolders.getMarkList().stream().map(mark -> {

            Mark mark1 = new Mark();

            mark1.setSubject(mark.getSubject());
            mark1.setMarks(mark.getMarks());
            mark1.setMaxMarks(mark.getMaxMarks());
            mark1.setRemark(mark.getRemark());
            mark1.setGrade(mark.getGrade());
            mark1.setStudent(student);

            return mark1;
        }).collect(Collectors.toList());


        student.setMarkList(markList);

        //Save the student entity to the database
        resultRepo.save(student);

        return student.getId();
    }
}
