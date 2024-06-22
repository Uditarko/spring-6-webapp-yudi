package guru.springframework.yudi.spring6webappyudi.services;

import guru.springframework.yudi.spring6webappyudi.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
