package paiging_and_Sorting.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import paiging_and_Sorting.entity.Employee;
import paiging_and_Sorting.service.EmployeeService;


@RestController
@RequestMapping("/")
public class EmployeController
{

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/get-employes")
    public Page<Employee> getAllEmployes(

            @RequestParam(value = "page" , defaultValue = "0") int page,
            @RequestParam(value = "size" , defaultValue = "10") int size,
            @RequestParam(value = "sortBy" , defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = "asc") String sortDir
    )
    {
        // return all Employees
        return employeeService.getAllEmployes(page , size , sortBy , sortDir);
    }


    @PostMapping("/add-employee")
    public String saveEmployee( @RequestBody Employee employee)
    {

        // Save Employee to DB
        String message= employeeService.saveEmployee(employee);

        return message;
    }

}
