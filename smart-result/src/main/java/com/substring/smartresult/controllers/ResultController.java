package com.substring.smartresult.controllers;

import com.substring.smartresult.Data_Holders.CheckRollNoHolders;
import com.substring.smartresult.Data_Holders.StudentHolders;
import com.substring.smartresult.Service.CheckRollNoService;
import com.substring.smartresult.Service.ResultService;
import com.substring.smartresult.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/results")
public class ResultController
{
    @Autowired
    ResultService resultService;

    @Autowired
    CheckRollNoService checkRollNoService;

    // roll number
    @RequestMapping("/input")
    public String viewResult() {
        System.out.println("Results page");
        return "view_result";
    }

    // view result
    @RequestMapping("/view")
    public String getResult() {
        // Logic to fetch and return the result
        return "result_data"; // Placeholder for actual result data
    }

    // add result
    @RequestMapping("/add-result")
    public String addResult(Model model) {

        StudentHolders studentHolders = new StudentHolders();

        model.addAttribute("studentHolders", studentHolders);


        return "add_result"; // Placeholder for actual result data
    }

    @RequestMapping(value="/result-added" , method = RequestMethod.POST)
    public String saveResult(@ModelAttribute StudentHolders studentHolders , Model model)
    {

        String studentId = resultService.saveResult(studentHolders);

        model.addAttribute("studentId", studentId);

        return "result-added"; // Placeholder for actual result data
    }


    @RequestMapping("/check-rollNo")
    public String checkRollNo( Model model)
    {
        CheckRollNoHolders checkRollNoHolders = new CheckRollNoHolders();

        model.addAttribute("checkRollNoHolders", checkRollNoHolders);

        //Student checkedStudent = checkRollNoService.checkRollNo(checkRollNoHolders.getRollNo());

        //System.out.println(checkedStudent.getName());

        return "check_rollNo";
    }

    @RequestMapping("/marksheet")
    public String displayMarksheet(@ModelAttribute CheckRollNoHolders checkRollNoHolders, Model model)
    {
        System.out.println("Roll number received: " + checkRollNoHolders.getRollNo());

        // Logic to fetch and display the marksheet based on roll number
        Student student = checkRollNoService.checkRollNo(checkRollNoHolders.getRollNo());

        if (student != null) {
            model.addAttribute("student", student);
            System.out.println("student got from roll number: " + student.getName());

            //Total Marks
            int totalMarks = student.getMarkList().stream().map(mark -> {
                return mark.getMaxMarks();
            }).mapToInt(Integer::intValue).sum();

            // Obtain Marks
            int obtainMarks = student.getMarkList().stream().map(mark -> {
                return mark.getMarks();
            }).mapToInt(Integer::intValue).sum();


            double percentage = (double) obtainMarks / totalMarks * 100;
            String grade = (percentage >= 90) ? "A+" : (percentage >= 80) ? "A" : "B";

//            model.addAttribute("student", student);
//            model.addAttribute("totalMarks", totalMarks);
//            model.addAttribute("obtainMarks", obtainMarks);
//            model.addAttribute("percentage", percentage);
//            model.addAttribute("overallGrade", grade);

            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Obtained Marks: " + obtainMarks);
            System.out.println("Percentage: " + percentage);
            System.out.println("Overall Grade: " + grade);


            model.addAttribute("obtainMarks", obtainMarks);
            model.addAttribute("totalMarks", totalMarks);
            model.addAttribute("percentage", percentage);
            model.addAttribute("overallGrade", grade);
            return "mark_sheet"; // Placeholder for actual marksheet view
        }
        else
        {
            System.out.println("Student not found with roll number");
            model.addAttribute("error", "Student not found with the provided roll number.");
            return "check_rollNo"; // Redirect back to check roll number page
        }
    }

}
