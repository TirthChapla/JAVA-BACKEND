package quiz.category.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.category.entities.Category;

public interface CategoryRepo extends JpaRepository<Category , String>
{

}
