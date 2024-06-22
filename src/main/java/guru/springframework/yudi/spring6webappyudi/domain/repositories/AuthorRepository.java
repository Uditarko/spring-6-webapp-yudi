package guru.springframework.yudi.spring6webappyudi.domain.repositories;

import guru.springframework.yudi.spring6webappyudi.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
