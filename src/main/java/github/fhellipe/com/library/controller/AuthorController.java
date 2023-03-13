package github.fhellipe.com.library.controller;

import github.fhellipe.com.library.model.Author;
import github.fhellipe.com.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }
}
