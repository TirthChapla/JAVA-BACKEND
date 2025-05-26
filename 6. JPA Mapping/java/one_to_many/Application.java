package one_to_many;

import one_to_many.entity.Deparment;
import one_to_many.entity.Employee;
import one_to_many.reposititory.DeparmentRepo;
import one_to_many.reposititory.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	DeparmentRepo deparmentRepo;

	@Override
	public void run(String... args) throws Exception
	{
		//❤️ We are Adding Data to Data-Base...
//		saveToDB();

		//❤️ We are taking Data from Data-Base...
		List<Employee> emp = employeeRepo.findByDeparment_Cid(5);

        for (int i = 0; i < emp.size(); i++) {
            String name = emp.get(i).getName();
            System.out.println(name);
        }
	}

	public void saveToDB() {
		//❤️ This is for Data Adding...

		Deparment d1 = new Deparment();
		d1.setCode(111);
		d1.setTitle("Software Developer");

		Employee e1 = new Employee();
		e1.setName("Tirth");
		e1.setEmail("tirth@gmail.com");
		e1.setSalary(1500000);
		e1.setDeparment(d1);

		Employee e2 = new Employee();
		e2.setName("Harsh");
		e2.setEmail("Harsh@gmail.com");
		e2.setSalary(1200000);
		e2.setDeparment(d1);

		// Link employees to department
		List<Employee> empList = List.of(e1, e2);
		d1.setEmployee(empList);

		// Save department (which will cascade and save employees)
		deparmentRepo.save(d1);
	}
}
