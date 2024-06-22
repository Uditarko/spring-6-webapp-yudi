package guru.springframework.yudi.spring6webappyudi.services;

import guru.springframework.yudi.spring6webappyudi.domain.Book;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
