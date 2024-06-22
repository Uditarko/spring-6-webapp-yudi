package guru.springframework.yudi.spring6webappyudi.services;

import guru.springframework.yudi.spring6webappyudi.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
