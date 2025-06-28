package paiging_and_Sorting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import paiging_and_Sorting.entity.Employee;
import paiging_and_Sorting.reposotioy.EmployeRepo;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    EmployeRepo employeRepo;

    //✅❤️ Paging n Sorting

    public Page<Employee> getAllEmployes(int page , int size , String sortBy , String srtDir)
    {

        //✅ 1. Sort: we use Conditional operator here
        Sort sort = sortDir.trim().toLowerCase().equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        //✅ 2. Pageable : it holds info. related to Paiging
        Pageable pageable = PageRequest.of(page,size,sort);

        //✅ 3. Page : It have info of Paiging + Content from DB
        Page<Employee> employees = employeRepo.findAll(pageable);

        return  employees;
    }




    public String saveEmployee(Employee employee)
    {
        //Save Employee to DB
        employeRepo.save(employee);

        return "Employee Saved SuccessFully";
    }


}
