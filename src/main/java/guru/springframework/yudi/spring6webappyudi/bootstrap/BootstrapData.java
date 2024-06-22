package guru.springframework.yudi.spring6webappyudi.bootstrap;

import guru.springframework.yudi.spring6webappyudi.domain.Author;
import guru.springframework.yudi.spring6webappyudi.domain.Book;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.AuthorRepository;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved =  authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE development without EJB");
        noEJB.setIsbn("987654");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(rodSaved);
        authorRepository.save(ericSaved);
        System.out.println("In Bootstrap");
        System.out.println("Author count : "+authorRepository.count());
        System.out.println("Book count : "+bookRepository.count());
    }
}
