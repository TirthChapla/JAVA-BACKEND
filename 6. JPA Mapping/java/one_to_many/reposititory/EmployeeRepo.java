package one_to_many.reposititory;


import one_to_many.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
    //❤️ Custoom Method to retrive data from DB

    List<Employee> findByDeparment_Cid(int cid);
}
