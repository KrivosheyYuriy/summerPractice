package org.example.summerpractice.service.genre;

import org.example.summerpractice.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    public List<GenreDTO> getGenres();

    public GenreDTO getGenre(Long id);
}
