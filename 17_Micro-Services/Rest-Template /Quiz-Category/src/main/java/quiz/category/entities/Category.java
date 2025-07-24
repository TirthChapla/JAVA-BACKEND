package quiz.category.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category
{
    @Id
    private String id;

    private String title;

    private String description;

    private boolean active;

}
