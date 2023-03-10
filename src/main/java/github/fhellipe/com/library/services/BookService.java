package github.fhellipe.com.library.services;

import github.fhellipe.com.library.model.Book;
import github.fhellipe.com.library.model.Genre;
import github.fhellipe.com.library.repository.BookRepository;
import github.fhellipe.com.library.repository.GenreRepository;
import github.fhellipe.com.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    public Book findById(Integer id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Book.class.getName()));
    }

    public Page<Book> search(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);;
        return repository.findAll(pageable);
    }
}
