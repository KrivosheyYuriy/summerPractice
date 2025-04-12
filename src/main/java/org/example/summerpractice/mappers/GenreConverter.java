package org.example.summerpractice.mappers;

import org.example.summerpractice.dto.GenreDTO;
import org.example.summerpractice.entity.Genre;

public class GenreConverter {
    public static GenreDTO toGenreDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO(genre.getId(), genre.getTitle(), genre.getDescription());
        return genreDTO;
    }

    public static Genre toGenre(GenreDTO genreDTO) {
        Genre genre = new Genre(genreDTO.getTitle(), genreDTO.getDescription());
        return genre;
    }
}
