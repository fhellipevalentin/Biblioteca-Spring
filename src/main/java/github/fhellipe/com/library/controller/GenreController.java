package github.fhellipe.com.library.controller;

import github.fhellipe.com.library.model.Genre;
import github.fhellipe.com.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/all")
    public List<Genre> getAllGenresA() {
        return genreService.findAll();
    }
}
