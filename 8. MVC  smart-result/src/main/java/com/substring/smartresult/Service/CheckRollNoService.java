package com.substring.smartresult.Service;

import com.substring.smartresult.Repository.CheckRollNo_Repo;
import com.substring.smartresult.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckRollNoService
{
    @Autowired
    CheckRollNo_Repo checkRollNo_repo;

    public Student checkRollNo(String rollNo)
    {
        // Check if the roll number exists in the database
        return checkRollNo_repo.findByRollNumber(rollNo);
    }

}
