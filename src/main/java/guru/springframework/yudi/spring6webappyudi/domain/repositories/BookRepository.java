package guru.springframework.yudi.spring6webappyudi.domain.repositories;

import guru.springframework.yudi.spring6webappyudi.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
