package one_to_many.reposititory;

import one_to_many.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparmentRepo extends JpaRepository<Deparment,Integer>
{
}
