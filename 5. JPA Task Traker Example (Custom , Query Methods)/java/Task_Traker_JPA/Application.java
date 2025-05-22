package Task_Traker_JPA;

import Task_Traker_JPA.Entity.Task;
import Task_Traker_JPA.Entity.TaskStatus;
import Task_Traker_JPA.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application implements CommandLineRunner
{

	@Autowired
	private TaskService taskService;

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{

		Task task = new Task();

		LocalDateTime start = LocalDateTime.now();

		LocalDateTime end = LocalDateTime.now().plusDays(2);

		task.setTitle("Learn DSA");
		task.setContent("Startd with basics");
		task.setCreatedAt(start);
		task.setCompletedAt(end);

		//✅ 1. Save Task
//		Task savedTask = taskService.saveTask(task);
//		System.out.println("Saved Task ID: " + savedTask.getId());

		//✅ 2. Get All Task
		taskService.getAllTask();

		//✅ 3. Get Task by Id
		taskService.getTaskById(1);

		//✅ 4. Get Task by status
		taskService.getByStatus(TaskStatus.Pending);

		//✅ 5. Get Task by Created Date
		taskService.getByCreatedDate(start);

		//✅ 6. Get Task by Completed Date
		taskService.getByCompletedDate(end);


		//✅ 7. Get All Task By Query Method ( @Query )
		taskService.getAll();

		//✅ 8. Get a Task By give ID using Query Method ( @Query )
		taskService.getTask_ById(1);

		//✅ 9. Get All Task By Query Method ( @NativeQuery )
		taskService.getAll_2();
	}
}
