package org.example.summerpractice.controller;

import org.example.summerpractice.dto.GenreDTO;
import org.example.summerpractice.repository.GenreRepository;
import org.example.summerpractice.service.genre.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDTO> getGenres() {
        return genreService.getGenres();
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable Long id) {
        return genreService.getGenre(id);
    }
}
