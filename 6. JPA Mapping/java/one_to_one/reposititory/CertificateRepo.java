package one_to_one.reposititory;

import one_to_one.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<Certificate , Integer>
{
}
