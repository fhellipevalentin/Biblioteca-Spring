package github.fhellipe.com.library.controller;

import github.fhellipe.com.library.controller.utils.URL;
import github.fhellipe.com.library.model.Book;
import github.fhellipe.com.library.model.Genre;
import github.fhellipe.com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Book>> findPage( Model model,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="title") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<Book> list = service.search(page, linesPerPage, orderBy, direction);
        model.addAttribute("books", list);
        return ResponseEntity.ok().body(list);
    }
}
