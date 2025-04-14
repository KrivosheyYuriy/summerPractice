package org.example.summerpractice.service.genre;

import org.example.summerpractice.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    List<GenreDTO> getGenres();

    GenreDTO getGenreById(Long id);
}
