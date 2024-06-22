package guru.springframework.yudi.spring6webappyudi.services;

import guru.springframework.yudi.spring6webappyudi.domain.Author;
import guru.springframework.yudi.spring6webappyudi.domain.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
