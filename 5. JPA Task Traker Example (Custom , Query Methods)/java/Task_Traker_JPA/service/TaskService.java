package Task_Traker_JPA.service;

import Task_Traker_JPA.Entity.Task;
import Task_Traker_JPA.Entity.TaskStatus;
import Task_Traker_JPA.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService
{
    @Autowired
    public TaskRepository taskRepository;

    public Task  saveTask(Task task)
    {

        Task savedTask  = taskRepository.save(task);

        System.out.println("Tasked Saved To DB : " + savedTask.getId());

        task.setStatus(TaskStatus.Completed);

        return savedTask;
    }


    public Task getTaskById(int id)
    {
        Optional<Task> selectTask = taskRepository.findById(id);

        System.out.println("We get " + id);

        return selectTask
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public  void deleteTask(int id)
    {
        taskRepository.deleteById(id);

        System.out.println("Task we Deleted : " + id );

    }


    public List<Task> getAllTask()
    {
        List<Task> savedTask = taskRepository.findAll();

        System.out.println("We get All Task");

        return savedTask;

    }

    //❤️ Custom Method

    public List<Task> getByStatus(TaskStatus status)
    {
        List<Task> savedTask = taskRepository.findByStatus(status);

        System.out.println("Get Task By status : " + status);

        return savedTask;
    }

    public List<Task> getByCreatedDate(LocalDateTime date)
    {
        List<Task> savedTask = taskRepository.findByCreatedAt(date);

        System.out.println("Get task by Created Date  : " + date );

        return savedTask;
    }

    public List<Task> getByCompletedDate(LocalDateTime date )
    {
        List<Task> savedTask = taskRepository.findByCompletedAt(date);

        System.out.println("Get task by Completed Date  : " + date );

        return savedTask;
    }



    //❤️ Query Method


    public List<Task> getAll()
    {
        List<Task> savedTask =  taskRepository.givenAll();

        System.out.println("Get all Task by query Method ( @Query )  : givenAll() ");

        return savedTask;
    }

    public Task getTask_ById(int id)
    {
        Task task = taskRepository.givenById(id);

        System.out.println("Get given id Task by query Method ( @Query ) : givenByID() =  " + id);

        return task;
    }

    public List<Task> getAll_2()
    {
        List<Task> savedTask =  taskRepository.givenAll_2();

        System.out.println("Get all Task by query Method ( @NativeQuery ) : givenAll_2() ");

        return savedTask;
    }

}
