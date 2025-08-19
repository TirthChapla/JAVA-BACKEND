package quiz_App_Service.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;
import quiz_App_Service.collections.Quiz;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz, String>
{
    List<Quiz> findByTitle(String title);
    List<Quiz> findByCategoryId(String categoryId);
}
