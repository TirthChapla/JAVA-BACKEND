package Task_Traker_JPA.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="jpa_tasks")
public class Task
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //✅ this will increment id automatic
    private int id;

    @Column(name="task_name",length = 100, nullable = false , unique = true)
    private String title;

    @Column(name="task_description",length = 500)
    private String content;


    //✅ Here We created Enum : Using this we can use Specfic Constansts

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.Pending;


    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime completedAt;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompleatedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime compleatedAt) {
        this.completedAt = compleatedAt;
    }
}
