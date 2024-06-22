package guru.springframework.yudi.spring6webappyudi.bootstrap;

import guru.springframework.yudi.spring6webappyudi.domain.Author;
import guru.springframework.yudi.spring6webappyudi.domain.Book;
import guru.springframework.yudi.spring6webappyudi.domain.Publisher;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.AuthorRepository;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.BookRepository;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Pearson");
        publisher.setAddress("Address 1");
        publisher.setCity("City 1");
        publisher.setState("State 1");
        publisher.setZip("1098735625");
        Publisher pearsonSaved = publisherRepository.save(publisher);

        pearsonSaved.getBooks().add(dddSaved);
        pearsonSaved.getBooks().add(noEJBSaved);
        pearsonSaved = publisherRepository.save(pearsonSaved);

        System.out.println("Publisher count : "+publisherRepository.count());
        System.out.println("Publisher book count : "+pearsonSaved.getBooks().size());
    }
}
