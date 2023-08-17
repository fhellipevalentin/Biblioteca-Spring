package github.fhellipe.com.library.services;

import github.fhellipe.com.library.model.Book;
import github.fhellipe.com.library.model.Genre;
import github.fhellipe.com.library.repository.BookRepository;
import github.fhellipe.com.library.repository.GenreRepository;
import github.fhellipe.com.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Book findById(Integer id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Book.class.getName()));
    }

    public Page<Book> search(Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);;
        return repository.findAll(pageable);
    }
    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }
        catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Não foi possível encontrar o Livro especificado" + id);
        }
    }

    public Book update(Integer id, Book book) {
        return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setTitle(book.getTitle());
                    recordFound.setQuantity(book.getQuantity());
                    recordFound.setCollection(book.getCollection());
                    recordFound.setAuthors(book.getAuthors());
                    recordFound.setGenres(book.getGenres());
                    recordFound.setManufacturingDate(book.getManufacturingDate());
                    recordFound.setPublicationDate(book.getPublicationDate());
                    return repository.save(recordFound);
                }).orElseThrow(() -> new ObjectNotFoundException("Não foi possivel encontrar o Livro especificado" + id));

    }


}
