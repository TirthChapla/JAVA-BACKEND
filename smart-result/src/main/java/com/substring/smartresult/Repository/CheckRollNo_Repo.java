package com.substring.smartresult.Repository;

import com.substring.smartresult.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRollNo_Repo extends JpaRepository<Student,String>
{

    Student findByRollNumber(String rollNumber);

}
