package github.fhellipe.com.library.controller;

import github.fhellipe.com.library.model.Book;
import github.fhellipe.com.library.repository.BookRepository;
import github.fhellipe.com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService service;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Book>> findPage( Model model,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="title") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Book> list = service.search(page, linesPerPage, orderBy, direction);
        model.addAttribute("books", list);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/add")
    public Book registerBook(@RequestBody Book book ) {
        book.setInstant(Instant.now());
        return bookRepository.save(book); // implementa isso aq depois
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook (@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public Book editBook(@PathVariable Integer id, @RequestBody Book book) {
        return service.update(id, book);
    }

}
