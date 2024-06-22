package guru.springframework.yudi.spring6webappyudi.domain.repositories;

import guru.springframework.yudi.spring6webappyudi.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
