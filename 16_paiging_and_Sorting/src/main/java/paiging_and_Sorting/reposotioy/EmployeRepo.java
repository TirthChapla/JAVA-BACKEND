package paiging_and_Sorting.reposotioy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paiging_and_Sorting.entity.Employee;

@Repository
public interface EmployeRepo extends JpaRepository<Employee , Integer>
{

}
