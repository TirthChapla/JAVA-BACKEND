package File_Uploding_Project.repository;

import File_Uploding_Project.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo  extends JpaRepository<Person,String>
{

}
