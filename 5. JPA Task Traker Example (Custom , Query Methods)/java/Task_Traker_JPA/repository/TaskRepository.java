package Task_Traker_JPA.repository;

import Task_Traker_JPA.Entity.Task;
import Task_Traker_JPA.Entity.TaskStatus;
import Task_Traker_JPA.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface  TaskRepository extends JpaRepository<Task, Integer>
{

    //❤️ Custom Method

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByCreatedAt(LocalDateTime date);

    List<Task> findByCompletedAt(LocalDateTime date);




    //❤️ Query Method


    @Query("Select t from Task t ")
    List<Task> givenAll();


    @Query("Select t from Task t  where t.id = ?1 ")
    Task  givenById(int id);

    @NativeQuery("Select * from jpa_tasks")
    List<Task> givenAll_2();

}
