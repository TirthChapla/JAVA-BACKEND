package quiz.category.dto;

import lombok.Data;

@Data
public class CategoryDto
{
    private String id;

    private String title;

    private String description;

    private boolean active;

}
